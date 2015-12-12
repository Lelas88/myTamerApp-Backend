package com.mastalerek.mytamer.webapi;

import java.util.List;

import javax.validation.constraints.NotNull;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.mastalerek.mytamer.webmodel.TrainingPlanBasicWebModel;
import com.mastalerek.mytamer.webmodel.TrainingPlanWebModel;

@Path(TrainingPlanWebApi.BASE_PATH)
public interface TrainingPlanWebApi {
	
	public static final String BY_STUDENT = "/byStudent/{studentId}";
	public static final String BASE_PATH = "/trainingPlan";

	@GET
	@Path(BY_STUDENT)
	@Produces(MediaType.APPLICATION_JSON)
	public List<TrainingPlanBasicWebModel> getTrainingPlanBasics(@NotNull @PathParam("studentId") Integer studentId);

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public TrainingPlanWebModel getTrainingPlan(@NotNull @PathParam("trainingPlanId") Integer trainingPlanId);
}
