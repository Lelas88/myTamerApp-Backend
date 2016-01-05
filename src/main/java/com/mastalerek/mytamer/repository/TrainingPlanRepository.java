package com.mastalerek.mytamer.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.mastalerek.mytamer.entity.TrainingPlan;

public interface TrainingPlanRepository extends CrudRepository<TrainingPlan, Integer> {

	public String findNameById(Integer trainingPlanId);

	public List<TrainingPlan> findByIdIn(List<Integer> trainingPlanIds);

	public List<TrainingPlan> findByUserId(Integer userId);

	@Query("select tp from TrainingPlan tp where tp.user.id = :userId and tp.id not in (select tpd.trainingPlan.id from TrainingPlanDiet tpd where tpd.diet.id = :dietId)")
	public List<TrainingPlan> findTrainingPlansNotLinkedWithDiet(@Param("dietId") Integer dietId, @Param("userId") Integer userId);

}
