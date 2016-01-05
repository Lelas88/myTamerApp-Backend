package com.mastalerek.mytamer.functions;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.google.common.base.Function;
import com.mastalerek.mytamer.entity.Meal;
import com.mastalerek.mytamer.entity.MealNutritional;
import com.mastalerek.mytamer.entity.Nutritional;
import com.mastalerek.mytamer.repository.MealNutritionalRepository;
import com.mastalerek.mytamer.webmodel.MealWebModel;
import com.mastalerek.mytamer.webmodel.NutritionalWebModel;

import jersey.repackaged.com.google.common.collect.Lists;

@Service
public class MealToMealWebModelFunction implements Function<Meal, MealWebModel> {

	@Inject
	private MealNutritionalRepository mealNutritionalRepository;
	@Inject
	private NutritionalToNutritionalWebModelFunction nutritionalToNutritionalWebModelFunction;

	@Override
	public MealWebModel apply(Meal input) {
		MealWebModel output = new MealWebModel();
		output.setId(input.getId());
		output.setName(input.getName());
		output.setDescription(input.getDescription());
		output.setIngridients(input.getIngridients());
		output.setPreparing(input.getPreparing());
		output.setIconName(input.getIconName());
		output.setUserId(input.getUser().getId());
		setNutritionals(input, output);
		return output;
	}

	private void setNutritionals(Meal input, MealWebModel output) {
		List<MealNutritional> mealNutritionals = mealNutritionalRepository.findByMealId(input.getId());
		List<NutritionalWebModel> nutritionals = Lists.newArrayList();
		for (MealNutritional mealNutritional : mealNutritionals) {
			Nutritional nutritional = mealNutritional.getNutritional();
			nutritionals.add(nutritionalToNutritionalWebModelFunction.apply(nutritional));
		}
		output.setNutritionals(nutritionals);
	}

}
