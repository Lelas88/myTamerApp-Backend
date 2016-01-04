package com.mastalerek.mytamer.service;

import java.util.Date;
import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Component;

import com.mastalerek.mytamer.entity.Exercise;
import com.mastalerek.mytamer.entity.Progress;
import com.mastalerek.mytamer.entity.Rank;
import com.mastalerek.mytamer.entity.Student;
import com.mastalerek.mytamer.entity.StudentGoal;
import com.mastalerek.mytamer.entity.StudentGoalInitialState;
import com.mastalerek.mytamer.entity.StudentScore;
import com.mastalerek.mytamer.enums.RankEnum;
import com.mastalerek.mytamer.repository.ProgressRepository;
import com.mastalerek.mytamer.repository.RankRepository;
import com.mastalerek.mytamer.repository.StudentGoalInitialStateRepository;
import com.mastalerek.mytamer.repository.StudentGoalRepository;
import com.mastalerek.mytamer.repository.StudentRepository;
import com.mastalerek.mytamer.repository.StudentScoreRepository;

@Component
public class RankService {

	@Inject
	private RankRepository rankRepository;
	@Inject
	private StudentScoreRepository scoreRepository;
	@Inject
	private StudentGoalRepository goalRepository;
	@Inject
	private StudentRepository studentRepository;
	@Inject
	private ProgressRepository progressRepository;
	@Inject
	private StudentGoalInitialStateRepository initialStateRepository;

	public String getRankById(Integer rankId) {
		Rank rank = rankRepository.findOne(rankId);
		return rank.getName();
	}

	public void calculateRank(Student student, Exercise exercise, StudentScore score) {
		Integer accomplishedGoals = goalRepository.countByStudentIdAndAccomplished(student.getId(), null);
		Integer rankValue = 0;
		if (accomplishedGoals <= 10) {
			rankValue = RankEnum.NOOBIE.getValue();
		} else if (accomplishedGoals > 10 && accomplishedGoals <= 20) {
			rankValue = RankEnum.BEGINNER.getValue();
		} else if (accomplishedGoals > 20 && accomplishedGoals <= 40) {
			rankValue = RankEnum.AMATOR.getValue();
		} else if (accomplishedGoals > 40 && accomplishedGoals <= 60) {
			rankValue = RankEnum.SEMIPRO.getValue();
		} else if (accomplishedGoals > 60) {
			rankValue = RankEnum.PROFESSIONAL.getValue();
		}
		Rank rank = rankRepository.findOne(rankValue);
		student.setRank(rank);
		studentRepository.save(student);

		StudentGoal goal = goalRepository.findByStudentIdAndExerciseIdAndAccomplishedAndUnitId(student.getId(),
				exercise.getId(), null, exercise.getUnit().getId());
		if (goal != null) {
			Progress progress = new Progress();
			progress.setDate(new Date());
			progress.setExercise(exercise);
			progress.setScore(countProgress(student, exercise, score));
			progress.setStudent(student);
			progress.setGoal(goal);
			progressRepository.save(progress);
		}
	}

	private Double countProgress(Student student, Exercise exercise, StudentScore score) {
		StudentGoalInitialState initialState = initialStateRepository
				.findByStudentIdAndExerciseIdAndUnitId(student.getId(), exercise.getId(), exercise.getUnit().getId());
		Double startValue = 0.0;
		if (initialState != null) {
			startValue = initialState.getFirstState();
		}
		StudentGoal goal = goalRepository.findByStudentIdAndExerciseIdAndAccomplishedAndUnitId(student.getId(),
				exercise.getId(), null, exercise.getUnit().getId());
		Double goalValue = 0.0;
		if (goal != null) {
			goalValue = goal.getValue();
		} else {
			return 0.0;
		}
		Double bestResult = 0.0;
		List<StudentScore> scores = scoreRepository.findByStudentIdAndExerciseIdAndUnitId(student.getId(),
				exercise.getId(), exercise.getUnit().getId());
		for (StudentScore studentScore : scores) {
			if (studentScore.getValue() > bestResult) {
				bestResult = studentScore.getValue();
			}
		}
		return bestResult / (goalValue - startValue);
	}

	public Integer getRankByStudentId(Integer studentId) {
		Integer accomplishedGoals = goalRepository.countByStudentIdAndAccomplished(studentId, null);
		if (accomplishedGoals > 0) {
			Double progressValue = 0.0;
			if (accomplishedGoals <= 10) {
				progressValue = (double) (accomplishedGoals / 10);
			} else if (accomplishedGoals > 10 && accomplishedGoals <= 20) {
				progressValue = (double) (accomplishedGoals / 20);
			} else if (accomplishedGoals > 20 && accomplishedGoals <= 40) {
				progressValue = (double) (accomplishedGoals / 40);
			} else if (accomplishedGoals > 40 && accomplishedGoals <= 60) {
				progressValue = (double) (accomplishedGoals / 60);
			} else if (accomplishedGoals > 60) {
				progressValue = 0.0;
			}
			return (int) Math.round(progressValue);
		} else {
			return 0;
		}
	}
}
