package com.mastalerek.mytamer.repository;

import java.util.Date;

import org.springframework.data.repository.CrudRepository;

import com.mastalerek.mytamer.entity.StudentGoal;

public interface StudentGoalRepository extends CrudRepository<StudentGoal, Integer>{

	StudentGoal findByStudentIdAndExerciseIdAndAccomplishedAndUnitId(Integer studentId, Integer exerciseId, Date date, Integer unitId);

	Integer countByStudentIdAndAccomplished(Integer studentId, Date date);

}
