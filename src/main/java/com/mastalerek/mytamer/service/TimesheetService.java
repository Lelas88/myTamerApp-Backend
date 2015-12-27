package com.mastalerek.mytamer.service;

import java.sql.Date;
import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.mastalerek.mytamer.entity.Student;
import com.mastalerek.mytamer.entity.Timesheet;
import com.mastalerek.mytamer.repository.StudentRepository;
import com.mastalerek.mytamer.repository.TimesheetRepository;

@Component
public class TimesheetService {
	@Inject
	private TimesheetRepository timesheetRepository;
	@Inject
	private StudentRepository studentRepository;

	public void saveTimesheet(List<Integer> studentIds) {
		for (Integer studentId : studentIds) {
			savePresence(studentId);
		}
	}

	@Transactional
	private void savePresence(Integer studentId) {
		Timesheet timesheet = new Timesheet();
		timesheet.setDate(new Date(new java.util.Date().getTime()));
		Student student = studentRepository.findOne(studentId);
		if (student != null) {
			timesheet.setStudent(student);
			timesheetRepository.save(timesheet);
		}
	}

}
