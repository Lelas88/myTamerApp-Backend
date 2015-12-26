package com.mastalerek.mytamer.webapi.impl;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Component;

import com.mastalerek.mytamer.service.MealService;
import com.mastalerek.mytamer.webapi.MealWebApi;
import com.mastalerek.mytamer.webmodel.MealWebModel;

@Component
public class MealWebApiImpl implements MealWebApi {

	@Inject
	private MealService mealService;
	
	@Override
	public List<MealWebModel> getUserMeals(Integer userId) {
		return mealService.getUserMeals(userId);
	}

	@Override
	public MealWebModel getMealDetails(Integer mealId) {
		return mealService.getMealDetails(mealId);
	}

}
