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

import com.mastalerek.mytamer.webmodel.MealWebModel;
import com.mastalerek.mytamer.webmodel.NutritionWebModel;

@Path(MealWebApi.BASE_PATH)
public interface MealWebApi {

	public static final String BY_USER = "/byUser";
	public static final String BASE_PATH = "/meals";

	@GET
	@Path(BY_USER)
	@Produces(MediaType.APPLICATION_JSON)
	public List<MealWebModel> getUserMeals(@NotNull @QueryParam("userId") Integer userId);

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public MealWebModel getMealDetails(@NotNull @QueryParam("mealId") Integer mealId);

	@POST
	@Path("/add")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response createMeal(@NotNull MealWebModel meal);

	@PUT
	@Path("/update")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response modifyMeal(@NotNull MealWebModel meal);

	@DELETE
	@Path("/delete")
	@Produces(MediaType.APPLICATION_JSON)
	public Response deleteMeal(@NotNull @QueryParam("mealId") Integer mealId);

	@POST
	@Path("/nutritions")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response saveNutritions(@NotNull @QueryParam("mealId") Integer mealId,
			@NotNull NutritionWebModel nutritions);
	
	@GET
	@Path("/getNutritions")
	@Produces(MediaType.APPLICATION_JSON)
	public List<NutritionWebModel> getNutritions();
	
	@GET
	@Path("/mealNutritions")
	@Produces(MediaType.APPLICATION_JSON)
	public List<NutritionWebModel> getMealNutritions(@NotNull @QueryParam("mealId") Integer mealId);
}
