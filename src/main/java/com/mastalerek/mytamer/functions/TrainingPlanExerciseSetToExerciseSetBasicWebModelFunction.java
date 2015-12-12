package com.mastalerek.mytamer.functions;

import org.springframework.stereotype.Service;

import com.google.common.base.Function;
import com.mastalerek.mytamer.entity.ExerciseSet;
import com.mastalerek.mytamer.entity.TrainingPlanExerciseSet;
import com.mastalerek.mytamer.webmodel.ExerciseSetBasicWebModel;

@Service
public class TrainingPlanExerciseSetToExerciseSetBasicWebModelFunction implements Function<TrainingPlanExerciseSet, ExerciseSetBasicWebModel>{

	@Override
	public ExerciseSetBasicWebModel apply(TrainingPlanExerciseSet input) {
		ExerciseSetBasicWebModel output = new ExerciseSetBasicWebModel();
		ExerciseSet exerciseSet = input.getExerciseSet();
		output.setId(exerciseSet.getId());
		output.setName(exerciseSet.getName());
		return output;
	}

}
