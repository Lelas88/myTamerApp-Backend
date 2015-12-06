package com.mastalerek.mytamer.functions;

import java.util.List;

import org.springframework.stereotype.Service;

import com.google.common.base.Function;
import com.mastalerek.mytamer.entity.StudentExercise;
import com.mastalerek.mytamer.webmodel.StudentNameWebModel;

import jersey.repackaged.com.google.common.collect.Lists;

@Service
public class StudentExerciseListToStudentNameWebModelListFunction
		implements Function<List<StudentExercise>, List<StudentNameWebModel>> {

	@Override
	public List<StudentNameWebModel> apply(List<StudentExercise> input) {
		List<StudentNameWebModel> studentNameWebModels = Lists.newArrayList();
		for (StudentExercise studentExercise : input) {
			StudentNameWebModel studentNameWebModel = new StudentNameWebModel();
			studentNameWebModel.setId(studentExercise.getStudent().getId());
			studentNameWebModel.setFirstName(studentExercise.getStudent().getFirstName());
			studentNameWebModel.setLastName(studentExercise.getStudent().getLastName());
			studentNameWebModels.add(studentNameWebModel);
		}
		return studentNameWebModels;
	}

}
