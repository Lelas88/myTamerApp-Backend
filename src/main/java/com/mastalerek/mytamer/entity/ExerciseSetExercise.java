package com.mastalerek.mytamer.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "exercise_set_exercises")
public class ExerciseSetExercise {
	private Integer id;
	private Exercise exercise;
	private ExerciseSet exerciseSet;

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
	@JoinColumn(name = "exercise_id", nullable = false)
	public Exercise getExercise() {
		return exercise;
	}

	public void setExercise(Exercise exercise) {
		this.exercise = exercise;
	}

	@ManyToOne
	@JoinColumn(name = "exercise_set_id", nullable = false)
	public ExerciseSet getExerciseSet() {
		return exerciseSet;
	}

	public void setExerciseSet(ExerciseSet exerciseSet) {
		this.exerciseSet = exerciseSet;
	}

}
