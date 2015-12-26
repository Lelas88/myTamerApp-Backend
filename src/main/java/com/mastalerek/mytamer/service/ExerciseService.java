package com.mastalerek.mytamer.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.google.common.collect.Lists;
import com.mastalerek.mytamer.entity.Exercise;
import com.mastalerek.mytamer.entity.Student;
import com.mastalerek.mytamer.entity.StudentExercise;
import com.mastalerek.mytamer.functions.ExerciseToExerciseWebModelFunction;
import com.mastalerek.mytamer.functions.StudentExercisesToStudentExercisesWebModelFunction;
import com.mastalerek.mytamer.repository.ExerciseRepository;
import com.mastalerek.mytamer.repository.StudentRepository;
import com.mastalerek.mytamer.webmodel.ExerciseWebModel;
import com.mastalerek.mytamer.webmodel.StudentExerciseWebModel;

@Component
public class ExerciseService {

	@Inject
	private ExerciseRepository exerciseRepository;
	@Inject
	private StudentRepository studentRepository;
	@Inject
	private ExerciseToExerciseWebModelFunction exerciseToExerciseWebModelFunction;
	@Inject
	private StudentExercisesToStudentExercisesWebModelFunction studentExercisesToStudentExercisesWebModelFunction;

	@Transactional(readOnly = true)
	public List<ExerciseWebModel> getByDisciplineId(Integer disciplineId) {
		List<Exercise> exercises = exerciseRepository.findByDisciplineId(disciplineId);
		return Lists.transform(exercises, exerciseToExerciseWebModelFunction);
	}

	@Transactional(readOnly = true)
	public List<StudentExerciseWebModel> getStudentExercises(Integer studentId) {
		Student student = studentRepository.findOne(studentId);
		List<StudentExercise> studentExercises = student.getStudentExercises();
		return Lists.transform(studentExercises, studentExercisesToStudentExercisesWebModelFunction);
	}

	@Transactional(readOnly = true)
	public List<ExerciseWebModel> getUserExercises(Integer userId) {
		List<Exercise> exercises = exerciseRepository.findByUserId(userId);
		return Lists.transform(exercises, exerciseToExerciseWebModelFunction);
	}

	@Transactional(readOnly = true)
	public ExerciseWebModel getExerciseDetails(Integer exerciseId) {
		Exercise exercise = exerciseRepository.findOne(exerciseId);
		return exerciseToExerciseWebModelFunction.apply(exercise);
	}

}
