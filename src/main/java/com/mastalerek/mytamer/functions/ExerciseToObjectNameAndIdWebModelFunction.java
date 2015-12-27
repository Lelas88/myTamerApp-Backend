package com.mastalerek.mytamer.functions;

import org.springframework.stereotype.Service;

import com.google.common.base.Function;
import com.mastalerek.mytamer.entity.Exercise;
import com.mastalerek.mytamer.entity.ExerciseSetExercises;
import com.mastalerek.mytamer.webmodel.ObjectNameAndIdWebModel;

@Service
public class ExerciseToObjectNameAndIdWebModelFunction implements Function<ExerciseSetExercises, ObjectNameAndIdWebModel> {

	@Override
	public ObjectNameAndIdWebModel apply(ExerciseSetExercises input) {
		Exercise exercise = input.getExercise();
		ObjectNameAndIdWebModel output = new ObjectNameAndIdWebModel();
		output.setId(exercise.getId());
		output.setName(exercise.getName());
		return output;
	}

}
