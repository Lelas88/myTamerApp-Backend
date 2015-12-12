package com.mastalerek.mytamer.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "training_plans")
public class TrainingPlan {
	private Integer id;
	private String name;
	private String description;
	private List<ExerciseSet> exerciseSets;
	private List<Diet> diets;

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

	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "training_plan_exercise_sets", joinColumns = @JoinColumn(name = "training_plan_id") , inverseJoinColumns = @JoinColumn(name = "exercise_set_id") )
	public List<ExerciseSet> getExerciseSet() {
		return exerciseSets;
	}

	public void setExerciseSet(List<ExerciseSet> exerciseSets) {
		this.exerciseSets = exerciseSets;
	}

	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "training_plan_diets", joinColumns = @JoinColumn(name = "training_plan_id") , inverseJoinColumns = @JoinColumn(name = "diet_id") )
	public List<Diet> getDiets() {
		return diets;
	}

	public void setDiets(List<Diet> diets) {
		this.diets = diets;
	}

}
