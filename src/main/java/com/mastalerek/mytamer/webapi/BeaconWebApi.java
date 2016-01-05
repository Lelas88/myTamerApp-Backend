package com.mastalerek.mytamer.webapi;

import java.util.List;

import javax.validation.constraints.NotNull;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.mastalerek.mytamer.webmodel.ExerciseWebModel;

@Path(BeaconWebApi.BASE_PATH)
public interface BeaconWebApi {

	public static final String BASE_PATH = "/beacon";

	@GET
	@Path("/getExercises")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public List<ExerciseWebModel> getBeaconExercises(@NotNull @QueryParam("major") Integer major,
			@NotNull @QueryParam("minor") Integer minor, @NotNull @QueryParam("uuid") String uuid);
	
	@POST
	@Path("/downloadExercises")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response downloadExercises(@NotNull @QueryParam("userId") Integer userId, @NotNull List<Integer> exerciseIds);
}
