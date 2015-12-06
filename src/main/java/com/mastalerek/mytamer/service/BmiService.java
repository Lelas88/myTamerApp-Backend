package com.mastalerek.mytamer.service;

import java.math.BigDecimal;
import java.math.RoundingMode;

import org.springframework.stereotype.Component;

@Component
public class BmiService {
	
	public Double calculateBmi(Double weight, Double height) {
		return round(weight/(height * height), 2);
	}
	
	private Double round(double value, int places) {
	    if (places < 0) throw new IllegalArgumentException();

	    BigDecimal bigDecimal = new BigDecimal(value);
	    bigDecimal = bigDecimal.setScale(places, RoundingMode.HALF_UP);
	    return bigDecimal.doubleValue();
	}
}
