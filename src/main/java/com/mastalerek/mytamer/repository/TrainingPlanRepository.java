package com.mastalerek.mytamer.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.mastalerek.mytamer.entity.TrainingPlan;

public interface TrainingPlanRepository extends CrudRepository<TrainingPlan, Integer> {

	public String findNameById(Integer trainingPlanId);

	public List<TrainingPlan> findByIdIn(List<Integer> trainingPlanIds);

	public List<TrainingPlan> findByUserId(Integer userId);

}
