package com.mastalerek.mytamer.enums;

public enum ExerciseUnit {
	REPEATS(1), TIME(2), DISTANCE(3), WEIGHT(4);

	private final int value;

	private ExerciseUnit(int value) {
		this.value = value;
	}

	public int getValue() {
		return value;
	}
}
