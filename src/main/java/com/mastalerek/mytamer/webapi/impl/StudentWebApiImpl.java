package com.mastalerek.mytamer.webapi.impl;

import java.text.ParseException;
import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.core.Response;

import org.springframework.stereotype.Component;

import com.mastalerek.mytamer.service.StudentPhotoService;
import com.mastalerek.mytamer.service.StudentService;
import com.mastalerek.mytamer.webapi.StudentWebApi;
import com.mastalerek.mytamer.webmodel.StudentWebModel;

@Component
public class StudentWebApiImpl implements StudentWebApi {

	@Inject
	private StudentService studentService;

	@Inject
	private StudentPhotoService studentPhotoService;

	@Override
	public List<StudentWebModel> getStudentsByGroupId(Integer groupId) {
		return studentService.getStudentsByGroupId(groupId);
	}

	@Override
	public Response createStudent(StudentWebModel student) {
		try {
			studentService.createStudent(student);
			return Response.ok().build();
		} catch (ParseException e) {
			e.printStackTrace();
			return Response.notModified(e.toString()).build();
		}
	}

	@Override
	public String getStudentPhoto(Integer studentId) {
		return studentPhotoService.getStudentPhoto(studentId);
	}

	@Override
	public List<StudentWebModel> getUserStudents(Integer userId) {
		return studentService.getStudentsByUserId(userId);
	}

}
