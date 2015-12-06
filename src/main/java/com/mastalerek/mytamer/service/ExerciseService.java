package com.mastalerek.mytamer.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Component;

import com.mastalerek.mytamer.entity.Exercise;
import com.mastalerek.mytamer.entity.Student;
import com.mastalerek.mytamer.entity.StudentExercise;
import com.mastalerek.mytamer.functions.ExerciseListToExerciseWebModelListFunction;
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
	private ExerciseListToExerciseWebModelListFunction exerciseListToExerciseWebModelListFunction;
	@Inject
	private StudentExercisesToStudentExercisesWebModelFunction studentExercisesToStudentExercisesWebModelFunction;

	public List<ExerciseWebModel> getByDisciplineId(Integer disciplineId) {
		List<Exercise> exercises = exerciseRepository.findByDisciplineId(disciplineId);
		return exerciseListToExerciseWebModelListFunction.apply(exercises);
	}

	public List<StudentExerciseWebModel> getStudentExercises(Integer studentId) {
		Student student = studentRepository.findOne(studentId);
		List<StudentExercise> studentExercises = student.getStudentExercises();
		return studentExercisesToStudentExercisesWebModelFunction.apply(studentExercises);
	}

}
