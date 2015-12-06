package com.mastalerek.mytamer.webapi;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.mastalerek.mytamer.entity.ExerciseUnit;

@Path(ExerciseUnitWebApi.BASE_PATH)
public interface ExerciseUnitWebApi {

	public static final String BASE_PATH = "/exerciseUnits";

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<ExerciseUnit> getAllExerciseUnits();
}
