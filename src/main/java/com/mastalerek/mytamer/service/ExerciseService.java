package com.mastalerek.mytamer.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.google.common.collect.Lists;
import com.mastalerek.mytamer.entity.Discipline;
import com.mastalerek.mytamer.entity.Exercise;
import com.mastalerek.mytamer.entity.ExerciseUnit;
import com.mastalerek.mytamer.entity.Student;
import com.mastalerek.mytamer.entity.StudentExercise;
import com.mastalerek.mytamer.functions.ExerciseToExerciseWebModelFunction;
import com.mastalerek.mytamer.functions.StudentExercisesToStudentExercisesWebModelFunction;
import com.mastalerek.mytamer.repository.DisciplineRepository;
import com.mastalerek.mytamer.repository.ExerciseRepository;
import com.mastalerek.mytamer.repository.ExerciseUnitRepository;
import com.mastalerek.mytamer.repository.StudentExerciseRepository;
import com.mastalerek.mytamer.repository.StudentRepository;
import com.mastalerek.mytamer.repository.UserRepository;
import com.mastalerek.mytamer.webmodel.ExerciseWebModel;
import com.mastalerek.mytamer.webmodel.StudentExerciseWebModel;
import com.mastalerek.mytamer.webmodel.StudentWebModel;

@Component
public class ExerciseService {

	@Inject
	private UserRepository userRepository;
	@Inject
	private ExerciseRepository exerciseRepository;
	@Inject
	private StudentExerciseRepository studentExerciseRepository;
	@Inject
	private StudentRepository studentRepository;
	@Inject
	private StudentService studentService;
	@Inject
	private ExerciseUnitRepository exerciseUnitRepository;
	@Inject
	private DisciplineRepository disciplineRepository;
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

	public List<ExerciseUnit> getUnits() {
		return (List<ExerciseUnit>) exerciseUnitRepository.findAll();
	}

	public List<Discipline> getDisciplines() {
		return (List<Discipline>) disciplineRepository.findAll();
	}

	public List<StudentWebModel> getStudentsToAssign() {
		return studentService.getAllStudents();
	}

	public void assignStudents(Integer exerciseId, List<Integer> studentIds) {
		Exercise exercise = exerciseRepository.findOne(exerciseId);
		for (Integer studentId : studentIds) {
			Student student = studentRepository.findOne(studentId);
			StudentExercise studentExercise = new StudentExercise();
			studentExercise.setExercise(exercise);
			studentExercise.setStudent(student);
			studentExerciseRepository.save(studentExercise);
		}
	}

	public List<StudentWebModel> getNotAssignedStudents(Integer exerciseId) {
		return studentService.getStudentsNotAssignedToExercise(exerciseId);
	}

	public Integer saveExercise(ExerciseWebModel exerciseWebModel) {
		Exercise exercise = new Exercise();
		exercise.setName(exerciseWebModel.getName());
		exercise.setDescription(exerciseWebModel.getDescription());
		Discipline discipline = disciplineRepository.findOne(exerciseWebModel.getDisciplineId());
		exercise.setDiscipline(discipline);
		ExerciseUnit firstUnit = exerciseUnitRepository.findOne(exerciseWebModel.getUnitId());
		exercise.setUnit(firstUnit);
		if (exerciseWebModel.getSecondUnitId() != null) {
			ExerciseUnit secondUnit = exerciseUnitRepository.findOne(exerciseWebModel.getSecondUnitId());
			exercise.setSecondUnit(secondUnit);
		}
		exercise.setIconName(exerciseWebModel.getIconName());
		exercise.setUser(userRepository.findOne(exerciseWebModel.getTrainerId()));
		return exerciseRepository.save(exercise).getId();
	}

	public List<StudentWebModel> getStudentsAssignedToExercise(Integer exerciseId) {
		return studentService.getStudentsAssignedToExercise(exerciseId);
	}

	public void updateExercise(ExerciseWebModel exercise) {
		Exercise foundExercise = exerciseRepository.findOne(exercise.getId());
		Discipline discipline = disciplineRepository.findOne(exercise.getDisciplineId());
		ExerciseUnit firstUnit = exerciseUnitRepository.findOne(exercise.getUnitId());
		foundExercise.setDiscipline(discipline);
		foundExercise.setIconName(exercise.getIconName());
		foundExercise.setName(exercise.getName());
		foundExercise.setUnit(firstUnit);
		if (exercise.getSecondUnitId() != null) {
			ExerciseUnit secondUnit = exerciseUnitRepository.findOne(exercise.getSecondUnitId());
			foundExercise.setSecondUnit(secondUnit);
		}
		foundExercise.setDescription(exercise.getDescription());
		exerciseRepository.save(foundExercise);
	}

	@Transactional
	public void unassignStudent(Integer exerciseId, Integer studentId) {
		StudentExercise studentExercise = studentExerciseRepository.findByExerciseIdAndStudentId(exerciseId, studentId);
		studentExerciseRepository.delete(studentExercise.getId());
	}

	public void deleteExercise(Integer exerciseId) {
		List<StudentExercise> studentExercises = studentExerciseRepository.findByExerciseId(exerciseId);
		studentExerciseRepository.delete(studentExercises);
		exerciseRepository.delete(exerciseId);
	}

	public List<ExerciseWebModel> getExercisesNotAssignedToExerciseSet(Integer exerciseSetId) {
		List<Exercise> exercises = exerciseRepository.findExercisesNotAssignedToExerciseSetId(exerciseSetId);
		return Lists.transform(exercises, exerciseToExerciseWebModelFunction);
	}

	public void saveExercises(Integer userId, List<Integer> exerciseIds) {
		for (Integer exerciseId : exerciseIds) {
			Exercise exerciseToCopy = exerciseRepository.findOne(exerciseId);
			exerciseToCopy.setId(null);
			exerciseToCopy.setUser(userRepository.findOne(userId));
			exerciseRepository.save(exerciseToCopy);
		}
	}

}
