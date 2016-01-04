package com.mastalerek.mytamer.webapi.impl;

import javax.inject.Inject;
import javax.ws.rs.core.Response;

import org.springframework.stereotype.Component;

import com.mastalerek.mytamer.service.ResultService;
import com.mastalerek.mytamer.webapi.ResultWebApi;
import com.mastalerek.mytamer.webmodel.ScoreWebModel;

@Component
public class ResultWebApiImpl implements ResultWebApi {

	@Inject
	private ResultService resultService;
	@Override
	public Response saveResult(ScoreWebModel result) {
		resultService.saveResult(result);
		return Response.ok().build();
	}

}
