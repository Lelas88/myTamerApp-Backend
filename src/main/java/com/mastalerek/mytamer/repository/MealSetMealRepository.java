package com.mastalerek.mytamer.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.mastalerek.mytamer.entity.MealSetMeals;

public interface MealSetMealRepository extends CrudRepository<MealSetMeals, Integer>{

	List<MealSetMeals> findByMealSetId(Integer mealSetId);

	MealSetMeals findByMealSetIdAndMealId(Integer mealSetId, Integer mealId);

}
