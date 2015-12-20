package com.mastalerek.mytamer.webapi.impl;

import java.text.ParseException;
import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.core.Response;

import org.springframework.stereotype.Component;

import com.mastalerek.mytamer.service.ContraindicationService;
import com.mastalerek.mytamer.service.StudentService;
import com.mastalerek.mytamer.webapi.StudentWebApi;
import com.mastalerek.mytamer.webmodel.DietBasicWebModel;
import com.mastalerek.mytamer.webmodel.StudentWebModel;

@Component
public class StudentWebApiImpl implements StudentWebApi {

	@Inject
	private StudentService studentService;
	@Inject
	private ContraindicationService contraindicationService;

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
	public List<StudentWebModel> getUserStudents(Integer userId) {
		return studentService.getStudentsByUserId(userId);
	}

	@Override
	public StudentWebModel getStudent(Integer studentId) {
		return studentService.getStudent(studentId);
	}

	@Override
	public List<String> getStudentContraindications(Integer studentId) {
		return contraindicationService.getStudentContraindications(studentId);
	}

	@Override
	public List<DietBasicWebModel> getStudentDiets(Integer studentId) {
		return studentService.getStudentDiets(studentId);
	}

}
