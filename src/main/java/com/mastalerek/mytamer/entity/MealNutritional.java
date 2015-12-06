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
@Table(name = "meal_nutritionals")
public class MealNutritional {
	private Integer id;
	private Integer mealId;
	private Nutritional nutritional;
	private Double value;

	@Id
	@GeneratedValue
	@Column(name = "id", unique = true, nullable = false)
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Column(name = "meal_id", nullable = false)
	public Integer getMealId() {
		return mealId;
	}

	public void setMealId(Integer mealId) {
		this.mealId = mealId;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "nutritional_id", nullable = false)
	public Nutritional getNutritional() {
		return nutritional;
	}

	public void setNutritional(Nutritional nutritional) {
		this.nutritional = nutritional;
	}

	@Column(name = "value", nullable = false)
	public Double getValue() {
		return value;
	}

	public void setValue(Double value) {
		this.value = value;
	}

}
