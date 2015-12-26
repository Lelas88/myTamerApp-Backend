package com.mastalerek.mytamer.webapi;

import java.util.List;

import javax.validation.constraints.NotNull;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import com.mastalerek.mytamer.webmodel.ExerciseSetWebModel;

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
}
