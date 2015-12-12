package com.mastalerek.mytamer.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "meals")
public class Meal {
	private Integer id;
	private String name;
	private String description;
	private String ingridients;
	private String preparing;
	private String iconName;
	private List<MealNutritional> mealNutritionals;

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

	@Lob
	@Column(name = "ingridients", nullable = false)
	public String getIngridients() {
		return ingridients;
	}

	public void setIngridients(String ingridients) {
		this.ingridients = ingridients;
	}

	@Lob
	@Column(name = "preparing", nullable = false)
	public String getPreparing() {
		return preparing;
	}

	public void setPreparing(String preparing) {
		this.preparing = preparing;
	}

	@Column(name = "icon_name", nullable = false)
	public String getIconName() {
		return iconName;
	}

	public void setIconName(String iconName) {
		this.iconName = iconName;
	}

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "mealId", cascade = CascadeType.ALL)
	public List<MealNutritional> getMealNutritionals() {
		return mealNutritionals;
	}

	public void setMealNutritionals(List<MealNutritional> mealNutritionals) {
		this.mealNutritionals = mealNutritionals;
	}

}
