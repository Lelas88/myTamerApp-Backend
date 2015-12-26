package com.mastalerek.mytamer.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Component;

import com.google.common.collect.Lists;
import com.mastalerek.mytamer.entity.Meal;
import com.mastalerek.mytamer.functions.MealToMealWebModelFunction;
import com.mastalerek.mytamer.repository.MealRepository;
import com.mastalerek.mytamer.webmodel.MealWebModel;

@Component
public class MealService {
	
	@Inject
	private MealRepository mealRepository;
	@Inject
	private MealToMealWebModelFunction mealToMealWebModelFunction;
	
	public List<MealWebModel> getUserMeals(Integer userId) {
		List<Meal> meals = mealRepository.findByUserId(userId);
		return Lists.transform(meals, mealToMealWebModelFunction);
	}

	public MealWebModel getMealDetails(Integer mealId) {
		return mealToMealWebModelFunction.apply(mealRepository.findOne(mealId));
	}

}
