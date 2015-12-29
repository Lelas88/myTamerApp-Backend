package com.mastalerek.mytamer.service;

import java.sql.Date;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.Period;
import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Component;

import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Lists;
import com.mastalerek.mytamer.builder.RankBuilder;
import com.mastalerek.mytamer.entity.Student;
import com.mastalerek.mytamer.entity.TrainingPlan;
import com.mastalerek.mytamer.entity.TrainingPlanDiet;
import com.mastalerek.mytamer.functions.DietToDietBasicWebModelFunction;
import com.mastalerek.mytamer.functions.StudentEntityToStudentWebModelFunction;
import com.mastalerek.mytamer.repository.GroupRepository;
import com.mastalerek.mytamer.repository.StudentRepository;
import com.mastalerek.mytamer.webmodel.DietBasicWebModel;
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
	private TrainingPlanService trainingPlanService;
	@Inject
	private StudentEntityToStudentWebModelFunction studentEntityToStudentWebModelFunction;
	@Inject
	private DietToDietBasicWebModelFunction dietToDietBasicWebModelFunction;

	public List<StudentWebModel> getStudentsByGroupId(Integer groupId) {
		List<Student> studentsList = studentRepository.findByGroupId(groupId);
		List<StudentWebModel> studentsWebModelList = Lists.newArrayList();
		for (Student student : studentsList) {
			StudentWebModel studentWebModel = studentEntityToStudentWebModelFunction.apply(student);
			studentsWebModelList.add(studentWebModel);
		}
		return studentsWebModelList;
	}

	public Integer calculateStudentAge(Date birthdate) {
		LocalDate today = LocalDate.now();
		LocalDate birthday = birthdate.toLocalDate();
		return Period.between(birthday, today).getYears();
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

	public List<StudentWebModel> getStudentsByUserId(Integer userId) {
		List<Student> students = studentRepository.findByTrainerId(userId);
		return Lists.transform(students, studentEntityToStudentWebModelFunction);
	}

	public StudentWebModel getStudent(Integer studentId) {
		return studentEntityToStudentWebModelFunction.apply(studentRepository.findOne(studentId));
	}

	public List<DietBasicWebModel> getStudentDiets(Integer studentId) {
		List<TrainingPlanDiet> diets = Lists.newArrayList();
		List<TrainingPlan> studentTrainingPlans = trainingPlanService.getTrainingPlansByStudentId(studentId);
		for (TrainingPlan trainingPlan : studentTrainingPlans) {
			diets.addAll(trainingPlan.getTrainingPlanDiets());
		}
		return Lists.transform(ImmutableSet.copyOf(diets).asList(), dietToDietBasicWebModelFunction);
	}

	public List<StudentWebModel> getStudentsWithNoGroupAssigned(Integer userId) {
		List<Student> students = studentRepository.findByTrainerIdAndGroup(userId, null);
		return Lists.transform(students, studentEntityToStudentWebModelFunction);
	}

	public void unassignGroup(Integer groupId) {
		List<Student> students = studentRepository.findByGroupId(groupId);
		for (Student student : students) {
			student.setGroup(null);
			studentRepository.save(student);
		}
	}
}
