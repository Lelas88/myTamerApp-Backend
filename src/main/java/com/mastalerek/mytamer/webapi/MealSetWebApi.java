package com.mastalerek.mytamer.webapi;

import java.util.List;

import javax.validation.constraints.NotNull;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import com.mastalerek.mytamer.webmodel.MealSetWebModel;

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
}
