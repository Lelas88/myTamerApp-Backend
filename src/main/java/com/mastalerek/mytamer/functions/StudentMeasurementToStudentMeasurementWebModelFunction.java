package com.mastalerek.mytamer.functions;

import org.springframework.stereotype.Service;

import com.google.common.base.Function;
import com.mastalerek.mytamer.entity.StudentMeasurement;
import com.mastalerek.mytamer.webmodel.StudentMeasurementWebModel;

@Service
public class StudentMeasurementToStudentMeasurementWebModelFunction
		implements Function<StudentMeasurement, StudentMeasurementWebModel> {

	@Override
	public StudentMeasurementWebModel apply(StudentMeasurement input) {
		StudentMeasurementWebModel output = new StudentMeasurementWebModel();
		output.setId(input.getId());
		output.setStudentId(input.getStudent().getId());
		output.setMeasurementId(input.getMeasurement().getId());
		output.setUnit(input.getMeasurement().getUnit());
		output.setValue(input.getValue());
		output.setDate(input.getDate().toString());
		return output;
	}
}
