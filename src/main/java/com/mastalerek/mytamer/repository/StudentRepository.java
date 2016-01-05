package com.mastalerek.mytamer.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.mastalerek.mytamer.entity.Student;

public interface StudentRepository extends CrudRepository<Student, Integer> {

	List<Student> findByGroupId(Integer userId);

	List<Student> findByTrainerId(Integer userId);

	List<Student> findByTrainerIdAndGroup(Integer userId, Integer groupId);

	@Query("select s from Student s where s.id not in (select se.student.id from StudentExercise se where se.exercise.id = :exerciseId)")
	List<Student> findNotAssignedToExercise(@Param("exerciseId") Integer exerciseId);

	@Query("select s from Student s where s.id in (select se.student.id from StudentExercise se where se.exercise.id = :exerciseId)")
	List<Student> findAssignedToExercise(@Param("exerciseId") Integer exerciseId);

	@Query("select s from Student s where s.trainer.id = :userId and s.id not in (select se.student.id from StudentTrainingPlan se where se.trainingPlan.id = :trainingPlanId)")
	List<Student> findNotAssignedToTrainingPlan(@Param("trainingPlanId") Integer trainingPlanId, @Param("userId") Integer userId);

	@Query("select s from Student s where s.id in (select se.student.id from StudentTrainingPlan se where se.trainingPlan.id = :trainingPlanId)")
	List<Student> findAssignedToTrainingPlan(@Param("trainingPlanId") Integer trainingPlanId);

}
