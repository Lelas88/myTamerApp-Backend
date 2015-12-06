package com.mastalerek.mytamer.webapi;

import java.util.List;

import javax.validation.constraints.NotNull;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.mastalerek.mytamer.webmodel.GroupWebModel;

@Path(GroupWebApi.BASE_PATH)
public interface GroupWebApi {

	public static final String CREATE = "/createGroup";
	public static final String UPDATE = "/updateGroup";
	public static final String BASE_PATH = "/group";

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<GroupWebModel> getGroupsByUserId(@NotNull @QueryParam("userId") Integer userId);
	
	@PUT
	@Path(UPDATE)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response updateGroup(@NotNull GroupWebModel group);
	
	@PUT
	@Path(CREATE)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response createGroup(@NotNull GroupWebModel group);
}
