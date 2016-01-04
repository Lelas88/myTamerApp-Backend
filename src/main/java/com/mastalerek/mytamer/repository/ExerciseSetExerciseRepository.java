package com.mastalerek.mytamer.repository;

import org.springframework.data.repository.CrudRepository;

import com.mastalerek.mytamer.entity.ExerciseSetExercise;

public interface ExerciseSetExerciseRepository extends CrudRepository<ExerciseSetExercise, Integer>{

	ExerciseSetExercise findByExerciseSetIdAndExerciseId(Integer exerciseSetId, Integer exerciseId);

}
