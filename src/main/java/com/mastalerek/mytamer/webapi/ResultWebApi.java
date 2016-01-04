package com.mastalerek.mytamer.webapi;

import javax.validation.constraints.NotNull;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.mastalerek.mytamer.webmodel.ScoreWebModel;

@Path(ResultWebApi.BASE_PATH)
public interface ResultWebApi {

	public static final String SAVE = "/save";
	public static final String BASE_PATH = "/result";

	@POST
	@Path(SAVE) 
	@Consumes(MediaType.APPLICATION_JSON) 
	public Response saveResult(@NotNull ScoreWebModel result);
	
}
