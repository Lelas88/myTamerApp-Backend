package com.mastalerek.mytamer.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Component;

import com.mastalerek.mytamer.entity.Measurement;
import com.mastalerek.mytamer.entity.Student;
import com.mastalerek.mytamer.entity.StudentMeasurement;
import com.mastalerek.mytamer.functions.MeasurementToMeasurementWebModelFunction;
import com.mastalerek.mytamer.repository.MeasurementRepository;
import com.mastalerek.mytamer.repository.StudentMeasurementRepository;
import com.mastalerek.mytamer.repository.StudentRepository;
import com.mastalerek.mytamer.webmodel.AllMeasurementsWebModel;
import com.mastalerek.mytamer.webmodel.MeasurementEntryWebModel;
import com.mastalerek.mytamer.webmodel.MeasurementWebModel;
import com.mastalerek.mytamer.webmodel.StudentMeasurementWebModel;

import jersey.repackaged.com.google.common.collect.Lists;

@Component
public class MeasurementService {

	private static final double INITIAL_VALUE = 0.0;
	private static final String HEIGHT = "height";
	private static final String WEIGHT = "weight";
	@Inject
	private MeasurementRepository measurementRepository;
	@Inject
	private MeasurementToMeasurementWebModelFunction measurementToMeasurementWebModelFunction;
	@Inject
	private StudentMeasurementRepository studentMeasurementRepository;
	@Inject
	private StudentRepository studentRepository;
	@Inject
	private DateService dateService;

	public List<MeasurementWebModel> getAllMeasurements() {
		List<Measurement> measurements = (List<Measurement>) measurementRepository.findAll();
		return measurementToMeasurementWebModelFunction.apply(measurements);
	}

	public Double getLastStudentMeasurementByStudentIdAndType(Integer studentId, Integer measurementType) {
		StudentMeasurement studentMeasurement = studentMeasurementRepository
				.findTop1ByStudentIdAndMeasurementIdOrderByDateDesc(studentId, measurementType);
		if(studentMeasurement != null) {
			return studentMeasurement.getValue();
		} else {
			return INITIAL_VALUE;
		}
	}

	public AllMeasurementsWebModel getMeasurementsHistory(Integer studentId) {
		List<StudentMeasurement> studentMeasurements = studentMeasurementRepository
				.findByStudentIdOrderByDateAsc(studentId);
		AllMeasurementsWebModel output = new AllMeasurementsWebModel();
		List<MeasurementEntryWebModel> weights = Lists.newArrayList();
		List<MeasurementEntryWebModel> heights = Lists.newArrayList();

		for (StudentMeasurement studentMeasurement : studentMeasurements) {
			if (WEIGHT.equals(studentMeasurement.getMeasurement().getName())) {
				weights.add(createMeasurementEntry(studentMeasurement));
			} else if (HEIGHT.equals(studentMeasurement.getMeasurement().getName())) {
				heights.add(createMeasurementEntry(studentMeasurement));
			}
		}
		output.setHeights(heights);
		output.setWeights(weights);
		return output;
	}

	private MeasurementEntryWebModel createMeasurementEntry(StudentMeasurement studentMeasurement) {
		MeasurementEntryWebModel measurement = new MeasurementEntryWebModel();
		measurement.setUnit(studentMeasurement.getMeasurement().getUnit());
		measurement.setDate(studentMeasurement.getDate().toString());
		measurement.setValue(studentMeasurement.getValue());
		return measurement;
	}

	public void createMeasurement(StudentMeasurementWebModel input) {
		Student student = studentRepository.findOne(input.getStudentId());
		Measurement measurement = measurementRepository.findOne(input.getMeasurementId());
		StudentMeasurement studentMeasurement = new StudentMeasurement();
		studentMeasurement.setStudent(student);
		studentMeasurement.setMeasurement(measurement);
		studentMeasurement.setValue(input.getValue());
		studentMeasurement.setDate(dateService.getCurrentDate());
		studentMeasurementRepository.save(studentMeasurement);
	}

}
