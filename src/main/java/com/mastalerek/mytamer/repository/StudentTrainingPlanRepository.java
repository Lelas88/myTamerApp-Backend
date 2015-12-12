package com.mastalerek.mytamer.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.mastalerek.mytamer.entity.StudentTrainingPlan;

public interface StudentTrainingPlanRepository extends CrudRepository<StudentTrainingPlan, Integer>{

	List<StudentTrainingPlan> findByStudentId(Integer studentId);

}
