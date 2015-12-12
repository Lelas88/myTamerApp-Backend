package com.mastalerek.mytamer.webapi.impl;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Component;

import com.mastalerek.mytamer.service.TrainingPlanService;
import com.mastalerek.mytamer.webapi.TrainingPlanWebApi;
import com.mastalerek.mytamer.webmodel.TrainingPlanBasicWebModel;
import com.mastalerek.mytamer.webmodel.TrainingPlanWebModel;

@Component
public class TrainingPlanWebApiImpl implements TrainingPlanWebApi{

	@Inject
	private TrainingPlanService trainingPlanService;
	
	@Override
	public List<TrainingPlanBasicWebModel> getTrainingPlanBasics(Integer studentId) {
		return trainingPlanService.getTrainingPlanNames(studentId);
	}

	@Override
	public TrainingPlanWebModel getTrainingPlan(Integer trainingPlanId) {
		return trainingPlanService.getTrainingPlanDetails(trainingPlanId);
	}

}
