package com.mastalerek.mytamer.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.mastalerek.mytamer.entity.ExerciseSet;

public interface ExerciseSetRepository extends CrudRepository<ExerciseSet, Integer> {

	List<ExerciseSet> findByUserId(Integer userId);

	@Query("select es from ExerciseSet es where es.user.id = :userId and es.id not in (select tp.exerciseSet.id from TrainingPlanExerciseSet tp where tp.trainingPlan.id = :trainingPlanId)")
	List<ExerciseSet> findNotAssignedToTrainingPlan(@Param("trainingPlanId") Integer trainingPlanId, @Param("userId") Integer userId);
	
	@Query("select es from ExerciseSet es where es.id in (select tp.exerciseSet.id from TrainingPlanExerciseSet tp where tp.trainingPlan.id = :trainingPlanId)")
	List<ExerciseSet> findAssignedToTrainingPlan(@Param("trainingPlanId") Integer trainingPlanId);
}
