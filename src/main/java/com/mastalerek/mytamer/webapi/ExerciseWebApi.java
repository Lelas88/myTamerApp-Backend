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

import com.mastalerek.mytamer.entity.Discipline;
import com.mastalerek.mytamer.entity.ExerciseUnit;
import com.mastalerek.mytamer.webmodel.ExerciseWebModel;
import com.mastalerek.mytamer.webmodel.StudentExerciseWebModel;
import com.mastalerek.mytamer.webmodel.StudentWebModel;

@Path(ExerciseWebApi.BASE_PATH)
public interface ExerciseWebApi {

	public static final String BY_DISCIPLINE = "/byDiscipline";
	public static final String BY_STUDENT = "/byStudent";
	public static final String BY_USER = "/byUser";
	public static final String BASE_PATH = "/exercise";

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public ExerciseWebModel getExerciseDetails(@NotNull @QueryParam("exerciseId") Integer exerciseId);

	@GET
	@Path(BY_DISCIPLINE)
	@Produces(MediaType.APPLICATION_JSON)
	public List<ExerciseWebModel> getByDisciplineId(@NotNull @QueryParam("disciplineId") Integer disciplineId);

	@GET
	@Path(BY_STUDENT)
	@Produces(MediaType.APPLICATION_JSON)
	public List<StudentExerciseWebModel> getStudentExercises(@NotNull @QueryParam("studentId") Integer studentId);

	@GET
	@Path(BY_USER)
	@Produces(MediaType.APPLICATION_JSON)
	public List<ExerciseWebModel> getUserExercises(@NotNull @QueryParam("userId") Integer userId);

	@GET
	@Path("/units")
	@Produces(MediaType.APPLICATION_JSON)
	public List<ExerciseUnit> getUnits();

	@GET
	@Path("/disciplines")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Discipline> getDisciplines();

	@GET
	@Path("/allStudents")
	@Produces(MediaType.APPLICATION_JSON)
	public List<StudentWebModel> getStudentsToAssign();

	@GET
	@Path("/notAssignedStudents")
	@Produces(MediaType.APPLICATION_JSON)
	public List<StudentWebModel> getNotAssignedStudents(@NotNull @QueryParam("exerciseId") Integer exerciseId);

	@POST
	@Path("/assignStudents")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response assignStudents(@NotNull @QueryParam("exerciseId") Integer exerciseId,
			@NotNull List<Integer> studentIds);

	@POST
	@Path("/save")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response saveExercise(@NotNull ExerciseWebModel exercise);

	@GET
	@Path("/getAssignedStudents")
	@Produces(MediaType.APPLICATION_JSON)
	public List<StudentWebModel> getStudentsAssignedToExercise(@NotNull @QueryParam("exerciseId") Integer exerciseId);

	@PUT
	@Path("/update")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response updateExercise(@NotNull ExerciseWebModel exercise);

	@DELETE
	@Path("/unassignStudent")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response unassignStudent(@NotNull @QueryParam("exerciseId") Integer exerciseId,
			@NotNull @QueryParam("studentId") Integer studentId);
	
	@DELETE
	@Path("/delete")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response deleteExercise(@NotNull @QueryParam("exerciseId") Integer exerciseId);

}
