package com.mastalerek.mytamer.service;

import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.springframework.stereotype.Component;

@Component
public class DateService {

	public Date getCurrentDate() {
		Date date = new Date(Calendar.getInstance().getTime().getTime());
		return date;
	}
	
	public Date parseStringToSqlDate(String stringDate) throws ParseException {
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		return new Date(dateFormat.parse(stringDate).getTime());
	}
}
