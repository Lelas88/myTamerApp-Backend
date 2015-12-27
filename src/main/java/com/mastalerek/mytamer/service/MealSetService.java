package com.mastalerek.mytamer.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Component;

import com.mastalerek.mytamer.entity.MealSet;
import com.mastalerek.mytamer.functions.MealSetEntityToMealSetWebModelFunction;
import com.mastalerek.mytamer.repository.MealSetRepository;
import com.mastalerek.mytamer.webmodel.MealSetWebModel;

import jersey.repackaged.com.google.common.collect.Lists;

@Component
public class MealSetService {

	@Inject
	private MealSetRepository mealSetRepository;
	@Inject
	private MealSetEntityToMealSetWebModelFunction mealSetEntityToMealSetWebModelFunction;

	public MealSetWebModel getMealSetDetails(Integer mealSetId) {
		return mealSetEntityToMealSetWebModelFunction.apply(mealSetRepository.findOne(mealSetId));
	}

	public List<MealSetWebModel> getMealSetsList(Integer userId) {
		List<MealSetWebModel> result = Lists.newArrayList();
		List<MealSet> mealSets = mealSetRepository.findByUserId(userId);
		for (MealSet mealSet : mealSets) {
			MealSetWebModel mealSetWebModel = mealSetEntityToMealSetWebModelFunction.apply(mealSet);
			result.add(mealSetWebModel);
		}
		return result;
	}
}
