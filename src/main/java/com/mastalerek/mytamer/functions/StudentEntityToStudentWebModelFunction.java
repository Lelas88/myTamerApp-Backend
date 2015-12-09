package com.mastalerek.mytamer.functions;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.google.common.base.Function;
import com.mastalerek.mytamer.entity.Student;
import com.mastalerek.mytamer.enums.MeasurementType;
import com.mastalerek.mytamer.service.BmiService;
import com.mastalerek.mytamer.service.MeasurementService;
import com.mastalerek.mytamer.service.StudentService;
import com.mastalerek.mytamer.webmodel.StudentWebModel;

@Service
public class StudentEntityToStudentWebModelFunction implements Function<Student, StudentWebModel> {
	
	@Inject
	private BmiService bmiService;	
	@Inject
	private MeasurementService measurementService;	
	@Inject
	private StudentService studentService;
	
	@Override
	public StudentWebModel apply(Student input) {
		StudentWebModel output = new StudentWebModel();
		output.setId(input.getId());
		output.setFirstName(input.getFirstName());
		output.setLastName(input.getLastName());
		output.setGroupId(input.getGroup().getId());
		output.setRankId(input.getRank().getId());
		output.setBirthdate(input.getBirthdate().toString());
		output.setWeight(measurementService.getLastStudentMeasurementByStudentIdAndType(input.getId(), MeasurementType.WEIGHT.getValue()));
		output.setHeight(measurementService.getLastStudentMeasurementByStudentIdAndType(input.getId(), MeasurementType.HEIGHT.getValue()));
		output.setBmi(bmiService.calculateBmi(output.getWeight(), output.getHeight()));
		output.setPhotoName(input.getStudentPhoto().getPhotoName());
		output.setAge(studentService.calculateStudentAge(input.getBirthdate()));
		return output;
	}

}
