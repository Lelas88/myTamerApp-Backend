package com.mastalerek.mytamer.webmodel;

import java.util.List;

public class TrainingPlanWebModel {
	private Integer id;
	private String name;
	private String description;
	private List<ExerciseSetBasicWebModel> exerciseSets;
	private List<DietBasicWebModel> diets;
	private List<StudentNameWebModel> students;
	private Integer userId;

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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<ExerciseSetBasicWebModel> getExerciseSets() {
		return exerciseSets;
	}

	public void setExerciseSets(List<ExerciseSetBasicWebModel> exerciseSets) {
		this.exerciseSets = exerciseSets;
	}

	public List<DietBasicWebModel> getDiets() {
		return diets;
	}

	public void setDiets(List<DietBasicWebModel> diets) {
		this.diets = diets;
	}

	public List<StudentNameWebModel> getStudents() {
		return students;
	}

	public void setStudents(List<StudentNameWebModel> students) {
		this.students = students;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

}
