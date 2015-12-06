package com.mastalerek.mytamer.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Component;

import com.mastalerek.mytamer.entity.ExerciseUnit;
import com.mastalerek.mytamer.repository.ExerciseUnitRepository;

@Component
public class ExerciseUnitService {
	@Inject
	private ExerciseUnitRepository exerciseUnitRepository;

	public List<ExerciseUnit> getAllExerciseUnits() {
		return (List<ExerciseUnit>) exerciseUnitRepository.findAll();
	}
} 
