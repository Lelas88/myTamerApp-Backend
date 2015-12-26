package com.mastalerek.mytamer.functions;

import org.springframework.stereotype.Service;

import com.google.common.base.Function;
import com.mastalerek.mytamer.entity.StudentTrainingPlan;
import com.mastalerek.mytamer.webmodel.StudentNameWebModel;

@Service
public class StudentTrainingPlanToStudentNameWebModelFunction implements Function<StudentTrainingPlan, StudentNameWebModel>{

	@Override
	public StudentNameWebModel apply(StudentTrainingPlan input) {
		StudentNameWebModel output = new StudentNameWebModel();
		output.setId(input.getStudent().getId());
		output.setFirstName(input.getStudent().getFirstName());
		output.setLastName(input.getStudent().getLastName());
		return output;
	}

}
