package com.mastalerek.mytamer.entity;

import java.util.List;

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
@Table(name = "training_plans")
public class TrainingPlan {
	private Integer id;
	private String name;
	private String description;
	private List<TrainingPlanExerciseSet> exerciseSets;
	private List<TrainingPlanDiet> trainingPlanDiets;
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

	@Column(name = "name", nullable = false)
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Lob
	@Column(name = "description", nullable = false)
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "exerciseSet")
	public List<TrainingPlanExerciseSet> getExerciseSets() {
		return exerciseSets;
	}

	public void setExerciseSets(List<TrainingPlanExerciseSet> exerciseSets) {
		this.exerciseSets = exerciseSets;
	}

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "diet")
	public List<TrainingPlanDiet> getTrainingPlanDiets() {
		return trainingPlanDiets;
	}

	public void setTrainingPlanDiets(List<TrainingPlanDiet> trainingPlanDiets) {
		this.trainingPlanDiets = trainingPlanDiets;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id", nullable = false)
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
}
