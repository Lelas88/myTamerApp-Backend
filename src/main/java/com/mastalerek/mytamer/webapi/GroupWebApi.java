package com.mastalerek.mytamer.webapi;

import java.util.List;

import javax.validation.constraints.NotNull;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.mastalerek.mytamer.webmodel.GroupWebModel;

@Path(GroupWebApi.BASE_PATH)
public interface GroupWebApi {

	public static final String GET_ONE = "/getOne";
	public static final String DELETE = "/delete";
	public static final String CREATE = "/createGroup";
	public static final String UPDATE = "/updateGroup";
	public static final String BASE_PATH = "/group";

	@GET
	@Path(GET_ONE)
	@Produces(MediaType.APPLICATION_JSON)
	public GroupWebModel getGroupDetails(@NotNull @QueryParam("groupId") Integer groupId);

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<GroupWebModel> getGroupsByUserId(@NotNull @QueryParam("userId") Integer userId);

	@PUT
	@Path(UPDATE)
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response updateGroup(@NotNull GroupWebModel group);

	@POST
	@Path(CREATE)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response createGroup(@NotNull GroupWebModel group);

	@DELETE
	@Path(DELETE)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response deleteGroup(@NotNull @QueryParam("groupId") Integer groupId);

	@PUT
	@Path("/linkStudents")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response linkStudents(@NotNull @QueryParam("groupId") Integer groupId, @NotNull List<Integer> studentIds);

	@PUT
	@Path("/unassignStudent")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response unassignStudent(@NotNull @QueryParam("groupId") Integer groupId,
			@NotNull @QueryParam("studentId") Integer studentId);
}
