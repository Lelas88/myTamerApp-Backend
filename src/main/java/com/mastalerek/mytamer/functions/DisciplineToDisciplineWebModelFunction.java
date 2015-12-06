package com.mastalerek.mytamer.functions;

import java.util.List;

import org.springframework.stereotype.Service;

import com.google.common.base.Function;
import com.mastalerek.mytamer.entity.Discipline;
import com.mastalerek.mytamer.webmodel.DisciplineWebModel;

import jersey.repackaged.com.google.common.collect.Lists;

@Service
public class DisciplineToDisciplineWebModelFunction implements Function<List<Discipline>, List<DisciplineWebModel>> {

	@Override
	public List<DisciplineWebModel> apply(List<Discipline> input) {
		List<DisciplineWebModel> output = Lists.newArrayList();
		for (Discipline discipline : input) {
			DisciplineWebModel disciplineModel = new DisciplineWebModel();
			disciplineModel.setId(discipline.getId());
			disciplineModel.setName(discipline.getName());
			disciplineModel.setDescription(discipline.getDescription());
			disciplineModel.setIconName(discipline.getIconName());
			output.add(disciplineModel);
		}
		return output;
	}

}
