package com.mastalerek.mytamer.webmodel;

import java.util.List;

public class DietWebModel {
	private Integer id;
	private String name;
	private String description;
	private Boolean active;
	private List<ObjectNameAndIdWebModel> mealSets;
	private List<ObjectNameAndIdWebModel> trainingPlans;

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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Boolean getActive() {
		return active;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}

	public List<ObjectNameAndIdWebModel> getMealSets() {
		return mealSets;
	}

	public void setMealSets(List<ObjectNameAndIdWebModel> mealSets) {
		this.mealSets = mealSets;
	}

	public List<ObjectNameAndIdWebModel> getTrainingPlans() {
		return trainingPlans;
	}

	public void setTrainingPlans(List<ObjectNameAndIdWebModel> trainingPlans) {
		this.trainingPlans = trainingPlans;
	}

}
