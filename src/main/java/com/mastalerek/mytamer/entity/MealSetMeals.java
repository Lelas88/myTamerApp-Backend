package com.mastalerek.mytamer.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "meal_set_meals")
public class MealSetMeals {
	private Integer id;
	private Meal meal;
	private MealSet mealset;

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
	@JoinColumn(name = "meal_id", nullable = false)
	public Meal getMeal() {
		return meal;
	}

	public void setMeal(Meal meal) {
		this.meal = meal;
	}

	@ManyToOne
	@JoinColumn(name = "meal_set_id", nullable = false)
	public MealSet getMealset() {
		return mealset;
	}

	public void setMealset(MealSet mealset) {
		this.mealset = mealset;
	}

}
