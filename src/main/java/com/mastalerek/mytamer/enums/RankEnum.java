package com.mastalerek.mytamer.enums;

public enum RankEnum {
	NOOBIE(1), BEGINNER(2), AMATOR(3), SEMIPRO(4), PROFESSIONAL(5);

	private final int value;

	private RankEnum(int value) {
		this.value = value;
	}

	public int getValue() {
		return value;
	}
}
