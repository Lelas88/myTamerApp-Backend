package com.mastalerek.mytamer.webapi.impl;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Component;

import com.mastalerek.mytamer.service.ExerciseService;
import com.mastalerek.mytamer.webapi.ExerciseWebApi;
import com.mastalerek.mytamer.webmodel.ExerciseWebModel;
import com.mastalerek.mytamer.webmodel.StudentExerciseWebModel;

@Component
public class ExerciseWebApiImpl implements ExerciseWebApi {

	@Inject
	private ExerciseService exerciseService;

	@Override
	public List<ExerciseWebModel> getByDisciplineId(Integer disciplineId) {
		return exerciseService.getByDisciplineId(disciplineId);
	}

	@Override
	public List<StudentExerciseWebModel> getStudentExercises(Integer studentId) {
		return exerciseService.getStudentExercises(studentId);
	}
}
