package com.mastalerek.mytamer.repository;

import org.springframework.data.repository.CrudRepository;

import com.mastalerek.mytamer.entity.Measurement;

public interface MeasurementRepository extends CrudRepository<Measurement, Integer>{
}
