package com.mastalerek.mytamer.functions;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.google.common.base.Function;
import com.google.common.collect.Lists;
import com.mastalerek.mytamer.entity.Discipline;
import com.mastalerek.mytamer.entity.Exercise;
import com.mastalerek.mytamer.entity.ExerciseUnit;
import com.mastalerek.mytamer.repository.DisciplineRepository;
import com.mastalerek.mytamer.repository.ExerciseUnitRepository;
import com.mastalerek.mytamer.webmodel.ExerciseWebModel;

@Service
public class ExerciseToExerciseWebModelFunction implements Function<Exercise, ExerciseWebModel> {

	@Inject
	private StudentExerciseListToStudentNameWebModelListFunction function;
	@Inject
	private DisciplineRepository disciplineRepository;
	@Inject
	private ExerciseUnitRepository exerciseUnitRepository;

	@Override
	public ExerciseWebModel apply(Exercise input) {
		ExerciseWebModel output = new ExerciseWebModel();
		output.setId(input.getId());
		output.setName(input.getName());
		output.setDescription(input.getDescription());
		setDiscipline(output, input.getDiscipline().getId());
		setUnits(output, input.getUnit(), input.getSecondUnit());
		output.setIconName(input.getIconName());
		output.setStudentNames(Lists.transform(input.getStudentExercises(), function));
		output.setTrainerId(input.getUser().getId());
		return output;
	}

	private void setDiscipline(ExerciseWebModel output, Integer disciplineId) {
		Discipline discipline = disciplineRepository.findOne(disciplineId);
		output.setDisciplineName(discipline.getName());		
		output.setDisciplineId(discipline.getId());
	}

	private void setUnits(ExerciseWebModel output, ExerciseUnit unit, ExerciseUnit secondUnit) {
		ExerciseUnit firstExerciseUnit = exerciseUnitRepository.findOne(unit.getId());
		output.setUnitName(firstExerciseUnit.getUnit());
		output.setUnitId(firstExerciseUnit.getId());
		if (secondUnit != null) {
			ExerciseUnit secondExerciseUnit = exerciseUnitRepository.findOne(secondUnit.getId());
			output.setSecondUnitName(secondExerciseUnit.getUnit());
			output.setSecondUnitId(secondExerciseUnit.getId());
		}
	}

}
