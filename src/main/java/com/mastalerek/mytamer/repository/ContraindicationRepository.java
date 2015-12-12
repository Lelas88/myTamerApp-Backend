package com.mastalerek.mytamer.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.mastalerek.mytamer.entity.Contraindication;

public interface ContraindicationRepository extends CrudRepository<Contraindication, Integer> {
	List<Contraindication> findByStudentId(Integer studentId);
}
