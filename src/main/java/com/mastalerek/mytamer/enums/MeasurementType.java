package com.mastalerek.mytamer.enums;

public enum MeasurementType {
	WEIGHT(1), HEIGHT(2);

	private final int value;

	private MeasurementType(int value) {
		this.value = value;
	}

	public int getValue() {
		return value;
	}
}
