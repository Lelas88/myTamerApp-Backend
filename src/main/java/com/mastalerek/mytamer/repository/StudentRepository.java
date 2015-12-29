package com.mastalerek.mytamer.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.mastalerek.mytamer.entity.Student;

public interface StudentRepository extends CrudRepository<Student, Integer> {

	List<Student> findByGroupId(Integer userId);

	List<Student> findByTrainerId(Integer userId);

	List<Student> findByTrainerIdAndGroup(Integer userId, Integer groupId);

}
