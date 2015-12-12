package com.mastalerek.mytamer.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "training_plan_exercise_sets")
public class TrainingPlanExerciseSet {
	private Integer id;
	private TrainingPlan trainingPlan;
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

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "training_plan_id", nullable = false)
	public TrainingPlan getTrainingPlan() {
		return trainingPlan;
	}

	public void setTrainingPlan(TrainingPlan trainingPlan) {
		this.trainingPlan = trainingPlan;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "exercise_set_id", nullable = false)
	public ExerciseSet getExerciseSet() {
		return exerciseSet;
	}

	public void setExerciseSet(ExerciseSet exerciseSet) {
		this.exerciseSet = exerciseSet;
	}

}
