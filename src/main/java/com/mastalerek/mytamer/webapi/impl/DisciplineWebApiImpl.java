package com.mastalerek.mytamer.webapi.impl;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.core.Response;

import org.springframework.stereotype.Component;

import com.mastalerek.mytamer.service.DisciplineService;
import com.mastalerek.mytamer.webapi.DisciplineWebApi;
import com.mastalerek.mytamer.webmodel.DisciplineWebModel;

@Component
public class DisciplineWebApiImpl implements DisciplineWebApi {

	@Inject
	DisciplineService disciplineService;

	@Override
	public List<DisciplineWebModel> getAllDisciplines() {
		return disciplineService.getAllDisciplines();
	}

	@Override
	public Response createDiscipline(DisciplineWebModel disciplineWebModel) {
		disciplineService.createDiscipline(disciplineWebModel);
		return Response.ok().build();
	}

	@Override
	public Response updateDiscipline(DisciplineWebModel disciplineWebModel) {
		disciplineService.updateDiscipline(disciplineWebModel);
		return Response.ok().build();
	}

}
