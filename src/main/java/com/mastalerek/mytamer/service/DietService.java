package com.mastalerek.mytamer.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Component;

import com.google.common.collect.Lists;
import com.mastalerek.mytamer.entity.Diet;
import com.mastalerek.mytamer.functions.DietEntityToDietWebModelFunction;
import com.mastalerek.mytamer.repository.DietRepository;
import com.mastalerek.mytamer.webmodel.DietWebModel;

@Component
public class DietService {

	@Inject
	private DietRepository dietRepository;
	@Inject
	private DietEntityToDietWebModelFunction dietEntityToDietWebModelFunction;
	
	public DietWebModel getDietDetails(Integer dietId) {
		return dietEntityToDietWebModelFunction.apply(dietRepository.findOne(dietId));
	}

	public List<DietWebModel> getUserDiets(Integer userId) {
		List<Diet> diets = dietRepository.findByUserId(userId);
		return Lists.transform(diets, dietEntityToDietWebModelFunction);
	}
}
