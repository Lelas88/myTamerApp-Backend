package com.mastalerek.mytamer.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.mastalerek.mytamer.entity.TrainingPlanDiet;

public interface TrainingPlanDietRepository extends CrudRepository<TrainingPlanDiet, Integer> {
	List<TrainingPlanDiet> findByDietId(Integer dietId);

	TrainingPlanDiet findByTrainingPlanIdAndDietId(Integer trainingPlanId, Integer dietId);

	TrainingPlanDiet findByDietIdAndTrainingPlanId(Integer dietId, Integer trainingPlanId);

	List<TrainingPlanDiet> findByTrainingPlanId(Integer trainingPlanId);
}
