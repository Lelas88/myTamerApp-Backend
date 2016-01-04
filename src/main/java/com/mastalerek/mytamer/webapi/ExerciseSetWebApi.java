package com.mastalerek.mytamer.webapi;

import java.util.List;

import javax.validation.constraints.NotNull;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.mastalerek.mytamer.webmodel.ExerciseSetWebModel;
import com.mastalerek.mytamer.webmodel.ExerciseWebModel;

@Path(ExerciseSetWebApi.BASE_PATH)
public interface ExerciseSetWebApi {

	public static final String BY_USER = "/byUser";
	public static final String BY_TRAINING_PLAN = "/byTrainingPlan";
	public static final String BASE_PATH = "/exerciseSet";

	@GET
	@Path(BY_TRAINING_PLAN)
	@Produces(MediaType.APPLICATION_JSON)
	public List<ExerciseSetWebModel> getExercisesAssignedToTrainingPlan(
			@NotNull @QueryParam("trainingPlanId") Integer trainingPlanId);

	@GET
	@Path(BY_USER)
	@Produces(MediaType.APPLICATION_JSON)
	public List<ExerciseSetWebModel> getExerciseSetsByUserId(@NotNull @QueryParam("userId") Integer userId);

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public ExerciseSetWebModel getExerciseSetDetails(@NotNull @QueryParam("exerciseSetId") Integer exerciseSetId);

	@POST
	@Path("/save")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response saveExerciseSet(@NotNull ExerciseSetWebModel exerciseSetWebModel);

	@PUT
	@Path("/update")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response updateExerciseSet(@NotNull ExerciseSetWebModel exerciseSetWebModel);

	@POST
	@Path("/assignExercises")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response assignExercises(@NotNull @QueryParam("exerciseSetId") Integer exerciseSetId,
			@NotNull List<Integer> exerciseIds);

	@DELETE
	@Path("/unassignExercise")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response unassignExercise(@NotNull @QueryParam("exerciseSetId") Integer exerciseSetId,
			@NotNull @QueryParam("exerciseId") Integer exerciseId);

	@DELETE
	@Path("/delete")
	@Produces(MediaType.APPLICATION_JSON)
	public Response deleteExerciseSet(@NotNull @QueryParam("exerciseSetId") Integer exerciseSetId);

	@GET
	@Path("/getExercisesNotAssigned")
	@Produces(MediaType.APPLICATION_JSON)
	public List<ExerciseWebModel> getExercisesNotAssignedToExerciseSet(
			@NotNull @QueryParam("exerciseSetId") Integer exerciseSetId);
}
