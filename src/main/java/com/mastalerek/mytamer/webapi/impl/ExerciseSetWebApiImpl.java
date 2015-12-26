package com.mastalerek.mytamer.webapi.impl;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Component;

import com.mastalerek.mytamer.service.ExerciseSetService;
import com.mastalerek.mytamer.webapi.ExerciseSetWebApi;
import com.mastalerek.mytamer.webmodel.ExerciseSetWebModel;

@Component
public class ExerciseSetWebApiImpl implements ExerciseSetWebApi {

	@Inject
	private ExerciseSetService exerciseSetService;
	
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

}
