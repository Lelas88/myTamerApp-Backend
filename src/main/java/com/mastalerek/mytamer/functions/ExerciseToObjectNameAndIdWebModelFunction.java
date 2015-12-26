package com.mastalerek.mytamer.functions;

import org.springframework.stereotype.Service;

import com.google.common.base.Function;
import com.mastalerek.mytamer.entity.Exercise;
import com.mastalerek.mytamer.webmodel.ObjectNameAndIdWebModel;

@Service
public class ExerciseToObjectNameAndIdWebModelFunction implements Function<Exercise, ObjectNameAndIdWebModel> {

	@Override
	public ObjectNameAndIdWebModel apply(Exercise input) {
		ObjectNameAndIdWebModel output = new ObjectNameAndIdWebModel();
		output.setId(input.getId());
		output.setName(input.getName());
		return output;
	}

}
