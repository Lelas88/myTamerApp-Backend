package com.mastalerek.mytamer.service;

import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Lists;
import com.mastalerek.mytamer.entity.Student;
import com.mastalerek.mytamer.entity.TrainingPlan;
import com.mastalerek.mytamer.entity.TrainingPlanDiet;
import com.mastalerek.mytamer.entity.User;
import com.mastalerek.mytamer.functions.DietToDietBasicWebModelFunction;
import com.mastalerek.mytamer.functions.StudentEntityToStudentWebModelFunction;
import com.mastalerek.mytamer.repository.RankRepository;
import com.mastalerek.mytamer.repository.StudentRepository;
import com.mastalerek.mytamer.repository.UserRepository;
import com.mastalerek.mytamer.webmodel.DietBasicWebModel;
import com.mastalerek.mytamer.webmodel.StudentWebModel;

@Component
public class StudentService {

	private static final int INITIAL_RANK = 1;
	@Inject
	private StudentRepository studentRepository;
	@Inject
	private MeasurementService measurementService;
	@Inject
	private DateService dateService;
	@Inject
	private UserRepository userRepository;
	@Inject
	private TrainingPlanService trainingPlanService;
	@Inject
	private StudentEntityToStudentWebModelFunction studentEntityToStudentWebModelFunction;
	@Inject
	private DietToDietBasicWebModelFunction dietToDietBasicWebModelFunction;
	@Inject
	private RankRepository rankRepository;

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
		Calendar dob = Calendar.getInstance();
		dob.setTime(birthdate);
		Calendar today = Calendar.getInstance();
		int age = today.get(Calendar.YEAR) - dob.get(Calendar.YEAR);
		if (today.get(Calendar.MONTH) < dob.get(Calendar.MONTH)) {
			age--;
		} else if (today.get(Calendar.MONTH) == dob.get(Calendar.MONTH)
				&& today.get(Calendar.DAY_OF_MONTH) < dob.get(Calendar.DAY_OF_MONTH)) {
			age--;
		}
		return age;
	}

	public Integer createStudent(StudentWebModel studentModel) throws ParseException {
		User trainer = userRepository.findOne(studentModel.getTrainerId());
		Student student = new Student();
		student.setBirthdate(dateService.convertStringToUtilDate(studentModel.getBirthdate()));
		student.setFirstName(studentModel.getFirstName());
		student.setLastName(studentModel.getLastName());
		student.setRank(rankRepository.findOne(INITIAL_RANK));
		student.setGroup(null);
		student.setTrainer(trainer);
		Student savedStudent = studentRepository.save(student);
		measurementService.saveStudentMeasurements(savedStudent, studentModel);
		return savedStudent.getId();
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

	@Transactional
	public void deleteStudent(Integer studentId) {
		studentRepository.delete(studentId);
	}

	public void updateStudent(StudentWebModel studentWebModel) throws ParseException {
		Student student = studentRepository.findOne(studentWebModel.getId());
		if (student != null) {
			student.setBirthdate(dateService.convertStringToUtilDate(studentWebModel.getBirthdate()));
			student.setFirstName(studentWebModel.getFirstName());
			student.setLastName(studentWebModel.getLastName());
			studentRepository.save(student);
		}
	}

	public List<StudentWebModel> getAllStudents() {
		return Lists.transform((List<Student>) studentRepository.findAll(), studentEntityToStudentWebModelFunction);
	}

	public List<StudentWebModel> getStudentsNotAssignedToExercise(Integer exerciseId) {
		List<Student> students = studentRepository.findNotAssignedToExercise(exerciseId);
		return Lists.transform(students, studentEntityToStudentWebModelFunction);
	}

	public List<StudentWebModel> getStudentsAssignedToExercise(Integer exerciseId) {
		List<Student> students = studentRepository.findAssignedToExercise(exerciseId);
		return Lists.transform(students, studentEntityToStudentWebModelFunction);
	}

	public List<StudentWebModel> getNotAssignedStudentsToTrainingPlan(Integer trainingPlanId, Integer userId) {
		List<Student> students = studentRepository.findNotAssignedToTrainingPlan(trainingPlanId, userId);
		return Lists.transform(students, studentEntityToStudentWebModelFunction);
	}

	public List<StudentWebModel> getAssignedStudentsToTrainingPlan(Integer trainingPlanId) {
		List<Student> students = studentRepository.findAssignedToTrainingPlan(trainingPlanId);
		return Lists.transform(students, studentEntityToStudentWebModelFunction);
	}
}
