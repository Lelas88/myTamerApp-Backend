package com.mastalerek.mytamer.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "diets")
public class Diet {
	private Integer id;
	private String name;
	private String description;
	private List<MealSet> mealSets;
	private Integer active;

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

	@OneToMany(fetch = FetchType.EAGER)
	@JoinColumn(name = "diet_id", nullable = true)
	public List<MealSet> getMealSets() {
		return mealSets;
	}

	public void setMealSets(List<MealSet> mealSets) {
		this.mealSets = mealSets;
	}

	@Column(name = "active", nullable = false)
	public Integer getActive() {
		return active;
	}

	public void setActive(Integer active) {
		this.active = active;
	}
}
