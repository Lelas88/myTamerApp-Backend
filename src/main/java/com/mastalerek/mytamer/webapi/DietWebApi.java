package com.mastalerek.mytamer.webapi;

import java.util.List;

import javax.validation.constraints.NotNull;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import com.mastalerek.mytamer.webmodel.DietWebModel;

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
}
