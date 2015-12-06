package com.mastalerek.mytamer.webapi.impl;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Component;

import com.mastalerek.mytamer.entity.ExerciseUnit;
import com.mastalerek.mytamer.service.ExerciseUnitService;
import com.mastalerek.mytamer.webapi.ExerciseUnitWebApi;

@Component
public class ExerciseUnitWebApiImpl implements ExerciseUnitWebApi {

	@Inject
	private ExerciseUnitService exerciseUnitService;
	
	@Override
	public List<ExerciseUnit> getAllExerciseUnits() {
		return exerciseUnitService.getAllExerciseUnits();
	}
	
}
