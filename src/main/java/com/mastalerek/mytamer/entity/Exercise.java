package com.mastalerek.mytamer.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "exercises")
public class Exercise {
	private Integer id;
	private Discipline discipline;
	private ExerciseUnit unit;
	private ExerciseUnit secondUnit;
	private String name;
	private String description;
	private String iconName;
	private List<StudentExercise> studentExercises;
	private List<StudentScore> studentScores;
	private User user;

	@Id
	@GeneratedValue
	@Column(name = "id", unique = true, nullable = false)
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "discipline_id", nullable = false)
	public Discipline getDiscipline() {
		return discipline;
	}

	public void setDiscipline(Discipline discipline) {
		this.discipline = discipline;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "unit_id", nullable = false)
	public ExerciseUnit getUnit() {
		return unit;
	}

	public void setUnit(ExerciseUnit unit) {
		this.unit = unit;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "second_unit_id", nullable = true)
	public ExerciseUnit getSecondUnit() {
		return secondUnit;
	}

	public void setSecondUnit(ExerciseUnit secondUnit) {
		this.secondUnit = secondUnit;
	}

	@Column(name = "name", nullable = false)
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Lob
	@Column(name = "description", nullable = true)
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Column(name = "icon_name", nullable = true)
	public String getIconName() {
		return iconName;
	}

	public void setIconName(String iconName) {
		this.iconName = iconName;
	}

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "exercise")
	public List<StudentExercise> getStudentExercises() {
		return studentExercises;
	}

	public void setStudentExercises(List<StudentExercise> studentExercises) {
		this.studentExercises = studentExercises;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id", nullable = false)
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "exercise", cascade = CascadeType.ALL)
	public List<StudentScore> getStudentScores() {
		return studentScores;
	}

	public void setStudentScores(List<StudentScore> studentScores) {
		this.studentScores = studentScores;
	}
	
}
