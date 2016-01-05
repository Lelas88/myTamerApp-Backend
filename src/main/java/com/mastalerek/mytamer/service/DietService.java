package com.mastalerek.mytamer.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Component;

import com.google.common.collect.Lists;
import com.mastalerek.mytamer.entity.Diet;
import com.mastalerek.mytamer.entity.DietMealSets;
import com.mastalerek.mytamer.entity.MealSet;
import com.mastalerek.mytamer.entity.TrainingPlan;
import com.mastalerek.mytamer.entity.TrainingPlanDiet;
import com.mastalerek.mytamer.functions.DietEntityToDietWebModelFunction;
import com.mastalerek.mytamer.functions.MealSetEntityToMealSetWebModelFunction;
import com.mastalerek.mytamer.functions.TrainingPlanToTrainingPlanWebModelFunction;
import com.mastalerek.mytamer.repository.DietMealSetsRepository;
import com.mastalerek.mytamer.repository.DietRepository;
import com.mastalerek.mytamer.repository.MealSetRepository;
import com.mastalerek.mytamer.repository.TrainingPlanDietRepository;
import com.mastalerek.mytamer.repository.TrainingPlanRepository;
import com.mastalerek.mytamer.repository.UserRepository;
import com.mastalerek.mytamer.webmodel.DietWebModel;
import com.mastalerek.mytamer.webmodel.MealSetWebModel;
import com.mastalerek.mytamer.webmodel.TrainingPlanWebModel;

@Component
public class DietService {

	@Inject
	private DietRepository dietRepository;
	@Inject
	private UserRepository userRepository;
	@Inject
	private TrainingPlanRepository trainingPlanRepository;
	@Inject
	private MealSetRepository mealSetRepository;
	@Inject
	private DietMealSetsRepository dietMealSetsRepository;
	@Inject
	private TrainingPlanDietRepository trainingPlanDietRepository;
	@Inject
	private DietEntityToDietWebModelFunction dietEntityToDietWebModelFunction;
	@Inject
	private TrainingPlanToTrainingPlanWebModelFunction trainingPlanToTrainingPlanWebModelFunction;
	@Inject
	private MealSetEntityToMealSetWebModelFunction mealSetEntityToMealSetWebModelFunction;

	public DietWebModel getDietDetails(Integer dietId) {
		return dietEntityToDietWebModelFunction.apply(dietRepository.findOne(dietId));
	}

	public List<DietWebModel> getUserDiets(Integer userId) {
		List<Diet> diets = dietRepository.findByUserId(userId);
		return Lists.transform(diets, dietEntityToDietWebModelFunction);
	}

	public List<DietWebModel> getNotAssignedDietsToTrainingPlan(Integer trainingPlanId, Integer userId) {
		List<Diet> diets = dietRepository.findNotAssignedToTrainingPlan(trainingPlanId, userId);
		return Lists.transform(diets, dietEntityToDietWebModelFunction);
	}

	public List<DietWebModel> getAssignedDietsToTrainingPlan(Integer trainingPlanId) {
		List<Diet> diets = dietRepository.findAssignedToTrainingPlan(trainingPlanId);
		return Lists.transform(diets, dietEntityToDietWebModelFunction);
	}

	public Integer saveDiet(DietWebModel dietWebModel) {
		Diet diet = new Diet();
		diet.setName(dietWebModel.getName());
		diet.setDescription(dietWebModel.getDescription());
		diet.setUser(userRepository.findOne(dietWebModel.getUserId()));
		diet.setActive(0);
		Diet savedDiet = dietRepository.save(diet);
		return savedDiet.getId();
	}

	public void modifyDiet(DietWebModel dietWebModel) {
		Diet diet = dietRepository.findOne(dietWebModel.getId());
		diet.setDescription(dietWebModel.getDescription());
		diet.setName(dietWebModel.getName());
		dietRepository.save(diet);
	}

	public void deleteDiet(Integer dietId) {
		Diet diet = dietRepository.findOne(dietId);
		dietRepository.delete(diet);
	}

	public void assignDietToTrainingPlans(Integer dietId, List<Integer> trainingPlanIds) {
		Diet diet = dietRepository.findOne(dietId);
		for (Integer trainingPlanId : trainingPlanIds) {
			TrainingPlan trainingPlan = trainingPlanRepository.findOne(trainingPlanId);
			TrainingPlanDiet trainingPlanDiet = new TrainingPlanDiet();
			trainingPlanDiet.setDiet(diet);
			trainingPlanDiet.setTrainingPlan(trainingPlan);
			trainingPlanDietRepository.save(trainingPlanDiet);
		}
	}

	public void assignMealSetsToDiet(Integer dietId, List<Integer> mealSetIds) {
		Diet diet = dietRepository.findOne(dietId);
		for (Integer mealSetId : mealSetIds) {
			MealSet mealSet = mealSetRepository.findOne(mealSetId);
			DietMealSets dietMealSet = new DietMealSets();
			dietMealSet.setDiet(diet);
			dietMealSet.setMealSet(mealSet);
			dietMealSetsRepository.save(dietMealSet);
		}
	}

	public void unassignMealSetFromDiet(Integer dietId, Integer mealSetId) {
		DietMealSets dietMealSet = dietMealSetsRepository.findByDietIdAndMealSetId(dietId, mealSetId);
		dietMealSetsRepository.delete(dietMealSet);
	}

	public void unassignDietFromTrainingPlan(Integer dietId, Integer trainingPlanId) {
		TrainingPlanDiet trainingPlanDiet = trainingPlanDietRepository.findByDietIdAndTrainingPlanId(dietId, trainingPlanId);
		trainingPlanDietRepository.delete(trainingPlanDiet);
	}

	public List<TrainingPlanWebModel> getNotAssignedTrainingPlansToDiet(Integer dietId, Integer userId) {
		List<TrainingPlan> trainingPlans = trainingPlanRepository.findTrainingPlansNotLinkedWithDiet(dietId, userId);
		return Lists.transform(trainingPlans, trainingPlanToTrainingPlanWebModelFunction);
	}

	public List<MealSetWebModel> getNotAssignedMealSetsToDiet(Integer dietId, Integer userId) {
		List<MealSet> mealSets = mealSetRepository.findMealSetsNotLinkedWithDiet(dietId, userId);
		return Lists.transform(mealSets, mealSetEntityToMealSetWebModelFunction);
	}
}
