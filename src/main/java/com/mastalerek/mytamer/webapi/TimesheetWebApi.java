package com.mastalerek.mytamer.webapi;

import java.util.List;

import javax.validation.constraints.NotNull;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path(TimesheetWebApi.BASE_PATH)
public interface TimesheetWebApi {

	public static final String BASE_PATH = "/timesheet";

	@POST
	@Path("/save")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response saveTimesheet(@NotNull List<Integer> studentIds);
}
