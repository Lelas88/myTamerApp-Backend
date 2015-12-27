package com.mastalerek.mytamer.functions;

import org.springframework.stereotype.Service;

import com.google.common.base.Function;
import com.mastalerek.mytamer.entity.MealSet;
import com.mastalerek.mytamer.webmodel.ObjectNameAndIdWebModel;

@Service
public class DietMealSetToObjectNameAndIdWebModelFunction implements Function<MealSet, ObjectNameAndIdWebModel> {

	@Override
	public ObjectNameAndIdWebModel apply(MealSet input) {
		ObjectNameAndIdWebModel output = new ObjectNameAndIdWebModel();
		output.setId(input.getId());
		output.setName(input.getName());
		return output;
	}

}
