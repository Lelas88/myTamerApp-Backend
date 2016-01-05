package com.mastalerek.mytamer.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Component;

import com.mastalerek.mytamer.entity.Exercise;
import com.mastalerek.mytamer.entity.ExerciseSet;
import com.mastalerek.mytamer.entity.ExerciseSetExercise;
import com.mastalerek.mytamer.entity.TrainingPlan;
import com.mastalerek.mytamer.entity.TrainingPlanExerciseSet;
import com.mastalerek.mytamer.entity.User;
import com.mastalerek.mytamer.functions.ExerciseSetToExerciseSetWebModelFunction;
import com.mastalerek.mytamer.repository.ExerciseRepository;
import com.mastalerek.mytamer.repository.ExerciseSetExerciseRepository;
import com.mastalerek.mytamer.repository.ExerciseSetRepository;
import com.mastalerek.mytamer.repository.TrainingPlanRepository;
import com.mastalerek.mytamer.repository.UserRepository;
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
	@Inject
	private UserRepository userRepository;
	@Inject
	private ExerciseRepository exerciseRepository;
	@Inject
	private ExerciseSetExerciseRepository exerciseSetExerciseRepository;

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

	public Integer saveExerciseSet(ExerciseSetWebModel exerciseSetWebModel) {
		ExerciseSet exerciseSet = new ExerciseSet();
		exerciseSet.setName(exerciseSetWebModel.getName());
		exerciseSet.setTime(exerciseSetWebModel.getExerciseLength());
		User user = userRepository.findOne(exerciseSetWebModel.getUserId());
		exerciseSet.setUser(user);
		ExerciseSet savedExerciseSet = exerciseSetRepository.save(exerciseSet);
		return savedExerciseSet.getId();
	}

	public void updateExerciseSet(ExerciseSetWebModel exerciseSetWebModel) {
		ExerciseSet exerciseSet = exerciseSetRepository.findOne(exerciseSetWebModel.getId());
		exerciseSet.setName(exerciseSetWebModel.getName());
		exerciseSet.setTime(exerciseSetWebModel.getExerciseLength());
		exerciseSetRepository.save(exerciseSet);
	}

	public void assignExercises(Integer exerciseSetId, List<Integer> exerciseIds) {
		ExerciseSet exerciseSet = exerciseSetRepository.findOne(exerciseSetId);
		for (Integer exerciseId : exerciseIds) {
			Exercise exercise = exerciseRepository.findOne(exerciseId);
			ExerciseSetExercise exerciseSetExercise = new ExerciseSetExercise();
			exerciseSetExercise.setExercise(exercise);
			exerciseSetExercise.setExerciseSet(exerciseSet);
			exerciseSetExerciseRepository.save(exerciseSetExercise);
		}
	}

	public void unassignExercise(Integer exerciseSetId, Integer exerciseId) {
		ExerciseSetExercise exerciseSetExercise = exerciseSetExerciseRepository
				.findByExerciseSetIdAndExerciseId(exerciseSetId, exerciseId);
		exerciseSetExerciseRepository.delete(exerciseSetExercise);
	}

	public void deleteExerciseSet(Integer exerciseSetId) {
		exerciseSetRepository.delete(exerciseSetId);
	}

	public List<ExerciseSetWebModel> getNotAssignedExerciseSetsToTrainingPlan(Integer trainingPlanId, Integer userId) {
		List<ExerciseSet> exerciseSets = exerciseSetRepository.findNotAssignedToTrainingPlan(trainingPlanId, userId);
		List<ExerciseSetWebModel> output = Lists.newArrayList();
		for (ExerciseSet exerciseSet : exerciseSets) {
			output.add(exerciseSetToExerciseSetWebModelFunction.apply(exerciseSet));
		}
		return output;
	}

	public List<ExerciseSetWebModel> getAssignedExerciseSetsToTrainingPlan(Integer trainingPlanId) {
		List<ExerciseSet> exerciseSets = exerciseSetRepository.findAssignedToTrainingPlan(trainingPlanId);
		List<ExerciseSetWebModel> output = Lists.newArrayList();
		for (ExerciseSet exerciseSet : exerciseSets) {
			output.add(exerciseSetToExerciseSetWebModelFunction.apply(exerciseSet));
		}
		return output;
	}

}
