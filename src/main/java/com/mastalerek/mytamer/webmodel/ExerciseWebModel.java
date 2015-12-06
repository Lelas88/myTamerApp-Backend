package com.mastalerek.mytamer.webmodel;

import java.util.List;

public class ExerciseWebModel {
	private Integer id;
	private Integer disciplineId;
	private Integer unitId;
	private Integer secondUnitId;
	private String name;
	private String descritpion;
	private String iconName;
	private List<StudentNameWebModel> studentNames;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescritpion() {
		return descritpion;
	}

	public void setDescritpion(String descritpion) {
		this.descritpion = descritpion;
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

}
