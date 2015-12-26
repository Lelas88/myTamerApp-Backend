package com.mastalerek.mytamer.functions;

import org.springframework.stereotype.Service;

import com.google.common.base.Function;
import com.mastalerek.mytamer.entity.Nutritional;
import com.mastalerek.mytamer.webmodel.NutritionalWebModel;

@Service
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
