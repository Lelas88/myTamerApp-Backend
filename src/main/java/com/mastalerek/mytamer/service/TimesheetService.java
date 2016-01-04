package com.mastalerek.mytamer.service;

import java.text.ParseException;
import java.util.Date;
import java.util.List;

import javax.inject.Inject;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.google.common.collect.Lists;
import com.mastalerek.mytamer.entity.Student;
import com.mastalerek.mytamer.entity.Timesheet;
import com.mastalerek.mytamer.repository.StudentRepository;
import com.mastalerek.mytamer.repository.TimesheetRepository;
import com.mastalerek.mytamer.webmodel.PresenceWebModel;
import com.mastalerek.mytamer.webmodel.StudentWebModel;

@Component
public class TimesheetService {
	@Inject
	private TimesheetRepository timesheetRepository;
	@Inject
	private StudentRepository studentRepository;
	@Inject
	private StudentService studentService;
	@Inject
	private DateService dateService;

	public void saveTimesheet(List<Integer> studentIds) {
		for (Integer studentId : studentIds) {
			savePresence(studentId);
		}
	}

	@Transactional
	private void savePresence(Integer studentId) {
		Timesheet timesheet = new Timesheet();
		timesheet.setDate(new Date());
		Student student = studentRepository.findOne(studentId);
		if (student != null) {
			timesheet.setStudent(student);
			timesheetRepository.save(timesheet);
		}
	}

	public List<PresenceWebModel> checkPresence(Integer groupId, String dateA, String dateB) throws ParseException {
		Date dateFrom = dateService.convertStringToUtilDate(dateA);
		Date dateTo = dateService.convertStringToUtilDate(dateB);
		List<PresenceWebModel> output = Lists.newArrayList();
		List<StudentWebModel> students = studentService.getStudentsByGroupId(groupId);

		for (StudentWebModel student : students) {
			List<Timesheet> studentTimesheets = timesheetRepository.findByStudentIdAndDateBetween(student.getId(), dateFrom, dateTo);
			List<Date> dates = Lists.newArrayList();
			studentTimesheets.forEach(e -> dates.add(e.getDate()));
			PresenceWebModel presence = new PresenceWebModel();
			presence.setPresenceDates(dates);
			presence.setStudentName(StringUtils.join(student.getFirstName(), " ", student.getLastName()));
			presence.setPresenceCounter(dates.size());
			output.add(presence);
		}
		return output;
	}
}
