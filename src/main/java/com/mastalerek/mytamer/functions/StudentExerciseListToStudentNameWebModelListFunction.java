package com.mastalerek.mytamer.functions;

import org.springframework.stereotype.Service;

import com.google.common.base.Function;
import com.mastalerek.mytamer.entity.StudentExercise;
import com.mastalerek.mytamer.webmodel.StudentNameWebModel;

@Service
public class StudentExerciseListToStudentNameWebModelListFunction
		implements Function<StudentExercise, StudentNameWebModel> {

	@Override
	public StudentNameWebModel apply(StudentExercise input) {
		StudentNameWebModel output = new StudentNameWebModel();
		output.setId(input.getStudent().getId());
		output.setFirstName(input.getStudent().getFirstName());
		output.setLastName(input.getStudent().getLastName());
		return output;
	}

}
