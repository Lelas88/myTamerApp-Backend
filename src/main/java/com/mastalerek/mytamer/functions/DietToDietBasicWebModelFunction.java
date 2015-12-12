package com.mastalerek.mytamer.functions;

import org.springframework.stereotype.Service;

import com.google.common.base.Function;
import com.mastalerek.mytamer.entity.Diet;
import com.mastalerek.mytamer.webmodel.DietBasicWebModel;

@Service
public class DietToDietBasicWebModelFunction implements Function<Diet, DietBasicWebModel>{

	@Override
	public DietBasicWebModel apply(Diet input) {
		DietBasicWebModel output = new DietBasicWebModel();
		output.setId(input.getId());
		output.setName(input.getName());
		return output;
	}

}
