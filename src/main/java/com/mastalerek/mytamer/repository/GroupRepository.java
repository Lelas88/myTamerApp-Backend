package com.mastalerek.mytamer.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.mastalerek.mytamer.entity.Group;

public interface GroupRepository extends CrudRepository<Group, Integer>{

	List<Group> findByUserId(Integer userId);
}
