package com.mastalerek.mytamer.repository;

import org.springframework.data.repository.CrudRepository;

import com.mastalerek.mytamer.entity.StudentGoalInitialState;

public interface StudentGoalInitialStateRepository extends CrudRepository<StudentGoalInitialState, Integer>{

	StudentGoalInitialState findByStudentIdAndExerciseIdAndUnitId(Integer studentId, Integer exerciseId, Integer unitId);

}
