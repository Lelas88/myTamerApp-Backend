package com.mastalerek.mytamer.webapi.impl;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.Response;

import org.springframework.stereotype.Component;

import com.mastalerek.mytamer.service.MealSetService;
import com.mastalerek.mytamer.webapi.MealSetWebApi;
import com.mastalerek.mytamer.webmodel.MealSetWebModel;
import com.mastalerek.mytamer.webmodel.MealWebModel;

@Component
public class MealSetWebApiImpl implements MealSetWebApi {

	@Inject
	private MealSetService mealSetService;

	@Override
	public MealSetWebModel getMealSetDetails(Integer mealSetId) {
		return mealSetService.getMealSetDetails(mealSetId);
	}

	@Override
	public List<MealSetWebModel> getMealSetsList(Integer userId) {
		return mealSetService.getMealSetsList(userId);
	}

	@Override
	public List<MealWebModel> getAssignedMeals(Integer mealSetId) {
		return mealSetService.getAssignedMeals(mealSetId);
	}

	@Override
	public List<MealWebModel> getNotAssignedMeals(Integer mealSetId, Integer userId) {
		return mealSetService.getNotAssignedMeals(mealSetId, userId);
	}

	@Override
	public Response saveMealSet(MealSetWebModel mealSetWebModel) {
		Integer mealSetId = mealSetService.saveMealSet(mealSetWebModel);
		return Response.ok().entity(Entity.text(String.valueOf(mealSetId))).build();
	}

	@Override
	public Response updateMealSet(MealSetWebModel mealSetWebModel) {
		mealSetService.updateMealSet(mealSetWebModel);
		return Response.ok().build();
	}

	@Override
	public Response deleteMealSet(Integer mealSetId) {
		mealSetService.deleteMealSet(mealSetId);
		return Response.ok().build();
	}

	@Override
	public Response assignMeal(Integer mealSetId, List<Integer> mealIds) {
		mealSetService.assignMeal(mealSetId, mealIds);
		return Response.ok().build();
	}

	@Override
	public Response unassignMeal(Integer mealSetId, Integer mealId) {
		mealSetService.unassignMeal(mealSetId, mealId);
		return Response.ok().build();
	}

}
