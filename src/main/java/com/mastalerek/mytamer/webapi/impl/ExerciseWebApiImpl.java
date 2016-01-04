package com.mastalerek.mytamer.webapi.impl;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.Response;

import org.springframework.stereotype.Component;

import com.mastalerek.mytamer.entity.Discipline;
import com.mastalerek.mytamer.entity.ExerciseUnit;
import com.mastalerek.mytamer.service.ExerciseService;
import com.mastalerek.mytamer.webapi.ExerciseWebApi;
import com.mastalerek.mytamer.webmodel.ExerciseWebModel;
import com.mastalerek.mytamer.webmodel.StudentExerciseWebModel;
import com.mastalerek.mytamer.webmodel.StudentWebModel;

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

	@Override
	public List<ExerciseWebModel> getUserExercises(Integer userId) {
		return exerciseService.getUserExercises(userId);
	}

	@Override
	public ExerciseWebModel getExerciseDetails(Integer exerciseId) {
		return exerciseService.getExerciseDetails(exerciseId);
	}

	@Override
	public List<ExerciseUnit> getUnits() {
		return exerciseService.getUnits();
	}

	@Override
	public List<Discipline> getDisciplines() {
		return exerciseService.getDisciplines();
	}

	@Override
	public List<StudentWebModel> getStudentsToAssign() {
		return exerciseService.getStudentsToAssign();
	}

	@Override
	public Response assignStudents(Integer exerciseId, List<Integer> studentIds) {
		exerciseService.assignStudents(exerciseId, studentIds);
		return Response.ok().build();
	}

	@Override
	public List<StudentWebModel> getNotAssignedStudents(Integer exerciseId) {
		return exerciseService.getNotAssignedStudents(exerciseId);
	}

	@Override
	public Response saveExercise(ExerciseWebModel exercise) {
		Integer exerciseId = exerciseService.saveExercise(exercise);
		return Response.ok().entity(Entity.text(String.valueOf(exerciseId))).build();
	}

	@Override
	public List<StudentWebModel> getStudentsAssignedToExercise(Integer exerciseId) {
		return exerciseService.getStudentsAssignedToExercise(exerciseId);
	}

	@Override
	public Response updateExercise(ExerciseWebModel exercise) {
		exerciseService.updateExercise(exercise);
		return Response.ok().build();
	}

	@Override
	public Response unassignStudent(Integer exerciseId, Integer studentId) {
		exerciseService.unassignStudent(exerciseId, studentId);
		return Response.ok().build();
	}

	@Override
	public Response deleteExercise(Integer exerciseId) {
		exerciseService.deleteExercise(exerciseId);
		return Response.ok().build();
	}
}
