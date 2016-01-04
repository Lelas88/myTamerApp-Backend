package com.mastalerek.mytamer.service;

import java.util.Date;

import javax.inject.Inject;

import org.springframework.stereotype.Component;

import com.mastalerek.mytamer.entity.Exercise;
import com.mastalerek.mytamer.entity.Student;
import com.mastalerek.mytamer.entity.StudentGoal;
import com.mastalerek.mytamer.entity.StudentGoalInitialState;
import com.mastalerek.mytamer.entity.StudentScore;
import com.mastalerek.mytamer.repository.StudentGoalInitialStateRepository;
import com.mastalerek.mytamer.repository.StudentGoalRepository;

@Component
public class GoalService {

	@Inject
	private StudentGoalRepository goalRepository;
	@Inject
	private StudentGoalInitialStateRepository initialStateRepository;

	public void updateGoal(Student student, Exercise exercise, StudentScore score) {
		StudentGoal goal = goalRepository.findByStudentIdAndExerciseIdAndAccomplishedAndUnitId(student.getId(),
				exercise.getId(), null, exercise.getUnit().getId());

		if (goal != null) {
			if (goal.getValue() <= score.getValue()) {
				goal.setAccomplished(new Date());
				goalRepository.save(goal);

				StudentGoalInitialState initialState = initialStateRepository.findByStudentIdAndExerciseIdAndUnitId(
						student.getId(), exercise.getId(), exercise.getUnit().getId());
				initialState.setFirstState(score.getValue());
				initialStateRepository.save(initialState);
			}
		}
	}

}
