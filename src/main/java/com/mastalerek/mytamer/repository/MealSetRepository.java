package com.mastalerek.mytamer.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.mastalerek.mytamer.entity.MealSet;

public interface MealSetRepository extends CrudRepository<MealSet, Integer>{
	List<MealSet> findByUserId(Integer userId);
}
