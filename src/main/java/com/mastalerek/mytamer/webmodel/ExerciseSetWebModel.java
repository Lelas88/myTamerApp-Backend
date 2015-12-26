package com.mastalerek.mytamer.webmodel;

import java.util.List;

public class ExerciseSetWebModel {
	private Integer id;
	private String name;
	private Integer exerciseLength;
	private List<ObjectNameAndIdWebModel> trainingPlans;
	private List<ObjectNameAndIdWebModel> exercises;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getExerciseLength() {
		return exerciseLength;
	}

	public void setExerciseLength(Integer time) {
		this.exerciseLength = time;
	}

	public List<ObjectNameAndIdWebModel> getTrainingPlans() {
		return trainingPlans;
	}

	public void setTrainingPlans(List<ObjectNameAndIdWebModel> trainingPlans) {
		this.trainingPlans = trainingPlans;
	}

	public List<ObjectNameAndIdWebModel> getExercises() {
		return exercises;
	}

	public void setExercises(List<ObjectNameAndIdWebModel> exercises) {
		this.exercises = exercises;
	}

}
