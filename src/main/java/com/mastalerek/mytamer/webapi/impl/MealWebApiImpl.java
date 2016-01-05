package com.mastalerek.mytamer.webapi.impl;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.Response;

import org.springframework.stereotype.Component;

import com.mastalerek.mytamer.service.MealService;
import com.mastalerek.mytamer.webapi.MealWebApi;
import com.mastalerek.mytamer.webmodel.MealWebModel;
import com.mastalerek.mytamer.webmodel.NutritionWebModel;

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

	@Override
	public Response createMeal(MealWebModel meal) {
		Integer mealId = mealService.createMeal(meal);
		return Response.ok().entity(Entity.text(String.valueOf(mealId))).build();
	}

	@Override
	public Response modifyMeal(MealWebModel meal) {
		mealService.modifyMeal(meal);
		return Response.ok().build();
	}

	@Override
	public Response deleteMeal(Integer mealId) {
		mealService.deleteMeal(mealId);
		return Response.ok().build();
	}

	@Override
	public Response saveNutritions(Integer mealId, NutritionWebModel nutritions) {
		mealService.saveNutritions(mealId, nutritions);
		return Response.ok().build();
	}

	@Override
	public List<NutritionWebModel> getNutritions() {
		return mealService.getNutritions();
	}

	@Override
	public List<NutritionWebModel> getMealNutritions(Integer mealId) {
		return mealService.getMealNutritions(mealId);
	}

}
