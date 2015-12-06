package com.mastalerek.mytamer.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

//@Entity
//@Table(name = "training_plans")
public class TrainingPlan {
//	private Integer id;
//	private String name;
//	private String description;
//	private ExerciseSet exerciseSet;
//	private List<Diet> diets;
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
//	@Column(name = "name", nullable = false)
//	public String getName() {
//		return name;
//	}
//
//	public void setName(String name) {
//		this.name = name;
//	}
//
//	@Lob
//	@Column(name = "description", nullable = false)
//	public String getDescription() {
//		return description;
//	}
//
//	public void setDescription(String description) {
//		this.description = description;
//	}
//
//	@OneToMany(mappedBy = "exerciseSet")
//	@JoinColumn(name = "exercise_set_id", nullable = true)
//	public ExerciseSet getExerciseSet() {
//		return exerciseSet;
//	}
//
//	public void setExerciseSet(ExerciseSet exerciseSet) {
//		this.exerciseSet = exerciseSet;
//	}
//
//	@ManyToMany
//	@JoinColumn(name = "diet_id", nullable = true)
//	public List<Diet> getDiets() {
//		return diets;
//	}
//
//	public void setDiet(List<Diet> diets) {
//		this.diets = diets;
//	}

}
