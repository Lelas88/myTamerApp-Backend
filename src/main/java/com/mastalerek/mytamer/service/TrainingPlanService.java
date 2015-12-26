package com.mastalerek.mytamer.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Component;

import com.google.common.collect.Lists;
import com.mastalerek.mytamer.entity.StudentTrainingPlan;
import com.mastalerek.mytamer.entity.TrainingPlan;
import com.mastalerek.mytamer.entity.TrainingPlanExerciseSet;
import com.mastalerek.mytamer.functions.StudentTrainingPlansToTrainingPlanBasicWebModelFunction;
import com.mastalerek.mytamer.functions.TrainingPlanExerciseSetToExerciseSetBasicWebModelFunction;
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
	private TrainingPlanExerciseSetToExerciseSetBasicWebModelFunction trainingPlanExerciseSetToExerciseSetBasicWebModelFunction;

	public List<TrainingPlanBasicWebModel> getTrainingPlanNames(Integer studentId) {
		List<StudentTrainingPlan> studentTrainingPlans = getStudentTrainingPlans(studentId);
		return Lists.transform(studentTrainingPlans, studentTrainingPlansToTrainingPlanBasicWebModelFunction);
	}

	private List<StudentTrainingPlan> getStudentTrainingPlans(Integer studentId) {
		return studentTrainingPlanRepository.findByStudentId(studentId);
	}
	
	private List<Integer> getStudentTrainingPlanIds(Integer studentId) {
		List<Integer> output = Lists.newArrayList();
		List<StudentTrainingPlan> studentTrainingPlans = getStudentTrainingPlans(studentId);
		for (StudentTrainingPlan studentTrainingPlan : studentTrainingPlans) {
			output.add(studentTrainingPlan.getId());
		}
		return output;
	}

	public List<TrainingPlan> getTrainingPlansByStudentId(Integer studentId) {
		return trainingPlanRepository.findByIdIn(getStudentTrainingPlanIds(studentId));
	}
	
	public TrainingPlanWebModel getTrainingPlanDetails(Integer trainingPlanId) {
		return trainingPlanToTrainingPlanWebModelFunction.apply(trainingPlanRepository.findOne(trainingPlanId));
	}

	public List<ExerciseSetBasicWebModel> getTrainingPlanExerciseSets(Integer trainingPlanId) {
		TrainingPlan trainingPlan = trainingPlanRepository.findOne(trainingPlanId);
		List<TrainingPlanExerciseSet> exerciseSets = trainingPlan.getExerciseSets();
		return Lists.transform(exerciseSets, trainingPlanExerciseSetToExerciseSetBasicWebModelFunction);
	}

	public List<TrainingPlanWebModel> getUserTrainingPlans(Integer userId) {
		List<TrainingPlan> trainingPlans = trainingPlanRepository.findByUserId(userId);
		return Lists.transform(trainingPlans, trainingPlanToTrainingPlanWebModelFunction);
	}

}
