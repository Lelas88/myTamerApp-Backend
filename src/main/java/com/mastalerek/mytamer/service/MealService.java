package com.mastalerek.mytamer.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Component;

import com.google.common.collect.Lists;
import com.mastalerek.mytamer.entity.Meal;
import com.mastalerek.mytamer.entity.MealNutritional;
import com.mastalerek.mytamer.entity.Nutritional;
import com.mastalerek.mytamer.functions.MealNutritionToNutritionWebModelFunction;
import com.mastalerek.mytamer.functions.MealToMealWebModelFunction;
import com.mastalerek.mytamer.functions.NutritionEntityToNutritionWebModelFunction;
import com.mastalerek.mytamer.repository.MealNutritionalRepository;
import com.mastalerek.mytamer.repository.MealRepository;
import com.mastalerek.mytamer.repository.NutritionalRepository;
import com.mastalerek.mytamer.repository.UserRepository;
import com.mastalerek.mytamer.webmodel.MealWebModel;
import com.mastalerek.mytamer.webmodel.NutritionWebModel;

@Component
public class MealService {

	@Inject
	private UserRepository userRepository;
	@Inject
	private MealRepository mealRepository;
	@Inject
	private MealNutritionalRepository mealNutritionsRepository;
	@Inject
	private NutritionalRepository nutritionsRepository;
	@Inject
	private MealToMealWebModelFunction mealToMealWebModelFunction;
	@Inject
	private NutritionEntityToNutritionWebModelFunction nutritionEntityToNutritionWebModelFunction;
	@Inject
	private MealNutritionToNutritionWebModelFunction mealNutritionToNutritionWebModelFunction;

	public List<MealWebModel> getUserMeals(Integer userId) {
		List<Meal> meals = mealRepository.findByUserId(userId);
		return Lists.transform(meals, mealToMealWebModelFunction);
	}

	public MealWebModel getMealDetails(Integer mealId) {
		return mealToMealWebModelFunction.apply(mealRepository.findOne(mealId));
	}

	public Integer createMeal(MealWebModel mealWebModel) {
		Meal meal = new Meal();
		meal.setName(mealWebModel.getName());
		meal.setDescription(mealWebModel.getDescription());
		meal.setIngridients(mealWebModel.getIngridients());
		meal.setPreparing(mealWebModel.getPreparing());
		meal.setUser(userRepository.findOne(mealWebModel.getUserId()));
		meal.setName(mealWebModel.getName());
		meal.setIconName(mealWebModel.getIconName());
		Meal savedMeal = mealRepository.save(meal);
		return savedMeal.getId();
	}

	public void saveNutritions(Integer mealId, NutritionWebModel nutritions) {
		MealNutritional mealNutritional = mealNutritionsRepository.findByMealIdAndNutritionalId(mealId,
				nutritions.getId());
		if (mealNutritional == null) {
			mealNutritional = new MealNutritional();
		}
		mealNutritional.setMealId(mealId);
		mealNutritional.setNutritional(nutritionsRepository.findOne(nutritions.getId()));
		mealNutritional.setValue(nutritions.getValue());
		mealNutritionsRepository.save(mealNutritional);
	}

	public List<NutritionWebModel> getNutritions() {
		List<Nutritional> nutritions = (List<Nutritional>) nutritionsRepository.findAll();
		return Lists.transform(nutritions, nutritionEntityToNutritionWebModelFunction);
	}

	public void modifyMeal(MealWebModel mealWebModel) {
		Meal meal = mealRepository.findOne(mealWebModel.getId());
		meal.setName(mealWebModel.getName());
		meal.setDescription(mealWebModel.getDescription());
		meal.setIngridients(mealWebModel.getIngridients());
		meal.setPreparing(mealWebModel.getPreparing());
		meal.setName(mealWebModel.getName());
		meal.setIconName(mealWebModel.getIconName());
		meal.setUser(userRepository.findOne(mealWebModel.getUserId()));
		mealRepository.save(meal);
	}

	public void deleteMeal(Integer mealId) {
		Meal meal = mealRepository.findOne(mealId);
		mealRepository.delete(meal);
	}

	public List<NutritionWebModel> getMealNutritions(Integer mealId) {
		List<MealNutritional> mealNutritions = mealNutritionsRepository.findByMealId(mealId);
		return Lists.transform(mealNutritions, mealNutritionToNutritionWebModelFunction);
	}

}
