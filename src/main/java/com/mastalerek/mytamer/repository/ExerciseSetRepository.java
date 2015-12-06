package com.mastalerek.mytamer.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.mastalerek.mytamer.entity.ExerciseSet;

public interface ExerciseSetRepository {//extends CrudRepository<ExerciseSet, Integer>{
	List<ExerciseSet> findByTrainingPlanId(Integer trainingPlanId);

}
