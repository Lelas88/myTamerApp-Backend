package com.mastalerek.mytamer.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.mastalerek.mytamer.entity.StudentScore;

public interface StudentScoreRepository extends CrudRepository<StudentScore, Integer> {

	List<StudentScore> findByStudentIdAndExerciseIdAndUnitId(Integer studentId, Integer exerciseId, Integer unitId);

}
