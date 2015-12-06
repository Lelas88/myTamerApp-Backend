package com.mastalerek.mytamer.webapi;

import java.util.List;

import javax.validation.constraints.NotNull;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import com.mastalerek.mytamer.entity.StudentExercise;
import com.mastalerek.mytamer.webmodel.ExerciseWebModel;

@Path(ExerciseWebApi.BASE_PATH)
public interface ExerciseWebApi {

	public static final String BASE_PATH = "/exercise";
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<ExerciseWebModel> getByDisciplineId(@NotNull @QueryParam("disciplineId") Integer disciplineId);
	
	@GET
	@Path("/byStudent")
	@Produces(MediaType.APPLICATION_JSON)
	public List<StudentExercise> getStudentExercises(@NotNull @QueryParam("studentId") Integer studentId);
}
