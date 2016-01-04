package com.mastalerek.mytamer.webapi.impl;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.Response;

import org.springframework.stereotype.Component;

import com.mastalerek.mytamer.service.DietService;
import com.mastalerek.mytamer.service.ExerciseSetService;
import com.mastalerek.mytamer.service.StudentService;
import com.mastalerek.mytamer.service.TrainingPlanService;
import com.mastalerek.mytamer.webapi.TrainingPlanWebApi;
import com.mastalerek.mytamer.webmodel.DietWebModel;
import com.mastalerek.mytamer.webmodel.ExerciseSetWebModel;
import com.mastalerek.mytamer.webmodel.StudentWebModel;
import com.mastalerek.mytamer.webmodel.TrainingPlanBasicWebModel;
import com.mastalerek.mytamer.webmodel.TrainingPlanWebModel;

@Component
public class TrainingPlanWebApiImpl implements TrainingPlanWebApi{

	@Inject
	private TrainingPlanService trainingPlanService;
	@Inject
	private StudentService studentService;
	@Inject
	private ExerciseSetService exerciseSetService;
	@Inject
	private DietService dietService;
	
	@Override
	public List<TrainingPlanBasicWebModel> getTrainingPlanBasics(Integer studentId) {
		return trainingPlanService.getTrainingPlanNames(studentId);
	}

	@Override
	public TrainingPlanWebModel getTrainingPlan(Integer trainingPlanId) {
		return trainingPlanService.getTrainingPlanDetails(trainingPlanId);
	}

	@Override
	public List<TrainingPlanWebModel> getUserTrainingPlans(Integer userId) {
		return trainingPlanService.getUserTrainingPlans(userId);
	}

	@Override
	public Response createTrainingPlan(TrainingPlanWebModel trainingPlanWebModel) {
		Integer trainingPlanId = trainingPlanService.createTrainingPlan(trainingPlanWebModel);
		return Response.ok().entity(Entity.text(String.valueOf(trainingPlanId))).build();
	}

	@Override
	public Response deleteTrainingPlan(Integer trainingPlanId) {
		trainingPlanService.deleteTrainingPlan(trainingPlanId);
		return Response.ok().build();
	}

	@Override
	public Response updateTrainingPlan(TrainingPlanWebModel trainingPlanWebModel) {
		trainingPlanService.updateTrainingPlan(trainingPlanWebModel);
		return Response.ok().build();
	}

	@Override
	public Response assignStudentsToTrainingPlan(Integer trainingPlanId, List<Integer> studentIds) {
		trainingPlanService.assignStudentsToTrainingPlan(trainingPlanId, studentIds);
		return Response.ok().build();
	}

	@Override
	public Response assignExerciseSetsToTrainingPlan(Integer trainingPlanId, List<Integer> exerciseSetIds) {
		trainingPlanService.assignExerciseSetsToTrainingPlan(trainingPlanId, exerciseSetIds);
		return Response.ok().build();
	}

	@Override
	public Response assignDietsToTrainingPlan(Integer trainingPlanId, List<Integer> dietIds) {
		trainingPlanService.assignDietsToTrainingPlan(trainingPlanId, dietIds);
		return Response.ok().build();
	}

	@Override
	public Response unassignStudentFromTrainingPlan(Integer trainingPlanId, Integer studentId) {
		trainingPlanService.unassignStudentFromTrainingPlan(trainingPlanId, studentId);
		return Response.ok().build();
	}

	@Override
	public Response unassignExerciseSetFromTrainingPlan(Integer trainingPlanId, Integer exerciseSetId) {
		trainingPlanService.unassignStudentFromTrainingPlan(trainingPlanId, exerciseSetId);
		return Response.ok().build();
	}

	@Override
	public Response unassignDietFromTrainingPlan(Integer trainingPlanId, Integer dietId) {
		trainingPlanService.unassignStudentFromTrainingPlan(trainingPlanId, dietId);
		return Response.ok().build();
	}

	@Override
	public List<StudentWebModel> getNotAssignedStudentsToTrainingPlan(Integer trainingPlanId, Integer userId) {
		return studentService.getNotAssignedStudentsToTrainingPlan(trainingPlanId, userId);
	}

	@Override
	public List<ExerciseSetWebModel> getNotAssignedExerciseSetsToTrainingPlan(Integer trainingPlanId, Integer userId) {
		return exerciseSetService.getNotAssignedExerciseSetsToTrainingPlan(trainingPlanId, userId);
	}

	@Override
	public List<DietWebModel> getNotAssignedDietsToTrainingPlan(Integer trainingPlanId, Integer userId) {
		return dietService.getNotAssignedDietsToTrainingPlan(trainingPlanId, userId);
	}

	@Override
	public List<StudentWebModel> getAssignedStudentsToTrainingPlan(Integer trainingPlanId, Integer userId) {
		return studentService.getAssignedStudentsToTrainingPlan(trainingPlanId, userId);
	}

	@Override
	public List<ExerciseSetWebModel> getAssignedExerciseSetsToTrainingPlan(Integer trainingPlanId, Integer userId) {
		return exerciseSetService.getAssignedExerciseSetsToTrainingPlan(trainingPlanId, userId);
	}

	@Override
	public List<DietWebModel> getAssignedDietsToTrainingPlan(Integer trainingPlanId, Integer userId) {
		return dietService.getAssignedDietsToTrainingPlan(trainingPlanId, userId);
	}
}
