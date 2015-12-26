package com.mastalerek.mytamer.functions;

import org.springframework.stereotype.Service;

import com.google.common.base.Function;
import com.mastalerek.mytamer.entity.StudentExercise;
import com.mastalerek.mytamer.webmodel.StudentExerciseWebModel;

@Service
public class StudentExercisesToStudentExercisesWebModelFunction
		implements Function<StudentExercise, StudentExerciseWebModel> {

	public StudentExerciseWebModel apply(StudentExercise input) {
		StudentExerciseWebModel output = new StudentExerciseWebModel();
		output.setId(input.getExercise().getId());
		output.setName(input.getExercise().getName());
		return output;
	}

}
