package com.mastalerek.mytamer.webapi;

import java.util.List;

import javax.validation.constraints.NotNull;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import com.mastalerek.mytamer.webmodel.MealWebModel;

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
}
