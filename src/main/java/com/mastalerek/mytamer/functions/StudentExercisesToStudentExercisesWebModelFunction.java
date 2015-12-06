package com.mastalerek.mytamer.functions;

import java.util.List;

import org.springframework.stereotype.Service;

import com.google.common.base.Function;
import com.google.common.collect.Lists;
import com.mastalerek.mytamer.entity.StudentExercise;
import com.mastalerek.mytamer.webmodel.StudentExerciseWebModel;

@Service
public class StudentExercisesToStudentExercisesWebModelFunction implements Function<List<StudentExercise>, List<StudentExerciseWebModel>> {

	@Override
	public List<StudentExerciseWebModel> apply(List<StudentExercise> input) {
		List<StudentExerciseWebModel> output = Lists.newArrayList();
		for(StudentExercise studentExercise : input) {
			StudentExerciseWebModel studentExerciseWebModel = new StudentExerciseWebModel();
			studentExerciseWebModel.setId(studentExercise.getExercise().getId());
			studentExerciseWebModel.setName(studentExercise.getExercise().getName());
			output.add(studentExerciseWebModel);
		}
		return output;
	}

}
