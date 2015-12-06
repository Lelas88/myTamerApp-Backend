package com.mastalerek.mytamer.repository;

import org.springframework.data.repository.CrudRepository;

import com.mastalerek.mytamer.entity.StudentPhoto;

public interface StudentPhotoRepository extends CrudRepository<StudentPhoto, Integer>{
	public StudentPhoto findByStudentId(Integer studentId);
}
