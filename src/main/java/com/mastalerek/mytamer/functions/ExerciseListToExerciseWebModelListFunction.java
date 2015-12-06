package com.mastalerek.mytamer.functions;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.google.common.base.Function;
import com.mastalerek.mytamer.entity.Exercise;
import com.mastalerek.mytamer.webmodel.ExerciseWebModel;

import jersey.repackaged.com.google.common.collect.Lists;

@Service
public class ExerciseListToExerciseWebModelListFunction implements Function<List<Exercise>, List<ExerciseWebModel>> {

	@Inject
	private StudentExerciseListToStudentNameWebModelListFunction function;

	@Override
	public List<ExerciseWebModel> apply(List<Exercise> input) {
		List<ExerciseWebModel> output = Lists.newArrayList();
		for (Exercise exercise : input) {
			ExerciseWebModel exerciseModel = new ExerciseWebModel();
			exerciseModel.setId(exercise.getId());
			exerciseModel.setName(exercise.getName());
			exerciseModel.setDescritpion(exercise.getDescription());
			exerciseModel.setDisciplineId(exercise.getDiscipline().getId());
			exerciseModel.setUnitId(exercise.getUnit().getId());
			if (exercise.getSecondUnit() != null) {
				exerciseModel.setSecondUnitId(exercise.getSecondUnit().getId());
			}
			exerciseModel.setIconName(exercise.getIconName());
			exerciseModel.setStudentNames(function.apply(exercise.getStudentExercises()));
			output.add(exerciseModel);
		}
		return output;
	}

}
