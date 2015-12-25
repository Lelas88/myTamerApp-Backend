package com.mastalerek.mytamer.webapi.impl;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.core.Response;

import org.springframework.stereotype.Component;

import com.mastalerek.mytamer.service.TimesheetService;
import com.mastalerek.mytamer.webapi.TimesheetWebApi;

@Component
public class TimesheetWebApiImpl implements TimesheetWebApi {

	@Inject 
	private TimesheetService timesheetService;
	
	@Override
	public Response saveTimesheet(List<Integer> studentIds) {
		timesheetService.saveTimesheet(studentIds);
		return Response.ok().build();
	}

}
