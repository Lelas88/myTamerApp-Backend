package com.mastalerek.mytamer.webapi.impl;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.Response;

import org.springframework.stereotype.Component;

import com.mastalerek.mytamer.service.DietService;
import com.mastalerek.mytamer.webapi.DietWebApi;
import com.mastalerek.mytamer.webmodel.DietWebModel;
import com.mastalerek.mytamer.webmodel.MealSetWebModel;
import com.mastalerek.mytamer.webmodel.TrainingPlanWebModel;

@Component
public class DietWebApiImpl implements DietWebApi {

	@Inject
	private DietService dietService;

	@Override
	public DietWebModel getDietDetails(Integer dietId) {
		return dietService.getDietDetails(dietId);
	}

	@Override
	public List<DietWebModel> getUserDiets(Integer userId) {
		return dietService.getUserDiets(userId);
	}

	@Override
	public Response saveDiet(DietWebModel dietWebModel) {
		Integer dietId = dietService.saveDiet(dietWebModel);
		return Response.ok().entity(Entity.text(String.valueOf(dietId))).build();
	}

	@Override
	public Response modifyDiet(DietWebModel dietWebModel) {
		dietService.modifyDiet(dietWebModel);
		return Response.ok().build();
	}

	@Override
	public Response deleteDiet(Integer dietId) {
		dietService.deleteDiet(dietId);
		return Response.ok().build();
	}

	@Override
	public Response assignDietToTrainingPlans(Integer dietId, List<Integer> trainingPlanIds) {
		dietService.assignDietToTrainingPlans(dietId, trainingPlanIds);
		return Response.ok().build();
	}

	@Override
	public Response assignMealSetsToDiet(Integer dietId, List<Integer> mealSetIds) {
		dietService.assignMealSetsToDiet(dietId, mealSetIds);
		return Response.ok().build();
	}

	@Override
	public Response unassignMealSetFromDiet(Integer dietId, Integer mealSetId) {
		dietService.unassignMealSetFromDiet(dietId, mealSetId);
		return Response.ok().build();
	}

	@Override
	public Response unassignDietFromTrainingPlan(Integer dietId, Integer trainingPlanId) {
		dietService.unassignDietFromTrainingPlan(dietId, trainingPlanId);
		return Response.ok().build();
	}

	@Override
	public List<TrainingPlanWebModel> getNotAssignedTrainingPlansToDiet(Integer dietId, Integer userId) {
		return dietService.getNotAssignedTrainingPlansToDiet(dietId, userId);
	}

	@Override
	public List<MealSetWebModel> getNotAssignedMealSetsToDiet(Integer dietId, Integer userId) {
		return dietService.getNotAssignedMealSetsToDiet(dietId, userId);
	}

}
