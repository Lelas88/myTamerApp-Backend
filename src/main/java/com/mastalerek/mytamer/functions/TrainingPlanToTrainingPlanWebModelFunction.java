package com.mastalerek.mytamer.functions;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.google.common.base.Function;
import com.google.common.collect.Lists;
import com.mastalerek.mytamer.entity.StudentTrainingPlan;
import com.mastalerek.mytamer.entity.TrainingPlan;
import com.mastalerek.mytamer.repository.StudentTrainingPlanRepository;
import com.mastalerek.mytamer.webmodel.TrainingPlanWebModel;

@Service
public class TrainingPlanToTrainingPlanWebModelFunction implements Function<TrainingPlan, TrainingPlanWebModel> {

	@Inject
	private DietToDietBasicWebModelFunction dietToDietBasicWebModelFunction;
	@Inject
	private TrainingPlanExerciseSetToExerciseSetBasicWebModelFunction exerciseSetToExerciseSetBasicWebModelFunction;
	@Inject
	private StudentTrainingPlanRepository studentTrainingPlanRepository;
	@Inject
	private StudentTrainingPlanToStudentNameWebModelFunction studentTrainingPlanToStudentNameWebModelFunction;

	@Override
	public TrainingPlanWebModel apply(TrainingPlan input) {
		TrainingPlanWebModel output = new TrainingPlanWebModel();
		output.setId(input.getId());
		output.setName(input.getName());
		output.setDescription(input.getDescription());
		output.setDiets(Lists.transform(input.getTrainingPlanDiets(), dietToDietBasicWebModelFunction));
		output.setExerciseSets(Lists.transform(input.getExerciseSets(), exerciseSetToExerciseSetBasicWebModelFunction));
		List<StudentTrainingPlan> studentTrainingPlans = studentTrainingPlanRepository.findByTrainingPlanId(input.getId());
		output.setStudents(Lists.transform(studentTrainingPlans, studentTrainingPlanToStudentNameWebModelFunction));
		return output;
	}

}
