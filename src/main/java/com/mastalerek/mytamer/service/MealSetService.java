package com.mastalerek.mytamer.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Component;

import com.mastalerek.mytamer.entity.Meal;
import com.mastalerek.mytamer.entity.MealSet;
import com.mastalerek.mytamer.entity.MealSetMeals;
import com.mastalerek.mytamer.functions.MealSetEntityToMealSetWebModelFunction;
import com.mastalerek.mytamer.functions.MealToMealWebModelFunction;
import com.mastalerek.mytamer.repository.MealRepository;
import com.mastalerek.mytamer.repository.MealSetMealRepository;
import com.mastalerek.mytamer.repository.MealSetRepository;
import com.mastalerek.mytamer.repository.UserRepository;
import com.mastalerek.mytamer.webmodel.MealSetWebModel;
import com.mastalerek.mytamer.webmodel.MealWebModel;

import jersey.repackaged.com.google.common.collect.Lists;

@Component
public class MealSetService {

	@Inject
	private MealSetRepository mealSetRepository;
	@Inject
	private MealSetMealRepository mealSetMealRepository;
	@Inject
	private MealRepository mealRepository;
	@Inject
	private MealSetEntityToMealSetWebModelFunction mealSetEntityToMealSetWebModelFunction;
	@Inject
	private MealToMealWebModelFunction mealToMealWebModelFunction;
	@Inject	
	private UserRepository userRepository;

	public MealSetWebModel getMealSetDetails(Integer mealSetId) {
		return mealSetEntityToMealSetWebModelFunction.apply(mealSetRepository.findOne(mealSetId));
	}

	public List<MealSetWebModel> getMealSetsList(Integer userId) {
		List<MealSetWebModel> result = Lists.newArrayList();
		List<MealSet> mealSets = mealSetRepository.findByUserId(userId);
		for (MealSet mealSet : mealSets) {
			MealSetWebModel mealSetWebModel = mealSetEntityToMealSetWebModelFunction.apply(mealSet);
			result.add(mealSetWebModel);
		}
		return result;
	}

	public List<MealWebModel> getAssignedMeals(Integer mealSetId) {
		List<MealWebModel> output = Lists.newArrayList();
		List<MealSetMeals> mealSetMeals = mealSetMealRepository.findByMealSetId(mealSetId);
		List<Meal> meals = Lists.newArrayList();
		mealSetMeals.forEach(e -> meals.add(e.getMeal()));
		meals.forEach(e -> output.add(mealToMealWebModelFunction.apply(e)));
		return output;
	}

	public List<MealWebModel> getNotAssignedMeals(Integer mealSetId, Integer userId) {
		List<MealWebModel> output = Lists.newArrayList();
		List<Meal> meals = mealRepository.findMealsNotAssignedToMealSet(mealSetId, userId);
		meals.forEach(e -> output.add(mealToMealWebModelFunction.apply(e)));
		return output;
	}

	public Integer saveMealSet(MealSetWebModel mealSetWebModel) {
		MealSet mealSet = new MealSet();
		mealSet.setName(mealSetWebModel.getName());
		mealSet.setUser(userRepository.findOne(mealSetWebModel.getUserId()));
		MealSet savedMealSet = mealSetRepository.save(mealSet);
		return savedMealSet.getId();
	}

	public void updateMealSet(MealSetWebModel mealSetWebModel) {
		MealSet mealSet = mealSetRepository.findOne(mealSetWebModel.getId());
		mealSet.setName(mealSetWebModel.getName());
		mealSetRepository.save(mealSet);
	}

	public void deleteMealSet(Integer mealSetId) {
		MealSet mealSet = mealSetRepository.findOne(mealSetId);
		mealSetRepository.delete(mealSet);
	}

	public void assignMeal(Integer mealSetId, List<Integer> mealIds) {
		MealSet mealSet = mealSetRepository.findOne(mealSetId);
		for (Integer mealId : mealIds) {
			Meal meal = mealRepository.findOne(mealId);
			MealSetMeals mealSetMeals = new MealSetMeals();
			mealSetMeals.setMeal(meal);
			mealSetMeals.setMealSet(mealSet);
			mealSetMealRepository.save(mealSetMeals);
		}
	}

	public void unassignMeal(Integer mealSetId, Integer mealId) {
		MealSetMeals mealSetMeals = mealSetMealRepository.findByMealSetIdAndMealId(mealSetId, mealId);
		mealSetMealRepository.delete(mealSetMeals);
	}
}
