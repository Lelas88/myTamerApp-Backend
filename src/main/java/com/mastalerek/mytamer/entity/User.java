package com.mastalerek.mytamer.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import com.sun.istack.internal.NotNull;

@Entity
@Table(name = "users")
public class User implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 6884868114899822596L;
	private Integer id;
	private String username;
	private String email;
	private String password;
	private List<Group> groups;
	private List<UserSetting> userSettings;
	private List<Diet> diets;
	private List<Meal> meals;
	private List<MealSet> mealSets;
	private List<Exercise> exercises;
	private List<ExerciseSet> exerciseSets;
	private List<TrainingPlan> trainingPlans;
	private Student student;

	@Id
	@GeneratedValue
	@Column(name = "id", unique = true, nullable = false)
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@NotNull
	@Column(name = "username", nullable = false)
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@NotNull
	@Column(name = "email", nullable = false)
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@NotNull
	@Column(name = "password", nullable = false)
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
	public List<Group> getGroups() {
		return groups;
	}

	public void setGroups(List<Group> groups) {
		this.groups = groups;
	}

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "user", cascade = CascadeType.ALL)
	public List<UserSetting> getUserSettings() {
		return userSettings;
	}

	public void setUserSettings(List<UserSetting> userSettings) {
		this.userSettings = userSettings;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "user", cascade = CascadeType.ALL)
	public List<Diet> getDiets() {
		return diets;
	}

	public void setDiets(List<Diet> diets) {
		this.diets = diets;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "user", cascade = CascadeType.ALL)
	public List<Meal> getMeals() {
		return meals;
	}

	public void setMeals(List<Meal> meals) {
		this.meals = meals;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "user", cascade = CascadeType.ALL)
	public List<MealSet> getMealSets() {
		return mealSets;
	}

	public void setMealSets(List<MealSet> mealSets) {
		this.mealSets = mealSets;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "user", cascade = CascadeType.ALL)
	public List<Exercise> getExercises() {
		return exercises;
	}

	public void setExercises(List<Exercise> exercises) {
		this.exercises = exercises;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "user", cascade = CascadeType.ALL)
	public List<ExerciseSet> getExerciseSets() {
		return exerciseSets;
	}

	public void setExerciseSets(List<ExerciseSet> exerciseSets) {
		this.exerciseSets = exerciseSets;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "user", cascade = CascadeType.ALL)
	public List<TrainingPlan> getTrainingPlans() {
		return trainingPlans;
	}

	public void setTrainingPlans(List<TrainingPlan> trainingPlans) {
		this.trainingPlans = trainingPlans;
	}

	@OneToOne(fetch = FetchType.LAZY)
	@PrimaryKeyJoinColumn
	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

}
