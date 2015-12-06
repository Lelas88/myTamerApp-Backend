package com.mastalerek.mytamer.service;

import javax.inject.Inject;

import org.springframework.stereotype.Component;

import com.mastalerek.mytamer.entity.StudentPhoto;
import com.mastalerek.mytamer.repository.StudentPhotoRepository;

@Component
public class StudentPhotoService {

	@Inject
	private StudentPhotoRepository studentPhotoRepository;

	public String getStudentPhoto(Integer studentId) {
		StudentPhoto studentPhoto = studentPhotoRepository.findByStudentId(studentId);
		return studentPhoto.getPhotoName();
	}
}
