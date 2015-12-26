package com.mastalerek.mytamer.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.mastalerek.mytamer.entity.MealNutritional;

public interface MealNutritionalRepository extends CrudRepository<MealNutritional, Integer>{
	List<MealNutritional> findByMealId(Integer mealId);
}
