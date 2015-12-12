package com.mastalerek.mytamer.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Component;

import com.google.common.collect.Lists;
import com.mastalerek.mytamer.entity.ExerciseSet;
import com.mastalerek.mytamer.entity.StudentTrainingPlan;
import com.mastalerek.mytamer.entity.TrainingPlan;
import com.mastalerek.mytamer.functions.ExerciseSetToExerciseSetBasicWebModel;
import com.mastalerek.mytamer.functions.StudentTrainingPlansToTrainingPlanBasicWebModelFunction;
import com.mastalerek.mytamer.functions.TrainingPlanToTrainingPlanWebModelFunction;
import com.mastalerek.mytamer.repository.StudentTrainingPlanRepository;
import com.mastalerek.mytamer.repository.TrainingPlanRepository;
import com.mastalerek.mytamer.webmodel.ExerciseSetBasicWebModel;
import com.mastalerek.mytamer.webmodel.TrainingPlanBasicWebModel;
import com.mastalerek.mytamer.webmodel.TrainingPlanWebModel;

@Component
public class TrainingPlanService {

	@Inject
	private TrainingPlanRepository trainingPlanRepository;
	@Inject
	private StudentTrainingPlanRepository studentTrainingPlanRepository;
	@Inject
	private StudentTrainingPlansToTrainingPlanBasicWebModelFunction studentTrainingPlansToTrainingPlanBasicWebModelFunction;
	@Inject
	private TrainingPlanToTrainingPlanWebModelFunction trainingPlanToTrainingPlanWebModelFunction;
	@Inject
	private ExerciseSetToExerciseSetBasicWebModel exerciseSetToExerciseSetBasicWebModel;

	public List<TrainingPlanBasicWebModel> getTrainingPlanNames(Integer studentId) {
		List<StudentTrainingPlan> studentTrainingPlans = studentTrainingPlanRepository.findByStudentId(studentId);
		return Lists.transform(studentTrainingPlans, studentTrainingPlansToTrainingPlanBasicWebModelFunction);
	}

	public TrainingPlanWebModel getTrainingPlanDetails(Integer trainingPlanId) {
		return trainingPlanToTrainingPlanWebModelFunction.apply(trainingPlanRepository.findOne(trainingPlanId));
	}

	public List<ExerciseSetBasicWebModel> getTrainingPlanExerciseSets(Integer trainingPlanId) {
		TrainingPlan trainingPlan = trainingPlanRepository.findOne(trainingPlanId);
		List<ExerciseSet> exerciseSets = trainingPlan.getExerciseSet();
		return Lists.transform(exerciseSets, exerciseSetToExerciseSetBasicWebModel);
	}

}
