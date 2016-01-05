package com.mastalerek.mytamer.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.mastalerek.mytamer.entity.DietMealSets;

public interface DietMealSetsRepository extends CrudRepository<DietMealSets, Integer>{

	List<DietMealSets> findByDietId(Integer id);

	DietMealSets findByDietIdAndMealSetId(Integer dietId, Integer mealSetId);

}
