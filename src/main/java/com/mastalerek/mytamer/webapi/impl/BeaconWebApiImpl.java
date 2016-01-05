package com.mastalerek.mytamer.webapi.impl;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.core.Response;

import org.springframework.stereotype.Component;

import com.mastalerek.mytamer.service.BeaconService;
import com.mastalerek.mytamer.service.ExerciseService;
import com.mastalerek.mytamer.webapi.BeaconWebApi;
import com.mastalerek.mytamer.webmodel.ExerciseWebModel;

@Component
public class BeaconWebApiImpl implements BeaconWebApi {

	@Inject
	private BeaconService beaconService;
	@Inject
	private ExerciseService exerciseService;

	@Override
	public List<ExerciseWebModel> getBeaconExercises(Integer minor, Integer major, String uuid) {
		return beaconService.getBeaconExercises(minor, major, uuid);
	}

	@Override
	public Response downloadExercises(Integer userId, List<Integer> exerciseIds) {
		exerciseService.saveExercises(userId, exerciseIds);
		return Response.ok().build();
	}

}
