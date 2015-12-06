package com.mastalerek.mytamer.webapi;

import java.util.List;

import javax.validation.constraints.NotNull;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.mastalerek.mytamer.webmodel.DisciplineWebModel;

@Path(DisciplineWebApi.BASE_PATH)
public interface DisciplineWebApi {

	public static final String ICON = "icon";
	public static final String DISCIPLINE_ID = "disciplineId";
	public static final String UPDATE = "/update";
	public static final String CREATE = "/create";
	public static final String IMAGE_JPG = "image/jpg";
	public static final String IMAGE = "/image";
	public static final String GET_ALL = "/all";
	public static final String BASE_PATH = "/disciplines";
	
	@GET
	@Path(GET_ALL)
	@Produces(MediaType.APPLICATION_JSON)
	public List<DisciplineWebModel> getAllDisciplines();
	
	@PUT
	@Path(CREATE)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response createDiscipline(@NotNull DisciplineWebModel disciplineWebModel);
	
	@PUT
	@Path(UPDATE)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response updateDiscipline(@NotNull DisciplineWebModel disciplineWebModel);
}
