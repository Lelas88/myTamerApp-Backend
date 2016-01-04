package com.mastalerek.mytamer.webmodel;

import java.util.List;

public class ExerciseWebModel {
	private Integer id;
	private Integer disciplineId;
	private String disciplineName;
	private Integer unitId;
	private String unitName;
	private Integer secondUnitId;
	private String secondUnitName;
	private String name;
	private String description;
	private String iconName;
	private Integer trainerId;
	private List<StudentNameWebModel> studentNames;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDisciplineName() {
		return disciplineName;
	}

	public void setDisciplineName(String disciplineName) {
		this.disciplineName = disciplineName;
	}

	public String getUnitName() {
		return unitName;
	}

	public void setUnitName(String unitName) {
		this.unitName = unitName;
	}

	public String getSecondUnitName() {
		return secondUnitName;
	}

	public void setSecondUnitName(String secondUnitName) {
		this.secondUnitName = secondUnitName;
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

	public String getIconName() {
		return iconName;
	}

	public void setIconName(String iconName) {
		this.iconName = iconName;
	}

	public List<StudentNameWebModel> getStudentNames() {
		return studentNames;
	}

	public void setStudentNames(List<StudentNameWebModel> studentNames) {
		this.studentNames = studentNames;
	}

	public Integer getDisciplineId() {
		return disciplineId;
	}

	public void setDisciplineId(Integer disciplineId) {
		this.disciplineId = disciplineId;
	}

	public Integer getUnitId() {
		return unitId;
	}

	public void setUnitId(Integer unitId) {
		this.unitId = unitId;
	}

	public Integer getSecondUnitId() {
		return secondUnitId;
	}

	public void setSecondUnitId(Integer secondUnitId) {
		this.secondUnitId = secondUnitId;
	}

	public Integer getTrainerId() {
		return trainerId;
	}

	public void setTrainerId(Integer trainerId) {
		this.trainerId = trainerId;
	}

}
