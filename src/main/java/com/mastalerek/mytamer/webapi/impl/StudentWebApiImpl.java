package com.mastalerek.mytamer.webapi.impl;

import java.text.ParseException;
import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.Response;

import org.springframework.stereotype.Component;

import com.mastalerek.mytamer.service.ContraindicationService;
import com.mastalerek.mytamer.service.StudentService;
import com.mastalerek.mytamer.service.UserService;
import com.mastalerek.mytamer.webapi.StudentWebApi;
import com.mastalerek.mytamer.webmodel.DietBasicWebModel;
import com.mastalerek.mytamer.webmodel.StudentWebModel;
import com.mastalerek.mytamer.webmodel.UserWebModel;

@Component
public class StudentWebApiImpl implements StudentWebApi {

	@Inject
	private StudentService studentService;
	@Inject
	private ContraindicationService contraindicationService;
	@Inject
	private UserService userService;

	@Override
	public List<StudentWebModel> getStudentsByGroupId(Integer groupId) {
		return studentService.getStudentsByGroupId(groupId);
	}

	@Override
	public Response createStudent(StudentWebModel student) {
		try {
			Integer studentId = studentService.createStudent(student);
			return Response.ok().entity(Entity.text(String.valueOf(studentId))).build();
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

	@Override
	public List<StudentWebModel> getStudentsWithNoGroupAssigned(Integer userId) {
		return studentService.getStudentsWithNoGroupAssigned(userId);
	}

	@Override
	public Response deleteStudent(Integer studentId) {
		try {
			studentService.deleteStudent(studentId);
			return Response.ok().build();
		} catch (Exception e) {
			e.printStackTrace();
			return Response.notModified(e.toString()).build();
		}
	}

	@Override
	public UserWebModel verifyEmail(String email) {
		return userService.verifyEmail(email);
	}

	@Override
	public UserWebModel verifyLogin(String login) {
		return userService.verifyLogin(login);
	}

	@Override
	public Response updateStudent(StudentWebModel studentWebModel) {
		try {
			studentService.updateStudent(studentWebModel);
			return Response.ok().build();
		} catch (Exception e) {
			e.printStackTrace();
			return Response.notModified(e.toString()).build();
		}
	}

}
