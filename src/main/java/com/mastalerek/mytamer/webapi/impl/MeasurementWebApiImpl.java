package com.mastalerek.mytamer.webapi.impl;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.core.Response;

import org.springframework.stereotype.Component;

import com.mastalerek.mytamer.service.MeasurementService;
import com.mastalerek.mytamer.webapi.MeasurementWebApi;
import com.mastalerek.mytamer.webmodel.AllMeasurementsWebModel;
import com.mastalerek.mytamer.webmodel.MeasurementWebModel;
import com.mastalerek.mytamer.webmodel.StudentMeasurementWebModel;

@Component
public class MeasurementWebApiImpl implements MeasurementWebApi {

	@Inject
	private MeasurementService measurementService;

	@Override
	public List<MeasurementWebModel> getAllMeasurements() {
		return measurementService.getAllMeasurements();
	}

	@Override
	public Double getLastMeasurementByTypeAndStudentId(Integer studentId, Integer measurementType) {
		return measurementService.getLastStudentMeasurementByStudentIdAndType(studentId, measurementType);
	}

	@Override
	public AllMeasurementsWebModel getMeasurementsHistory(Integer studentId) {
		return measurementService.getMeasurementsHistory(studentId);
	}

	@Override
	public Response createMeasurement(StudentMeasurementWebModel measurement) {
		measurementService.createMeasurement(measurement);
		return Response.ok().build();
	}

}
