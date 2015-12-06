package com.mastalerek.mytamer.service;

import java.text.ParseException;
import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Component;

import com.google.common.collect.Lists;
import com.mastalerek.mytamer.builder.RankBuilder;
import com.mastalerek.mytamer.entity.Student;
import com.mastalerek.mytamer.functions.StudentEntityToStudentWebModelFunction;
import com.mastalerek.mytamer.repository.GroupRepository;
import com.mastalerek.mytamer.repository.StudentRepository;
import com.mastalerek.mytamer.webmodel.StudentWebModel;

@Component
public class StudentService {
	
	private static final int INITIAL_RANK = 1;
	@Inject
	private StudentRepository studentRepository;
	@Inject
	private GroupRepository groupRepository;
	@Inject
	private DateService dateService;
	@Inject
	private StudentEntityToStudentWebModelFunction studentEntityToStudentWebModelFunction;

	public List<StudentWebModel> getStudentsByGroupId(Integer groupId) {
		List<Student> studentsList = studentRepository.findByGroupId(groupId);
		List<StudentWebModel> studentsWebModelList = Lists.newArrayList();
		for (Student student : studentsList) {
			StudentWebModel studentWebModel = studentEntityToStudentWebModelFunction.apply(student);
			studentsWebModelList.add(studentWebModel);
		}
		return studentsWebModelList;
	}

	public void createStudent(StudentWebModel studentModel) throws ParseException {
		Student student = new Student();
		student.setBirthdate(dateService.parseStringToSqlDate(studentModel.getBirthdate()));
		student.setFirstName(studentModel.getFirstName());
		student.setLastName(studentModel.getLastName());
		student.setRank(new RankBuilder().withId(INITIAL_RANK).build());
		student.setGroup(groupRepository.findOne(studentModel.getGroupId()));
		studentRepository.save(student);
	}
}
