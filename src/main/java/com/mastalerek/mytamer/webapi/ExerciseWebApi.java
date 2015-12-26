package com.mastalerek.mytamer.webapi;

import java.util.List;

import javax.validation.constraints.NotNull;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import com.mastalerek.mytamer.webmodel.ExerciseWebModel;
import com.mastalerek.mytamer.webmodel.StudentExerciseWebModel;

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
	
}
