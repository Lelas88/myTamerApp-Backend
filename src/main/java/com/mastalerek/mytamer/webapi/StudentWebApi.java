package com.mastalerek.mytamer.webapi;

import java.util.List;

import javax.validation.constraints.NotNull;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.mastalerek.mytamer.webmodel.DietBasicWebModel;
import com.mastalerek.mytamer.webmodel.StudentWebModel;
import com.mastalerek.mytamer.webmodel.UserWebModel;

@Path(StudentWebApi.BASE_PATH)
public interface StudentWebApi {

	public static final String CREDENTIALS = "/credentials";
	public static final String WITH_NO_GROUP = "/withNoGroup";
	public static final String DIETS = "/diet/{studentId}";
	public static final String CONTRAINDICATIONS = "/contraindications/{studentId}";
	public static final String STUDENT_ID = "/{studentId}";
	public static final String IMAGE = "/image";
	public static final String UPDATE = "/update";
	public static final String CREATE = "/create";
	public static final String BY_USER = "/user/{userId}";
	public static final String BASE_PATH = "/student";

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<StudentWebModel> getStudentsByGroupId(@NotNull @QueryParam("groupId") Integer groupId);

	@GET
	@Path(STUDENT_ID)
	@Produces(MediaType.APPLICATION_JSON)
	public StudentWebModel getStudent(@NotNull @PathParam("studentId") Integer studentId);

	@GET
	@Path(BY_USER)
	@Produces(MediaType.APPLICATION_JSON)
	public List<StudentWebModel> getUserStudents(@NotNull @PathParam("userId") Integer userId);

	@GET
	@Path(WITH_NO_GROUP)
	@Produces(MediaType.APPLICATION_JSON)
	public List<StudentWebModel> getStudentsWithNoGroupAssigned(@NotNull @QueryParam("userId") Integer userId);

	@POST
	@Path(CREATE)
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response createStudent(@NotNull StudentWebModel student);

	@GET
	@Path(CONTRAINDICATIONS)
	@Produces(MediaType.APPLICATION_JSON)
	public List<String> getStudentContraindications(@NotNull @PathParam("studentId") Integer studentId);

	@GET
	@Path(DIETS)
	@Produces(MediaType.APPLICATION_JSON)
	public List<DietBasicWebModel> getStudentDiets(@NotNull @PathParam("studentId") Integer studentId);

	@DELETE
	@Consumes(MediaType.APPLICATION_JSON)
	public Response deleteStudent(@NotNull @QueryParam("studentId") Integer studentId);

	@GET
	@Path(CREDENTIALS + "/email")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public UserWebModel verifyEmail(@NotNull @QueryParam("email") String email);

	@GET
	@Path(CREDENTIALS + "/login")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public UserWebModel verifyLogin(@NotNull @QueryParam("login") String login);
	
	@PUT
	@Path(UPDATE) 
	@Consumes(MediaType.APPLICATION_JSON)
	public Response updateStudent(@NotNull StudentWebModel studentWebModel);

}
