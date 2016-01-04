package com.mastalerek.mytamer.webapi.impl;

import java.text.ParseException;
import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.core.Response;

import org.assertj.core.util.Lists;
import org.springframework.stereotype.Component;

import com.mastalerek.mytamer.service.TimesheetService;
import com.mastalerek.mytamer.webapi.TimesheetWebApi;
import com.mastalerek.mytamer.webmodel.PresenceWebModel;

@Component
public class TimesheetWebApiImpl implements TimesheetWebApi {

	@Inject 
	private TimesheetService timesheetService;
	
	@Override
	public Response saveTimesheet(List<Integer> studentIds) {
		timesheetService.saveTimesheet(studentIds);
		return Response.ok().build();
	}

	@Override
	public List<PresenceWebModel> checkPresence(Integer groupId, String dateA, String dateB) {
		try {
			return timesheetService.checkPresence(groupId, dateA, dateB);
		} catch (ParseException e) {
			e.printStackTrace();
			return Lists.newArrayList();
		}
	}

}
