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

import com.mastalerek.mytamer.webmodel.AllMeasurementsWebModel;
import com.mastalerek.mytamer.webmodel.MeasurementWebModel;
import com.mastalerek.mytamer.webmodel.StudentMeasurementWebModel;

@Path(MeasurementWebApi.BASE_PATH)
public interface MeasurementWebApi {
	public static final String ALL = "/all";
	public static final String BASE_PATH = "/measurement";
	public static final String HISTORY = "/history";
	public static final String LAST_MEASUREMENT = "/lastMeasurement";
	
	@GET
	@Path(ALL)
	@Produces(MediaType.APPLICATION_JSON)
	public List<MeasurementWebModel> getAllMeasurements();

	@GET
	@Path(LAST_MEASUREMENT)
	@Produces(MediaType.APPLICATION_JSON)
	public Double getLastMeasurementByTypeAndStudentId(
			@NotNull @QueryParam("studentId") Integer studentId, @NotNull @QueryParam("type") Integer measurementType);

	@GET
	@Path(HISTORY)
	@Produces(MediaType.APPLICATION_JSON)
	public AllMeasurementsWebModel getMeasurementsHistory(@NotNull @QueryParam("studentId") Integer studentId);
	
	@PUT
	@Path("/addMeasurement")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response createMeasurement(@NotNull StudentMeasurementWebModel measurement);
	
}
