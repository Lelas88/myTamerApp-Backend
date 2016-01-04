package com.mastalerek.mytamer.functions;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.google.common.base.Function;
import com.google.common.collect.Lists;
import com.mastalerek.mytamer.entity.ExerciseSet;
import com.mastalerek.mytamer.entity.TrainingPlan;
import com.mastalerek.mytamer.entity.TrainingPlanExerciseSet;
import com.mastalerek.mytamer.repository.TrainingPlanExerciseSetRepository;
import com.mastalerek.mytamer.repository.TrainingPlanRepository;
import com.mastalerek.mytamer.webmodel.ExerciseSetWebModel;
import com.mastalerek.mytamer.webmodel.ObjectNameAndIdWebModel;

@Service
public class ExerciseSetToExerciseSetWebModelFunction implements Function<ExerciseSet, ExerciseSetWebModel> {

	@Inject
	private TrainingPlanToObjectNameAndIdWebModelFunction trainingPlanToObjectNameAndIdWebModelFunction;
	@Inject
	private ExerciseToObjectNameAndIdWebModelFunction exerciseToObjectNameAndIdWebModelFunction;
	@Inject
	private TrainingPlanExerciseSetRepository trainingPlanExerciseSetRepository;
	@Inject
	private TrainingPlanRepository trainingPlanRepository;

	@Override
	public ExerciseSetWebModel apply(ExerciseSet input) {
		ExerciseSetWebModel output = new ExerciseSetWebModel();
		output.setId(input.getId());
		output.setName(input.getName());
		output.setExerciseLength(input.getTime());
		output.setUserId(input.getUser().getId());
		setExercises(input, output);
		setTrainingPlans(input, output);
		return output;
	}

	private void setExercises(ExerciseSet input, ExerciseSetWebModel output) {
		List<ObjectNameAndIdWebModel> exercises = Lists.transform(input.getExercises(),
				exerciseToObjectNameAndIdWebModelFunction);
		output.setExercises(exercises);
	}

	private void setTrainingPlans(ExerciseSet input, ExerciseSetWebModel output) {
		List<TrainingPlanExerciseSet> trainingPlanExerciseSets = trainingPlanExerciseSetRepository
				.findByExerciseSetId(input.getId());
		List<ObjectNameAndIdWebModel> trainingPlans = Lists.newArrayList();
		for (TrainingPlanExerciseSet trainingPlanExerciseSet : trainingPlanExerciseSets) {
			TrainingPlan trainingPlan = trainingPlanRepository
					.findOne(trainingPlanExerciseSet.getTrainingPlan().getId());
			trainingPlans.add(trainingPlanToObjectNameAndIdWebModelFunction.apply(trainingPlan));
		}
		output.setTrainingPlans(trainingPlans);
	}

}
