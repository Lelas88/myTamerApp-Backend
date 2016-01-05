package com.mastalerek.mytamer.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.mastalerek.mytamer.entity.Diet;

public interface DietRepository extends CrudRepository<Diet, Integer>{

	List<Diet> findByUserId(Integer userId);

	@Query("select d from Diet d where user.id = :userId and d.id not in (select tp.diet.id from TrainingPlanDiet tp where tp.trainingPlan.id = :trainingPlanId)")
	List<Diet> findNotAssignedToTrainingPlan(@Param("trainingPlanId") Integer trainingPlanId, @Param("userId") Integer userId);

	@Query("select d from Diet d where d.id in (select tp.diet.id from TrainingPlanDiet tp where tp.trainingPlan.id = :trainingPlanId)")
	List<Diet> findAssignedToTrainingPlan(@Param("trainingPlanId") Integer trainingPlanId);

}
