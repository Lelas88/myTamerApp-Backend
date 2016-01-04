package com.mastalerek.mytamer.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "student_goal_initial_states")
public class StudentGoalInitialState {
	private Integer id;
	private Student student;
	private Exercise exercise;
	private Double firstState;
	private ExerciseUnit unit;

	@Id
	@GeneratedValue
	@Column(name = "id", unique = true, nullable = false)
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@ManyToOne
	@JoinColumn(name = "student_id", nullable = false)
	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	@ManyToOne
	@JoinColumn(name = "exercise_id", nullable = false)
	public Exercise getExercise() {
		return exercise;
	}

	public void setExercise(Exercise exercise) {
		this.exercise = exercise;
	}

	@Column(name = "first_state", nullable = false)
	public Double getFirstState() {
		return firstState;
	}

	public void setFirstState(Double firstState) {
		this.firstState = firstState;
	}

	@ManyToOne
	@JoinColumn(name = "unit_id", nullable = false)
	public ExerciseUnit getUnit() {
		return unit;
	}

	public void setUnit(ExerciseUnit unit) {
		this.unit = unit;
	}


}
