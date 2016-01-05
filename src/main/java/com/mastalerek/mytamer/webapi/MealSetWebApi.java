package com.mastalerek.mytamer.webapi;

import java.util.List;

import javax.validation.constraints.NotNull;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.mastalerek.mytamer.webmodel.MealSetWebModel;
import com.mastalerek.mytamer.webmodel.MealWebModel;

@Path(MealSetWebApi.BASE_PATH)
public interface MealSetWebApi {

	public static final String BASE_PATH = "/mealSet";

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public MealSetWebModel getMealSetDetails(@NotNull @QueryParam("mealSetId") Integer mealSetId);

	@GET
	@Path("/byUser")
	@Produces(MediaType.APPLICATION_JSON)
	public List<MealSetWebModel> getMealSetsList(@NotNull @QueryParam("userId") Integer userId);

	@GET
	@Path("/mealsAssigned")
	@Produces(MediaType.APPLICATION_JSON)
	public List<MealWebModel> getAssignedMeals(@NotNull @QueryParam("mealSetId") Integer mealSetId);

	@GET
	@Path("/mealsNotAssigned")
	@Produces(MediaType.APPLICATION_JSON)
	public List<MealWebModel> getNotAssignedMeals(@NotNull @QueryParam("mealSetId") Integer mealSetId,
			@NotNull @QueryParam("userId") Integer userId);

	@POST
	@Path("/save")
	@Produces(MediaType.APPLICATION_JSON)
	public Response saveMealSet(@NotNull MealSetWebModel mealSetWebModel);

	@PUT
	@Path("/update")
	@Produces(MediaType.APPLICATION_JSON)
	public Response updateMealSet(@NotNull MealSetWebModel mealSetWebModel);

	@DELETE
	@Path("/delete")
	@Produces(MediaType.APPLICATION_JSON)
	public Response deleteMealSet(@NotNull @QueryParam("mealSetId") Integer mealSetId);

	@POST
	@Path("/assignMeals")
	@Produces(MediaType.APPLICATION_JSON)
	public Response assignMeal(@NotNull @QueryParam("mealSetId") Integer mealSetId,
			@NotNull List<Integer> mealIds);

	@DELETE
	@Path("/unassignMeal")
	@Produces(MediaType.APPLICATION_JSON)
	public Response unassignMeal(@NotNull @QueryParam("mealSetId") Integer mealSetId,
			@NotNull @QueryParam("mealId") Integer mealId);
}
