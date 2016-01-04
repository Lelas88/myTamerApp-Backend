package com.mastalerek.mytamer.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.mastalerek.mytamer.entity.StudentExercise;

public interface StudentExerciseRepository extends CrudRepository<StudentExercise, Integer> {

	StudentExercise findByExerciseIdAndStudentId(Integer exerciseId, Integer studentId);

	void deleteByExerciseIdAndStudentId(Integer exerciseId, Integer studentId);

	List<StudentExercise> findByExerciseId(Integer exerciseId);

}
