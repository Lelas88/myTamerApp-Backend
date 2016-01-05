package com.mastalerek.mytamer.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Component;

import com.google.common.collect.Lists;
import com.mastalerek.mytamer.entity.Diet;
import com.mastalerek.mytamer.entity.ExerciseSet;
import com.mastalerek.mytamer.entity.Student;
import com.mastalerek.mytamer.entity.StudentTrainingPlan;
import com.mastalerek.mytamer.entity.TrainingPlan;
import com.mastalerek.mytamer.entity.TrainingPlanDiet;
import com.mastalerek.mytamer.entity.TrainingPlanExerciseSet;
import com.mastalerek.mytamer.entity.User;
import com.mastalerek.mytamer.functions.StudentTrainingPlansToTrainingPlanBasicWebModelFunction;
import com.mastalerek.mytamer.functions.TrainingPlanExerciseSetToExerciseSetBasicWebModelFunction;
import com.mastalerek.mytamer.functions.TrainingPlanToTrainingPlanWebModelFunction;
import com.mastalerek.mytamer.repository.DietRepository;
import com.mastalerek.mytamer.repository.ExerciseSetRepository;
import com.mastalerek.mytamer.repository.StudentRepository;
import com.mastalerek.mytamer.repository.StudentTrainingPlanRepository;
import com.mastalerek.mytamer.repository.TrainingPlanDietRepository;
import com.mastalerek.mytamer.repository.TrainingPlanExerciseSetRepository;
import com.mastalerek.mytamer.repository.TrainingPlanRepository;
import com.mastalerek.mytamer.repository.UserRepository;
import com.mastalerek.mytamer.webmodel.ExerciseSetBasicWebModel;
import com.mastalerek.mytamer.webmodel.TrainingPlanBasicWebModel;
import com.mastalerek.mytamer.webmodel.TrainingPlanWebModel;

@Component
public class TrainingPlanService {

	@Inject
	private TrainingPlanRepository trainingPlanRepository;
	@Inject
	private StudentTrainingPlanRepository studentTrainingPlanRepository;
	@Inject
	private StudentTrainingPlansToTrainingPlanBasicWebModelFunction studentTrainingPlansToTrainingPlanBasicWebModelFunction;
	@Inject
	private TrainingPlanToTrainingPlanWebModelFunction trainingPlanToTrainingPlanWebModelFunction;
	@Inject
	private TrainingPlanExerciseSetToExerciseSetBasicWebModelFunction trainingPlanExerciseSetToExerciseSetBasicWebModelFunction;
	@Inject
	private UserRepository userRepository;
	@Inject
	private TrainingPlanExerciseSetRepository trainingPlanExerciseSetRepository;
	@Inject
	private TrainingPlanDietRepository trainingPlanDietRepository;
	@Inject
	private ExerciseSetRepository exerciseSetRepository;
	@Inject
	private DietRepository dietRepository;
	@Inject
	private StudentRepository studentRepository;

	public List<TrainingPlanBasicWebModel> getTrainingPlanNames(Integer studentId) {
		List<StudentTrainingPlan> studentTrainingPlans = getStudentTrainingPlans(studentId);
		return Lists.transform(studentTrainingPlans, studentTrainingPlansToTrainingPlanBasicWebModelFunction);
	}

	private List<StudentTrainingPlan> getStudentTrainingPlans(Integer studentId) {
		return studentTrainingPlanRepository.findByStudentId(studentId);
	}

	private List<Integer> getStudentTrainingPlanIds(Integer studentId) {
		List<Integer> output = Lists.newArrayList();
		List<StudentTrainingPlan> studentTrainingPlans = getStudentTrainingPlans(studentId);
		for (StudentTrainingPlan studentTrainingPlan : studentTrainingPlans) {
			output.add(studentTrainingPlan.getId());
		}
		return output;
	}

	public List<TrainingPlan> getTrainingPlansByStudentId(Integer studentId) {
		return trainingPlanRepository.findByIdIn(getStudentTrainingPlanIds(studentId));
	}

	public TrainingPlanWebModel getTrainingPlanDetails(Integer trainingPlanId) {
		return trainingPlanToTrainingPlanWebModelFunction.apply(trainingPlanRepository.findOne(trainingPlanId));
	}

	public List<ExerciseSetBasicWebModel> getTrainingPlanExerciseSets(Integer trainingPlanId) {
		TrainingPlan trainingPlan = trainingPlanRepository.findOne(trainingPlanId);
		List<TrainingPlanExerciseSet> exerciseSets = trainingPlan.getExerciseSets();
		return Lists.transform(exerciseSets, trainingPlanExerciseSetToExerciseSetBasicWebModelFunction);
	}

	public List<TrainingPlanWebModel> getUserTrainingPlans(Integer userId) {
		List<TrainingPlan> trainingPlans = trainingPlanRepository.findByUserId(userId);
		return Lists.transform(trainingPlans, trainingPlanToTrainingPlanWebModelFunction);
	}

	public Integer createTrainingPlan(TrainingPlanWebModel trainingPlanWebModel) {
		User user = userRepository.findOne(trainingPlanWebModel.getUserId());
		TrainingPlan trainingPlan = new TrainingPlan();
		trainingPlan.setName(trainingPlanWebModel.getName());
		trainingPlan.setDescription(trainingPlanWebModel.getDescription());
		trainingPlan.setUser(user);
		TrainingPlan savedPlan = trainingPlanRepository.save(trainingPlan);
		return savedPlan.getId();
	}

	public void deleteTrainingPlan(Integer trainingPlanId) {
		trainingPlanRepository.delete(trainingPlanId);
	}

	public void updateTrainingPlan(TrainingPlanWebModel trainingPlanWebModel) {
		TrainingPlan trainingPlan = trainingPlanRepository.findOne(trainingPlanWebModel.getId());
		trainingPlan.setName(trainingPlanWebModel.getName());
		trainingPlan.setDescription(trainingPlanWebModel.getDescription());
		trainingPlanRepository.save(trainingPlan);
	}

	public void assignStudentsToTrainingPlan(Integer trainingPlanId, List<Integer> studentIds) {
		TrainingPlan trainingPlan = trainingPlanRepository.findOne(trainingPlanId);
		for (Integer studentId : studentIds) {
			Student student = studentRepository.findOne(studentId);
			StudentTrainingPlan studentTrainingPlan = new StudentTrainingPlan();
			studentTrainingPlan.setStudent(student);
			studentTrainingPlan.setTrainingPlan(trainingPlan);
			studentTrainingPlanRepository.save(studentTrainingPlan);
		}
	}

	public void assignExerciseSetsToTrainingPlan(Integer trainingPlanId, List<Integer> exerciseSetIds) {
		TrainingPlan trainingPlan = trainingPlanRepository.findOne(trainingPlanId);
		for (Integer exerciseSetId : exerciseSetIds) {
			ExerciseSet exerciseSet = exerciseSetRepository.findOne(exerciseSetId);
			TrainingPlanExerciseSet trainingPlanExerciseSet = new TrainingPlanExerciseSet();
			trainingPlanExerciseSet.setExerciseSet(exerciseSet);
			trainingPlanExerciseSet.setTrainingPlan(trainingPlan);
			trainingPlanExerciseSetRepository.save(trainingPlanExerciseSet);
		}
	}

	public void assignDietsToTrainingPlan(Integer trainingPlanId, List<Integer> dietIds) {
		TrainingPlan trainingPlan = trainingPlanRepository.findOne(trainingPlanId);
		for (Integer dietId : dietIds) {
			Diet diet = dietRepository.findOne(dietId);
			TrainingPlanDiet trainingPlanDiet = new TrainingPlanDiet();
			trainingPlanDiet.setDiet(diet);
			trainingPlanDiet.setTrainingPlan(trainingPlan);
			trainingPlanDietRepository.save(trainingPlanDiet);
		}
	}

	public void unassignStudentFromTrainingPlan(Integer trainingPlanId, Integer studentId) {
		StudentTrainingPlan studentTrainingPlan = studentTrainingPlanRepository
				.findByStudentIdAndTrainingPlanId(studentId, trainingPlanId);
		studentTrainingPlanRepository.delete(studentTrainingPlan);
	}

	public void unassignExerciseSetFromTrainingPlan(Integer trainingPlanId, Integer exerciseSetId) {
		TrainingPlanExerciseSet trainingPlanExerciseSet = trainingPlanExerciseSetRepository
				.findByTrainingPlanIdAndExerciseSetId(trainingPlanId, exerciseSetId);
		trainingPlanExerciseSetRepository.delete(trainingPlanExerciseSet);
	}

	public void unassignDietFromTrainingPlan(Integer trainingPlanId, Integer dietId) {
		TrainingPlanDiet trainingPlanDiet = trainingPlanDietRepository.findByTrainingPlanIdAndDietId(trainingPlanId,
				dietId);
		trainingPlanDietRepository.delete(trainingPlanDiet);
	}

	public void setActiveDiet(Integer trainingPlanId, Integer dietId) {
		disactivateOtherActiveDiets(trainingPlanId);
		Diet diet = dietRepository.findOne(dietId);
		diet.setActive(1);
		dietRepository.save(diet);
	}

	private void disactivateOtherActiveDiets(Integer trainingPlanId) {
		List<TrainingPlanDiet> trainingPlanDiets = trainingPlanDietRepository.findByTrainingPlanId(trainingPlanId);
		List<Diet> diets = Lists.newArrayList();
		trainingPlanDiets.forEach(e->diets.add(e.getDiet()));
		for (Diet diet : diets) {
			diet.setActive(0);
			dietRepository.save(diet);
		}
	}

}
