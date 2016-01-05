package com.mastalerek.mytamer.functions;

import org.springframework.stereotype.Service;

import com.google.common.base.Function;
import com.mastalerek.mytamer.entity.MealNutritional;
import com.mastalerek.mytamer.webmodel.NutritionWebModel;

@Service
public class MealNutritionToNutritionWebModelFunction implements Function<MealNutritional, NutritionWebModel>{

	@Override
	public NutritionWebModel apply(MealNutritional input) {
		NutritionWebModel output = new NutritionWebModel();
		output.setId(input.getId());
		output.setName(input.getNutritional().getName());
		output.setUnit(input.getNutritional().getUnit());
		output.setValue(input.getValue());
		return output;
	}

}
