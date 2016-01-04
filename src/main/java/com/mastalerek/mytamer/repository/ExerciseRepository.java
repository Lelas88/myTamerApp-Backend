package com.mastalerek.mytamer.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.mastalerek.mytamer.entity.Exercise;

public interface ExerciseRepository extends CrudRepository<Exercise, Integer> {
	List<Exercise> findByDisciplineId(Integer disciplineId);

	List<Exercise> findByUserId(Integer userId);

	@Query("select e from Exercise e where e.id not in (select ese.exercise.id from ExerciseSetExercise ese where ese.exerciseSet.id=:exerciseSetId)")
	List<Exercise> findExercisesNotAssignedToExerciseSetId(@Param("exerciseSetId") Integer exerciseSetId);
}
