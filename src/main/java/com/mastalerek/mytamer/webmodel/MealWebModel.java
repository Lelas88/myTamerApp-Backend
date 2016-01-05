package com.mastalerek.mytamer.webmodel;

import java.util.List;

public class MealWebModel {
	private Integer id;
	private String name;
	private String description;
	private String ingridients;
	private String preparing;
	private String iconName;
	private List<NutritionalWebModel> nutritionals;
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getIngridients() {
		return ingridients;
	}

	public void setIngridients(String ingridients) {
		this.ingridients = ingridients;
	}

	public String getPreparing() {
		return preparing;
	}

	public void setPreparing(String preparing) {
		this.preparing = preparing;
	}

	public String getIconName() {
		return iconName;
	}

	public void setIconName(String iconName) {
		this.iconName = iconName;
	}

	public List<NutritionalWebModel> getNutritionals() {
		return nutritionals;
	}

	public void setNutritionals(List<NutritionalWebModel> nutritionals) {
		this.nutritionals = nutritionals;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

}
