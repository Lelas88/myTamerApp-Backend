package com.mastalerek.mytamer.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "diet_meal_sets")
public class DietMealSets {
	private Integer id;
	private MealSet mealSet;
	private Diet diet;

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
	@JoinColumn(name = "meal_set_id", nullable = false)
	public MealSet getMealSet() {
		return mealSet;
	}

	public void setMealSet(MealSet mealSet) {
		this.mealSet = mealSet;
	}

	@ManyToOne
	@JoinColumn(name = "diet_id", nullable = false)
	public Diet getDiet() {
		return diet;
	}

	public void setDiet(Diet diet) {
		this.diet = diet;
	}
}
