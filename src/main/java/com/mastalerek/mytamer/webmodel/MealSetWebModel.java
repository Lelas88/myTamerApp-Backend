package com.mastalerek.mytamer.webmodel;

import java.util.List;

public class MealSetWebModel {
	private Integer id;
	private String name;
	private List<ObjectNameAndIdWebModel> meals;
	private Integer userId;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<ObjectNameAndIdWebModel> getMeals() {
		return meals;
	}

	public void setMeals(List<ObjectNameAndIdWebModel> meals) {
		this.meals = meals;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

}
