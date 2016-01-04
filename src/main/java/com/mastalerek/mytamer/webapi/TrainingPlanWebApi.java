package com.mastalerek.mytamer.webapi;

import java.util.List;

import javax.validation.constraints.NotNull;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.mastalerek.mytamer.webmodel.DietWebModel;
import com.mastalerek.mytamer.webmodel.ExerciseSetWebModel;
import com.mastalerek.mytamer.webmodel.StudentWebModel;
import com.mastalerek.mytamer.webmodel.TrainingPlanBasicWebModel;
import com.mastalerek.mytamer.webmodel.TrainingPlanWebModel;

@Path(TrainingPlanWebApi.BASE_PATH)
public interface TrainingPlanWebApi {

	public static final String BY_USER = "/byUser";
	public static final String BY_STUDENT = "/byStudent/{studentId}";
	public static final String BASE_PATH = "/trainingPlan";

	@GET
	@Path(BY_STUDENT)
	@Produces(MediaType.APPLICATION_JSON)
	public List<TrainingPlanBasicWebModel> getTrainingPlanBasics(@NotNull @PathParam("studentId") Integer studentId);

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public TrainingPlanWebModel getTrainingPlan(@NotNull @QueryParam("trainingPlanId") Integer trainingPlanId);

	@GET
	@Path(BY_USER)
	@Produces(MediaType.APPLICATION_JSON)
	public List<TrainingPlanWebModel> getUserTrainingPlans(@NotNull @QueryParam("userId") Integer userId);

	@POST
	@Path("/create")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response createTrainingPlan(@NotNull TrainingPlanWebModel trainingPlanWebModel);

	@DELETE
	@Path("/delete")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response deleteTrainingPlan(@NotNull @QueryParam("trainingPlanId") Integer trainingPlanId);

	@PUT
	@Path("/update")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response updateTrainingPlan(@NotNull TrainingPlanWebModel trainingPlanWebModel);

	@POST
	@Path("/assignStudents")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response assignStudentsToTrainingPlan(@NotNull @QueryParam("trainingPlanId") Integer trainingPlanId,
			@NotNull List<Integer> studentIds);

	@POST
	@Path("/assignExerciseSets")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response assignExerciseSetsToTrainingPlan(@NotNull @QueryParam("trainingPlanId") Integer trainingPlanId,
			@NotNull List<Integer> exerciseSetIds);

	@POST
	@Path("/assignDiets")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response assignDietsToTrainingPlan(@NotNull @QueryParam("trainingPlanId") Integer trainingPlanId,
			@NotNull List<Integer> dietIds);

	@DELETE
	@Path("/unassignStudent")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response unassignStudentFromTrainingPlan(@NotNull @QueryParam("trainingPlanId") Integer trainingPlanId,
			@NotNull @QueryParam("studentId") Integer studentId);

	@DELETE
	@Path("/unassignExerciseSet")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response unassignExerciseSetFromTrainingPlan(@NotNull @QueryParam("trainingPlanId") Integer trainingPlanId,
			@NotNull @QueryParam("exerciseSetId") Integer exerciseSetId);

	@DELETE
	@Path("/unassignDiet")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response unassignDietFromTrainingPlan(@NotNull @QueryParam("trainingPlanId") Integer trainingPlanId,
			@NotNull @QueryParam("dietId") Integer dietId);

	@GET
	@Path("/notAssignedStudents")
	@Produces(MediaType.APPLICATION_JSON)
	public List<StudentWebModel> getNotAssignedStudentsToTrainingPlan(
			@NotNull @QueryParam("trainingPlanId") Integer trainingPlanId, @NotNull @QueryParam("userId") Integer userId);

	@GET
	@Path("/notAssignedExerciseSets")
	@Produces(MediaType.APPLICATION_JSON)
	public List<ExerciseSetWebModel> getNotAssignedExerciseSetsToTrainingPlan(
			@NotNull @QueryParam("trainingPlanId") Integer trainingPlanId, @NotNull @QueryParam("userId") Integer userId);

	@GET
	@Path("/notAssignedDiets")
	@Produces(MediaType.APPLICATION_JSON)
	public List<DietWebModel> getNotAssignedDietsToTrainingPlan(
			@NotNull @QueryParam("trainingPlanId") Integer trainingPlanId, @NotNull @QueryParam("userId") Integer userId);

	@GET
	@Path("/assignedStudents")
	@Produces(MediaType.APPLICATION_JSON)
	public List<StudentWebModel> getAssignedStudentsToTrainingPlan(
			@NotNull @QueryParam("trainingPlanId") Integer trainingPlanId, @NotNull @QueryParam("userId") Integer userId);

	@GET
	@Path("/assignedExerciseSets")
	@Produces(MediaType.APPLICATION_JSON)
	public List<ExerciseSetWebModel> getAssignedExerciseSetsToTrainingPlan(
			@NotNull @QueryParam("trainingPlanId") Integer trainingPlanId, @NotNull @QueryParam("userId") Integer userId);

	@GET
	@Path("/assignedDiets")
	@Produces(MediaType.APPLICATION_JSON)
	public List<DietWebModel> getAssignedDietsToTrainingPlan(
			@NotNull @QueryParam("trainingPlanId") Integer trainingPlanId, @NotNull @QueryParam("userId") Integer userId);
}
