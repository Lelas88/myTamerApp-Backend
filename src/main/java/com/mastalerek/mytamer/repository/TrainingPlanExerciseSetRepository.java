package com.mastalerek.mytamer.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.mastalerek.mytamer.entity.TrainingPlanExerciseSet;

public interface TrainingPlanExerciseSetRepository extends CrudRepository<TrainingPlanExerciseSet, Integer>{
	List<TrainingPlanExerciseSet> findByExerciseSetId(Integer exerciseSetId);
}
