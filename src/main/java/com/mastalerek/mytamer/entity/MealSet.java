package com.mastalerek.mytamer.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "meal_sets")
public class MealSet {
	private Integer id;
	private Integer dietId;
	private Integer mealId;

	@Id
	@GeneratedValue
	@Column(name = "id", unique = true, nullable = false)
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Column(name = "diet_id", nullable = false)
	public Integer getDietId() {
		return dietId;
	}

	public void setDietId(Integer dietId) {
		this.dietId = dietId;
	}

	@Column(name = "meal_id", nullable = false)
	public Integer getMealId() {
		return mealId;
	}

	public void setMealId(Integer mealId) {
		this.mealId = mealId;
	}

}
