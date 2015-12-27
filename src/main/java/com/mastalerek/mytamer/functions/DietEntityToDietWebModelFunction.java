package com.mastalerek.mytamer.functions;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.google.common.base.Function;
import com.google.common.collect.Lists;
import com.mastalerek.mytamer.entity.Diet;
import com.mastalerek.mytamer.entity.DietMealSets;
import com.mastalerek.mytamer.entity.TrainingPlanDiet;
import com.mastalerek.mytamer.repository.DietMealSetsRepository;
import com.mastalerek.mytamer.repository.TrainingPlanDietRepository;
import com.mastalerek.mytamer.webmodel.DietWebModel;
import com.mastalerek.mytamer.webmodel.ObjectNameAndIdWebModel;

@Service
public class DietEntityToDietWebModelFunction implements Function<Diet, DietWebModel>{

	@Inject
	private DietMealSetsRepository dietMealSetsRepository;
	@Inject
	private TrainingPlanDietRepository trainingPlanDietRepository;
	@Inject
	private DietMealSetToObjectNameAndIdWebModelFunction dietMealSetToObjectNameAndIdWebModelFunction;
	@Inject
	private TrainingPlanToObjectNameAndIdWebModelFunction trainingPlanToObjectNameAndIdWebModelFunction;
	
	@Override
	public DietWebModel apply(Diet input) {
		DietWebModel output = new DietWebModel();
		output.setId(input.getId());
		output.setName(input.getName());
		output.setDescription(input.getDescription());
		setMealSets(input, output);
		setTrainingPlans(input, output);
		return output;
	}

	private void setTrainingPlans(Diet input, DietWebModel output) {
		List<ObjectNameAndIdWebModel> trainingPlans = Lists.newArrayList();
		List<TrainingPlanDiet> trainingPlanDiets = trainingPlanDietRepository.findByDietId(input.getId());
		for (TrainingPlanDiet trainingPlanDiet : trainingPlanDiets) {
			trainingPlans.add(trainingPlanToObjectNameAndIdWebModelFunction.apply(trainingPlanDiet.getTrainingPlan()));
		}
		output.setTrainingPlans(trainingPlans);
	}

	private void setMealSets(Diet input, DietWebModel output) {
		List<ObjectNameAndIdWebModel> mealSets = Lists.newArrayList();
		List<DietMealSets> dietMealSets = dietMealSetsRepository.findByDietId(input.getId());
		for (DietMealSets dietMealSet : dietMealSets) {
			mealSets.add(dietMealSetToObjectNameAndIdWebModelFunction.apply(dietMealSet.getMealSet()));
		}
		output.setMealSets(mealSets);
	}

}
