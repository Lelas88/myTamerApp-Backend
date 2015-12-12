package com.mastalerek.mytamer.functions;

import org.springframework.stereotype.Service;

import com.google.common.base.Function;
import com.mastalerek.mytamer.entity.ExerciseSet;
import com.mastalerek.mytamer.webmodel.ExerciseSetBasicWebModel;

@Service
public class ExerciseSetToExerciseSetBasicWebModelFunction implements Function<ExerciseSet, ExerciseSetBasicWebModel>{

	@Override
	public ExerciseSetBasicWebModel apply(ExerciseSet input) {
		ExerciseSetBasicWebModel output = new ExerciseSetBasicWebModel();
		output.setId(input.getId());
		output.setName(input.getName());
		return output;
	}

}
