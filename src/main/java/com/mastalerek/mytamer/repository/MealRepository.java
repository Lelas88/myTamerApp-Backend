package com.mastalerek.mytamer.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.mastalerek.mytamer.entity.Meal;

public interface MealRepository extends CrudRepository<Meal, Integer>{

	List<Meal> findByUserId(Integer userId);

	@Query("select m from Meal m where m.user.id = :userId and m.id not in (select msm.meal.id from MealSetMeals msm where msm.mealSet.id = :mealSetId)")
	List<Meal> findMealsNotAssignedToMealSet(@Param("mealSetId") Integer mealSetId, @Param("userId") Integer userId);

}
