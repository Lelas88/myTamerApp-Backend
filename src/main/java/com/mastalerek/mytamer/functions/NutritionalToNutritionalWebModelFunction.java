package com.mastalerek.mytamer.functions;

import com.google.common.base.Function;
import com.mastalerek.mytamer.entity.Nutritional;
import com.mastalerek.mytamer.webmodel.NutritionalWebModel;

public class NutritionalToNutritionalWebModelFunction implements Function<Nutritional, NutritionalWebModel> {

	@Override
	public NutritionalWebModel apply(Nutritional input) {
		NutritionalWebModel output = new NutritionalWebModel();
		output.setId(input.getId());
		output.setName(input.getName());
		output.setUnit(input.getUnit());
		return output;
	}

}
