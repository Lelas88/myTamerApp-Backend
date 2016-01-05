package com.mastalerek.mytamer.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Component;

import com.google.common.collect.ImmutableSet;
import com.mastalerek.mytamer.entity.Beacon;
import com.mastalerek.mytamer.entity.Exercise;
import com.mastalerek.mytamer.functions.ExerciseToExerciseWebModelFunction;
import com.mastalerek.mytamer.repository.BeaconRepository;
import com.mastalerek.mytamer.repository.ExerciseRepository;
import com.mastalerek.mytamer.webmodel.ExerciseWebModel;

import jersey.repackaged.com.google.common.collect.Lists;

@Component
public class BeaconService {
	@Inject
	private ExerciseRepository exerciseRepository;
	@Inject
	private BeaconRepository beaconRepository;
	@Inject
	private ExerciseToExerciseWebModelFunction exerciseToExerciseWebModelFunction;

	public List<ExerciseWebModel> getBeaconExercises(Integer minor, Integer major, String uuid) {
		List<Beacon> beacons = getBeaconsList(minor, major, uuid);
		List<ExerciseWebModel> exercises = Lists.newArrayList();
		for (Beacon beacon : beacons) {
			Exercise exercise = exerciseRepository.findOne(beacon.getExercise().getId());
			exercises.add(exerciseToExerciseWebModelFunction.apply(exercise));
		}
		return exercises;
	}

	private List<Beacon> getBeaconsList(Integer major, Integer minor, String uuid) {
		List<Beacon> beacons = beaconRepository.findByUuidAndMinorAndMajor(uuid, minor, major);
		beacons.addAll(beacons);
		return ImmutableSet.copyOf(beacons).asList();
	}
}
