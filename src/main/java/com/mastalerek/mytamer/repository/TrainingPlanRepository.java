package com.mastalerek.mytamer.repository;

import org.springframework.data.repository.CrudRepository;

import com.mastalerek.mytamer.entity.TrainingPlan;

public interface TrainingPlanRepository extends CrudRepository<TrainingPlan, Integer> {

	String findNameById(Integer trainingPlanId);

}
