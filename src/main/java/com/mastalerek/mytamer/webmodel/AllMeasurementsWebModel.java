package com.mastalerek.mytamer.webmodel;

import java.util.List;

public class AllMeasurementsWebModel {
	private List<MeasurementEntryWebModel> weights;
	private List<MeasurementEntryWebModel> heights;

	public List<MeasurementEntryWebModel> getWeights() {
		return weights;
	}

	public void setWeights(List<MeasurementEntryWebModel> weights) {
		this.weights = weights;
	}

	public List<MeasurementEntryWebModel> getHeights() {
		return heights;
	}

	public void setHeights(List<MeasurementEntryWebModel> heights) {
		this.heights = heights;
	}

}
