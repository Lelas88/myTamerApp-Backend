package com.mastalerek.mytamer.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.mastalerek.mytamer.entity.Meal;

public interface MealRepository extends CrudRepository<Meal, Integer>{

	List<Meal> findByUserId(Integer userId);

}
