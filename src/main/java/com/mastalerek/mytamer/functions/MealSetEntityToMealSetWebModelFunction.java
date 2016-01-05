package com.mastalerek.mytamer.functions;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.google.common.base.Function;
import com.mastalerek.mytamer.entity.Meal;
import com.mastalerek.mytamer.entity.MealSet;
import com.mastalerek.mytamer.entity.MealSetMeals;
import com.mastalerek.mytamer.webmodel.MealSetWebModel;
import com.mastalerek.mytamer.webmodel.ObjectNameAndIdWebModel;

import jersey.repackaged.com.google.common.collect.Lists;

@Service
public class MealSetEntityToMealSetWebModelFunction implements Function<MealSet, MealSetWebModel> {

	@Inject
	private MealToObjectNameAndIdFunction mealToObjectNameAndIdFunction;

	@Override
	public MealSetWebModel apply(MealSet input) {
		MealSetWebModel output = new MealSetWebModel();
		output.setId(input.getId());
		output.setName(input.getName());
		output.setUserId(input.getUser().getId());
		setMeals(input, output);
		return output;
	}

	private void setMeals(MealSet input, MealSetWebModel output) {
		List<MealSetMeals> mealSetMeals = input.getMeals();
		List<ObjectNameAndIdWebModel> meals = Lists.newArrayList();
		for (MealSetMeals mealSetMeal : mealSetMeals) {
			Meal meal = mealSetMeal.getMeal();
			meals.add(mealToObjectNameAndIdFunction.apply(meal));
		}
		output.setMeals(meals);
	}
}
