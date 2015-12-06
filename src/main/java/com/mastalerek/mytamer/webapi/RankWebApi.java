package com.mastalerek.mytamer.webapi;

import javax.validation.constraints.NotNull;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

@Path(RankWebApi.BASE_PATH)
public interface RankWebApi {

	public static final String BASE_PATH = "/rank";

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public String getRankById(@NotNull @QueryParam("rankId") Integer rankId);
}
