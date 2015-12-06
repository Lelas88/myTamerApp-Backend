package com.mastalerek.mytamer.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

//@Entity
//@Table(name = "exercise_sets")
public class ExerciseSet {
//	private Integer id;
//	private Integer trainingPlanId;
//	private Integer exerciseId;
//
//	@Id
//	@GeneratedValue
//	@Column(name = "id", unique = true, nullable = false)
//	public Integer getId() {
//		return id;
//	}
//
//	public void setId(Integer id) {
//		this.id = id;
//	}
//
//	@ManyToOne(fetch = FetchType.LAZY)
//	@JoinColumn(name = "training_plan_id", nullable = false)
//	public Integer getTrainingPlanId() {
//		return trainingPlanId;
//	}
//
//	public void setTrainingPlanId(Integer trainingPlanId) {
//		this.trainingPlanId = trainingPlanId;
//	}
//
//	@OneToMany(fetch = FetchType.LAZY, mappedBy = "exercise")
//	public Integer getExerciseId() {
//		return exerciseId;
//	}
//
//	public void setExerciseId(Integer exerciseId) {
//		this.exerciseId = exerciseId;
//	}

}
