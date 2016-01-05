package com.mastalerek.mytamer.functions;

import org.springframework.stereotype.Service;

import com.google.common.base.Function;
import com.mastalerek.mytamer.entity.Nutritional;
import com.mastalerek.mytamer.webmodel.NutritionWebModel;

@Service
public class NutritionEntityToNutritionWebModelFunction implements Function<Nutritional, NutritionWebModel> {

	@Override
	public NutritionWebModel apply(Nutritional input) {
		NutritionWebModel output = new NutritionWebModel();
		output.setId(input.getId());
		output.setName(input.getName());
		output.setUnit(input.getUnit());
		return output;
	}
}
