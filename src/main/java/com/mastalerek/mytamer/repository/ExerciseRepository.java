package com.mastalerek.mytamer.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.mastalerek.mytamer.entity.Exercise;

public interface ExerciseRepository extends CrudRepository<Exercise, Integer> {
	List<Exercise> findByDisciplineId(Integer disciplineId);

	List<Exercise> findByUserId(Integer userId);
}
