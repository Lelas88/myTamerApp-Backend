package com.mastalerek.mytamer.webapi.impl;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.Response;

import org.springframework.stereotype.Component;

import com.mastalerek.mytamer.service.ExerciseService;
import com.mastalerek.mytamer.service.ExerciseSetService;
import com.mastalerek.mytamer.webapi.ExerciseSetWebApi;
import com.mastalerek.mytamer.webmodel.ExerciseSetWebModel;
import com.mastalerek.mytamer.webmodel.ExerciseWebModel;

@Component
public class ExerciseSetWebApiImpl implements ExerciseSetWebApi {

	@Inject
	private ExerciseSetService exerciseSetService;
	@Inject
	private ExerciseService exerciseService;
	
	@Override
	public List<ExerciseSetWebModel> getExercisesAssignedToTrainingPlan(Integer trainingPlanId) {
		return exerciseSetService.getExercisesAssignedToTrainingPlan(trainingPlanId);
	}

	@Override
	public List<ExerciseSetWebModel> getExerciseSetsByUserId(Integer userId) {
		return exerciseSetService.getExerciseSetsByUserId(userId);
	}

	@Override
	public ExerciseSetWebModel getExerciseSetDetails(Integer exerciseSetId) {
		return exerciseSetService.getExerciseSetDetails(exerciseSetId);
	}

	@Override
	public Response saveExerciseSet(ExerciseSetWebModel exerciseSetWebModel) {
		Integer exerciseSetId = exerciseSetService.saveExerciseSet(exerciseSetWebModel);
		return Response.ok().entity(Entity.text(String.valueOf(exerciseSetId))).build();
	}

	@Override
	public Response updateExerciseSet(ExerciseSetWebModel exerciseSetWebModel) {
		exerciseSetService.updateExerciseSet(exerciseSetWebModel);
		return Response.ok().build();
	}

	@Override
	public Response assignExercises(Integer exerciseSetId, List<Integer> exerciseIds) {
		exerciseSetService.assignExercises(exerciseSetId, exerciseIds);
		return Response.ok().build();
	}

	@Override
	public Response unassignExercise(Integer exerciseSetId, Integer exerciseId) {
		exerciseSetService.unassignExercise(exerciseSetId, exerciseId);
		return Response.ok().build();
	}

	@Override
	public Response deleteExerciseSet(Integer exerciseSetId) {
		exerciseSetService.deleteExerciseSet(exerciseSetId);
		return Response.ok().build();
	}

	@Override
	public List<ExerciseWebModel> getExercisesNotAssignedToExerciseSet(Integer exerciseSetId) {
		return exerciseService.getExercisesNotAssignedToExerciseSet(exerciseSetId);
	}

}
