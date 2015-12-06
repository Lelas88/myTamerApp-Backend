package com.mastalerek.mytamer.functions;

import java.util.List;

import org.assertj.core.util.Lists;
import org.springframework.stereotype.Service;

import com.google.common.base.Function;
import com.mastalerek.mytamer.entity.Measurement;
import com.mastalerek.mytamer.webmodel.MeasurementWebModel;

@Service
public class MeasurementToMeasurementWebModelFunction implements Function<List<Measurement>, List<MeasurementWebModel>> {

	@Override
	public List<MeasurementWebModel> apply(List<Measurement> measurements) {
		MeasurementWebModel mesurementModel = new MeasurementWebModel();
		List<MeasurementWebModel> output = Lists.newArrayList();
		for (Measurement measurement : measurements) {
			mesurementModel.setId(measurement.getId());
			mesurementModel.setName(measurement.getName());
			mesurementModel.setUnit(measurement.getUnit());
			output.add(mesurementModel);
		}
		return output;
	}

}
