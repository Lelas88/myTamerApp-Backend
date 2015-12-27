package com.mastalerek.mytamer.functions;

import org.springframework.stereotype.Service;

import com.google.common.base.Function;
import com.mastalerek.mytamer.entity.Meal;
import com.mastalerek.mytamer.webmodel.ObjectNameAndIdWebModel;

@Service
public class MealToObjectNameAndIdFunction implements Function<Meal, ObjectNameAndIdWebModel>{

	@Override
	public ObjectNameAndIdWebModel apply(Meal input) {
		ObjectNameAndIdWebModel output = new ObjectNameAndIdWebModel();
		output.setId(input.getId());
		output.setName(input.getName());
		return output;
	}

}
