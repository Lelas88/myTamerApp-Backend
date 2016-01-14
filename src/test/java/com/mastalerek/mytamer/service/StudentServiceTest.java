package com.mastalerek.mytamer.service;

import static org.assertj.core.api.Assertions.assertThat;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;

public class StudentServiceTest {

	@InjectMocks
	private StudentService tested;

	@Before
	public void before() {
		tested = new StudentService();
		MockitoAnnotations.initMocks(this);
	}

	/**
	 * should be adjusted according to current date
	 * @throws ParseException 
	 */
	@Test
	public void shouldCalculateStudentAge() throws ParseException {
		// given
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date birthdate = sdf.parse("1989-05-02");
		// when
		Integer actual = tested.calculateStudentAge(birthdate);
		// then
		assertThat(actual).isEqualTo(26);
		
	}
}
