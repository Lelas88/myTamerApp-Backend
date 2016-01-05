package com.mastalerek.mytamer.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.mastalerek.mytamer.entity.MealSet;

public interface MealSetRepository extends CrudRepository<MealSet, Integer>{
	List<MealSet> findByUserId(Integer userId);

	@Query("select ms from MealSet ms where ms.user.id = :userId and ms.id not in (select dms.mealSet.id from DietMealSets dms where dms.diet.id = :dietId)")
	List<MealSet> findMealSetsNotLinkedWithDiet(@Param("dietId") Integer dietId, @Param("userId") Integer userId);
}
