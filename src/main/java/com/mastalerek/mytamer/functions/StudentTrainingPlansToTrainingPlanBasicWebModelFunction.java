package com.mastalerek.mytamer.functions;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.google.common.base.Function;
import com.mastalerek.mytamer.entity.StudentTrainingPlan;
import com.mastalerek.mytamer.repository.TrainingPlanRepository;
import com.mastalerek.mytamer.webmodel.TrainingPlanBasicWebModel;

@Service
public class StudentTrainingPlansToTrainingPlanBasicWebModelFunction implements Function<StudentTrainingPlan, TrainingPlanBasicWebModel> {

	@Inject
	private TrainingPlanRepository trainingPlanRepository;
	
	@Override
	public TrainingPlanBasicWebModel apply(StudentTrainingPlan input) {
		TrainingPlanBasicWebModel output = new TrainingPlanBasicWebModel();
		output.setId(input.getTrainingPlanId());
		output.setName(trainingPlanRepository.findOne(input.getTrainingPlanId()).getName());
		return output;
	}

}
