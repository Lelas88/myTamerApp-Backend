package com.mastalerek.mytamer.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.mastalerek.mytamer.entity.StudentMeasurement;

public interface StudentMeasurementRepository extends CrudRepository<StudentMeasurement, Integer> {
	public List<StudentMeasurement> findByStudentIdOrderByDateAsc(Integer studentId);

	public StudentMeasurement findTop1ByStudentIdAndMeasurementIdOrderByDateDesc(Integer studentId, Integer measurementId);
}
