package com.mastalerek.mytamer.webapi.impl;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Component;

import com.mastalerek.mytamer.service.MealSetService;
import com.mastalerek.mytamer.webapi.MealSetWebApi;
import com.mastalerek.mytamer.webmodel.MealSetWebModel;

@Component
public class MealSetWebApiImpl implements MealSetWebApi {
	
	@Inject
	private MealSetService mealSetService;

	@Override
	public MealSetWebModel getMealSetDetails(Integer mealSetId) {
		return mealSetService.getMealSetDetails(mealSetId);
	}

	@Override
	public List<MealSetWebModel> getMealSetsList(Integer userId) {
		return mealSetService.getMealSetsList(userId);
	}

}
