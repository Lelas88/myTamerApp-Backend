package com.mastalerek.mytamer.service;

import java.math.BigDecimal;
import java.math.RoundingMode;

import org.springframework.stereotype.Component;

@Component
public class BmiService {
	
	private static final double INITIAL_VALUE = 0.0;

	public Double calculateBmi(Double weight, Double height) {
		if(weight <= 0 || height <= 0) {
			return INITIAL_VALUE;
		}
		return round(weight/(height * height), 2);
	}
	
	private Double round(double value, int places) {
	    if (places < 0) throw new IllegalArgumentException();

	    BigDecimal bigDecimal = new BigDecimal(value);
	    bigDecimal = bigDecimal.setScale(places, RoundingMode.HALF_UP);
	    return bigDecimal.doubleValue();
	}
}
