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

import com.mastalerek.mytamer.webmodel.PresenceWebModel;

@Path(TimesheetWebApi.BASE_PATH)
public interface TimesheetWebApi {

	public static final String CHECK = "/check";
	public static final String BASE_PATH = "/timesheet";

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response saveTimesheet(@NotNull List<Integer> studentIds);

	@GET
	@Path(CHECK)
	@Produces(MediaType.APPLICATION_JSON)
	public List<PresenceWebModel> checkPresence(@NotNull @QueryParam("groupId") Integer groupId,
			@NotNull @QueryParam("dateFrom") String dateFrom, @NotNull @QueryParam("dateTo") String dateTo);
}
