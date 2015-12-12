package com.mastalerek.mytamer.functions;

import org.springframework.stereotype.Service;

import com.google.common.base.Function;
import com.mastalerek.mytamer.entity.Diet;
import com.mastalerek.mytamer.entity.TrainingPlanDiet;
import com.mastalerek.mytamer.webmodel.DietBasicWebModel;

@Service
public class DietToDietBasicWebModelFunction implements Function<TrainingPlanDiet, DietBasicWebModel> {

	@Override
	public DietBasicWebModel apply(TrainingPlanDiet input) {
		DietBasicWebModel output = new DietBasicWebModel();
		Diet diet = input.getDiet();
		output.setId(diet.getId());
		output.setName(diet.getName());
		return output;
	}

}
