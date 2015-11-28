package com.mastalerek.mytamer.webapi;

import java.util.List;

import javax.validation.constraints.NotNull;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.mastalerek.mytamer.webmodel.UserWebClientModel;

@Path(UserWebApi.BASE_PATH)
public interface UserWebApi {

	public static final String GET_ALL = "/getAll";
	public static final String GET_BY_USERNAME = "/getByUsername/{username}";
	public static final String BASE_PATH = "/users";

	@GET
	@Path(GET_BY_USERNAME)
	@Produces(MediaType.APPLICATION_JSON)
	public UserWebClientModel getUserByUsername(@NotNull @PathParam("username") String username);

	@GET
	@Path(GET_ALL)
	@Produces(MediaType.APPLICATION_JSON)
	public List<UserWebClientModel> getAllUsers();
}
