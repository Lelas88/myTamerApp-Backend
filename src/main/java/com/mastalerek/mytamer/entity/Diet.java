package com.mastalerek.mytamer.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

//@Entity
//@Table(name = "diets")
public class Diet {
//	private Integer id;
//	private String name;
//	private String description;
//	private MealSet mealSet;
//	private Integer active;
//	private List<TrainingPlan> trainingPlans;
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
//	@OneToOne(fetch = FetchType.EAGER)
//	@JoinColumn(name = "diet_id", nullable = false)
//	public MealSet getMealSet() {
//		return mealSet;
//	}
//
//	public void setMealSet(MealSet mealSet) {
//		this.mealSet = mealSet;
//	}
//
//	@Column(name = "active", nullable = false)
//	public Integer getActive() {
//		return active;
//	}
//
//	public void setActive(Integer active) {
//		this.active = active;
//	}
//	
//	@ManyToMany(mappedBy="diets")
//	public List<TrainingPlan> getTrainingPlans() {
//		return trainingPlans;
//	}
//
//	public void setTrainingPlans(List<TrainingPlan> trainingPlans) {
//		this.trainingPlans = trainingPlans;
//	}

}
