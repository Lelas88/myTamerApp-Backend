package com.mastalerek.mytamer.webapi;

import java.util.List;

import javax.validation.constraints.NotNull;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.mastalerek.mytamer.webmodel.StudentCredentials;
import com.mastalerek.mytamer.webmodel.UserWebModel;

@Path(UserWebApi.BASE_PATH)
public interface UserWebApi {

	public static final String REGISTER_STUDENT = "/registerStudent";
	public static final String GET_ID = "/getId";
	public static final String REGISTER = "/register";
	public static final String VERIFY = "/verify";
	public static final String GET_BY_ID = "/getById/{userId}";
	public static final String GET_ALL = "/getAll";
	public static final String BASE_PATH = "/user";

	@GET
	@Path(GET_ALL)
	@Produces(MediaType.APPLICATION_JSON)
	public List<UserWebModel> getAllUsers();

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public UserWebModel getUserByUsername(@NotNull @QueryParam("username") String username);
	
	@GET
	@Path(GET_ID)
	@Produces(MediaType.APPLICATION_JSON)
	public Integer getUserIdByUsername(@NotNull @QueryParam("username") String username);

	@GET
	@Path(GET_BY_ID)
	@Produces(MediaType.APPLICATION_JSON)
	public UserWebModel getById(@NotNull @PathParam("userId") Integer userId);

	@GET
	@Path(VERIFY)
	@Produces(MediaType.APPLICATION_JSON)
	public boolean loginUser(@NotNull @QueryParam("username") String username,
			@NotNull @QueryParam("password") String password);
	
	@POST
	@Path(REGISTER)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response createUser(@NotNull UserWebModel user);
	
	@POST
	@Path(REGISTER_STUDENT)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response registerStudent(@NotNull StudentCredentials credentials);
}
