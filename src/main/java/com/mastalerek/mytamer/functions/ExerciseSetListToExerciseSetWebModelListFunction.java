package com.mastalerek.mytamer.functions;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.google.common.base.Function;
import com.google.common.collect.Lists;
import com.mastalerek.mytamer.entity.ExerciseSet;
import com.mastalerek.mytamer.webmodel.ExerciseSetWebModel;

@Service
public class ExerciseSetListToExerciseSetWebModelListFunction implements Function<List<ExerciseSet>, List<ExerciseSetWebModel>>{

	@Override
	public List<ExerciseSetWebModel> apply(List<ExerciseSet> input) {
		ArrayList<ExerciseSetWebModel> output = Lists.newArrayList();
//		for (ExerciseSet exerciseSet : input) {
//			ExerciseSetWebModel exerciseSetWebModel = new ExerciseSetWebModel();
//			exerciseSetWebModel.setId(exerciseSet.getId());
//			exerciseSetWebModel.setExerciseId(exerciseSet.getExerciseId());
//			exerciseSetWebModel.setTrainingPlanId(exerciseSet.getTrainingPlanId());
//			output.add(exerciseSetWebModel);
//		}
		return output;
	}

}
