package com.mastalerek.mytamer.functions;

import org.springframework.stereotype.Service;

import com.google.common.base.Function;
import com.mastalerek.mytamer.entity.TrainingPlan;
import com.mastalerek.mytamer.webmodel.ObjectNameAndIdWebModel;

@Service
public class TrainingPlanToObjectNameAndIdWebModelFunction implements Function<TrainingPlan, ObjectNameAndIdWebModel>{

	@Override
	public ObjectNameAndIdWebModel apply(TrainingPlan input) {
		ObjectNameAndIdWebModel output = new ObjectNameAndIdWebModel();
		output.setId(input.getId());
		output.setName(input.getName());
		return output;
	}

}
