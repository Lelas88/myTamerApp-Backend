package com.mastalerek.mytamer.webapi;

import java.util.List;

import javax.validation.constraints.NotNull;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.mastalerek.mytamer.webmodel.StudentWebModel;

@Path(StudentWebApi.BASE_PATH)
public interface StudentWebApi {
	
	public static final String IMAGE = "/image";
	public static final String UPDATE = "/update";
	public static final String CREATE = "/create";
	public static final String BY_USER = "/{userId}";
	public static final String BASE_PATH = "/student";

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<StudentWebModel> getStudentsByGroupId(@NotNull @QueryParam("groupId") Integer groupId);

	@GET
	@Path(BY_USER)
	@Produces(MediaType.APPLICATION_JSON)
	public List<StudentWebModel> getUserStudents(@NotNull @PathParam("userId") Integer userId);
	
	@PUT
	@Path(CREATE)
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response createStudent(@NotNull StudentWebModel student);
	
	@GET
	@Path(IMAGE)
	@Produces(MediaType.APPLICATION_JSON)
	public String getStudentPhoto(@NotNull @QueryParam("studentId") Integer studentId);
	
}
