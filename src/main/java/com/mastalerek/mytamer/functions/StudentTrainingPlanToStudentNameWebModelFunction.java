package com.mastalerek.mytamer.functions;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.google.common.base.Function;
import com.mastalerek.mytamer.entity.Student;
import com.mastalerek.mytamer.entity.StudentTrainingPlan;
import com.mastalerek.mytamer.repository.StudentRepository;
import com.mastalerek.mytamer.webmodel.StudentNameWebModel;

@Service
public class StudentTrainingPlanToStudentNameWebModelFunction implements Function<StudentTrainingPlan, StudentNameWebModel>{

	@Inject 
	private StudentRepository studentRepository;
	
	@Override
	public StudentNameWebModel apply(StudentTrainingPlan input) {
		StudentNameWebModel output = new StudentNameWebModel();
		Student student = studentRepository.findOne(input.getStudentId());
		output.setId(student.getId());
		output.setFirstName(student.getFirstName());
		output.setLastName(student.getLastName());
		return output;
	}

}
