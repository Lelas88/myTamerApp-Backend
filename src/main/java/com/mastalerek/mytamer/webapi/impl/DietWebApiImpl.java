package com.mastalerek.mytamer.webapi.impl;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Component;

import com.mastalerek.mytamer.service.DietService;
import com.mastalerek.mytamer.webapi.DietWebApi;
import com.mastalerek.mytamer.webmodel.DietWebModel;

@Component
public class DietWebApiImpl implements DietWebApi {

	@Inject
	private DietService dietService;
	
	@Override
	public DietWebModel getDietDetails(Integer dietId) {
		return dietService.getDietDetails(dietId);
	}

	@Override
	public List<DietWebModel> getUserDiets(Integer userId) {
		return dietService.getUserDiets(userId);
	}

}
