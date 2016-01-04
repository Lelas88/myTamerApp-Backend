package com.mastalerek.mytamer.webmodel;

import java.util.Date;
import java.util.List;

public class PresenceWebModel {
	private String studentName;
	private Integer presenceCounter;
	private List<Date> presenceDates;

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public Integer getPresenceCounter() {
		return presenceCounter;
	}

	public void setPresenceCounter(Integer presenceCounter) {
		this.presenceCounter = presenceCounter;
	}

	public List<Date> getPresenceDates() {
		return presenceDates;
	}

	public void setPresenceDates(List<Date> presenceDates) {
		this.presenceDates = presenceDates;
	}

}
