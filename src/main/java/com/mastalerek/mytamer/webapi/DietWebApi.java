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

import com.mastalerek.mytamer.webmodel.DietWebModel;
import com.mastalerek.mytamer.webmodel.MealSetWebModel;
import com.mastalerek.mytamer.webmodel.TrainingPlanWebModel;

@Path(DietWebApi.BASE_PATH)
public interface DietWebApi {

	public static final String BASE_PATH = "/diet";

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public DietWebModel getDietDetails(@NotNull @QueryParam("dietId") Integer dietId);

	@GET
	@Path("/byUser")
	@Produces(MediaType.APPLICATION_JSON)
	public List<DietWebModel> getUserDiets(@NotNull @QueryParam("userId") Integer userId);

	@POST
	@Path("/save")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response saveDiet(@NotNull DietWebModel dietWebModel);

	@PUT
	@Path("/update")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response modifyDiet(@NotNull DietWebModel dietWebModel);

	@DELETE
	@Path("/delete")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response deleteDiet(@NotNull @QueryParam("dietId") Integer dietId);

	@POST
	@Path("/assignDietToTrainingPlans")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response assignDietToTrainingPlans(@NotNull @QueryParam("dietId") Integer dietId,
			@NotNull List<Integer> trainingPlanIds);

	@POST
	@Path("/assignMealSetsToDiet")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response assignMealSetsToDiet(@NotNull @QueryParam("dietId") Integer dietId,
			@NotNull List<Integer> mealSetIds);

	@DELETE
	@Path("/unassignMealSet")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response unassignMealSetFromDiet(@NotNull @QueryParam("dietId") Integer dietId,
			@NotNull @QueryParam("mealSetId") Integer mealSetId);

	@DELETE
	@Path("/unassignFromTrainingPlan")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response unassignDietFromTrainingPlan(@NotNull @QueryParam("dietId") Integer dietId,
			@NotNull @QueryParam("trainingPlanId") Integer trainingPlanId);

	@GET
	@Path("/notAssignedTrainingPlans")
	@Consumes(MediaType.APPLICATION_JSON)
	public List<TrainingPlanWebModel> getNotAssignedTrainingPlansToDiet(@NotNull @QueryParam("dietId") Integer dietId,
			@NotNull @QueryParam("userId") Integer userId);

	@GET
	@Path("/notAssignedMealSets")
	@Consumes(MediaType.APPLICATION_JSON)
	public List<MealSetWebModel> getNotAssignedMealSetsToDiet(@NotNull @QueryParam("dietId") Integer dietId,
			@NotNull @QueryParam("userId") Integer userId);
}
