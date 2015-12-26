package com.mastalerek.mytamer.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Component;

import com.mastalerek.mytamer.entity.ExerciseSet;
import com.mastalerek.mytamer.entity.TrainingPlan;
import com.mastalerek.mytamer.entity.TrainingPlanExerciseSet;
import com.mastalerek.mytamer.functions.ExerciseSetToExerciseSetWebModelFunction;
import com.mastalerek.mytamer.repository.ExerciseSetRepository;
import com.mastalerek.mytamer.repository.TrainingPlanRepository;
import com.mastalerek.mytamer.webmodel.ExerciseSetWebModel;

import jersey.repackaged.com.google.common.collect.Lists;

@Component
public class ExerciseSetService {
	@Inject
	private ExerciseSetRepository exerciseSetRepository;
	@Inject
	private TrainingPlanRepository trainingPlanRepository;
	@Inject
	private ExerciseSetToExerciseSetWebModelFunction exerciseSetToExerciseSetWebModelFunction;

	public List<ExerciseSetWebModel> getExercisesAssignedToTrainingPlan(Integer trainingPlanId) {
		List<ExerciseSetWebModel> result = Lists.newArrayList();
		TrainingPlan trainingPlan = trainingPlanRepository.findOne(trainingPlanId);
		List<TrainingPlanExerciseSet> trainingPlanExerciseSets = trainingPlan.getExerciseSets();
		for (TrainingPlanExerciseSet trainingPlanExerciseSet : trainingPlanExerciseSets) {
			result.add(exerciseSetToExerciseSetWebModelFunction.apply(trainingPlanExerciseSet.getExerciseSet()));
		}
		return result;
	}

	public List<ExerciseSetWebModel> getExerciseSetsByUserId(Integer userId) {
		List<ExerciseSetWebModel> result = Lists.newArrayList();
		List<ExerciseSet> exerciseSets = exerciseSetRepository.findByUserId(userId);
		for (ExerciseSet exerciseSet : exerciseSets) {
			ExerciseSetWebModel exerciseSetWebModel = exerciseSetToExerciseSetWebModelFunction.apply(exerciseSet);
			result.add(exerciseSetWebModel);
		}
		return result;
	}

	public ExerciseSetWebModel getExerciseSetDetails(Integer exerciseSetId) {
		ExerciseSet exerciseSet = exerciseSetRepository.findOne(exerciseSetId);
		return exerciseSetToExerciseSetWebModelFunction.apply(exerciseSet);
	}

}
