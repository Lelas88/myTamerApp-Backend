package com.mastalerek.mytamer.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Component;

import com.mastalerek.mytamer.entity.ExerciseSet;
import com.mastalerek.mytamer.functions.ExerciseSetListToExerciseSetWebModelListFunction;
import com.mastalerek.mytamer.repository.ExerciseSetRepository;
import com.mastalerek.mytamer.webmodel.ExerciseSetWebModel;

@Component
public class ExerciseSetService {
	
//	@Inject
//	private ExerciseSetRepository exerciseSetRepository;
	@Inject
	private ExerciseSetListToExerciseSetWebModelListFunction exerciseSetListToExerciseSetWebModelListFunction;

	public List<ExerciseSetWebModel> getExercisesAssignedToTrainingPlan(Integer trainingPlanId) {
//		List<ExerciseSet> studentExerciseSets = exerciseSetRepository.findByTrainingPlanId(trainingPlanId);
//		return exerciseSetListToExerciseSetWebModelListFunction.apply(studentExerciseSets);
		return null;
	}
}
