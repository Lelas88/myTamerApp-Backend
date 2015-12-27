package com.mastalerek.mytamer.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.mastalerek.mytamer.entity.Diet;

public interface DietRepository extends CrudRepository<Diet, Integer>{

	List<Diet> findByUserId(Integer userId);

}
