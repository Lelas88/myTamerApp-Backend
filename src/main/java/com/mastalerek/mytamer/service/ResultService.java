package com.mastalerek.mytamer.service;

import java.util.Date;
import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Component;

import com.mastalerek.mytamer.entity.Exercise;
import com.mastalerek.mytamer.entity.ExerciseUnit;
import com.mastalerek.mytamer.entity.Student;
import com.mastalerek.mytamer.entity.StudentGoal;
import com.mastalerek.mytamer.entity.StudentGoalInitialState;
import com.mastalerek.mytamer.entity.StudentScore;
import com.mastalerek.mytamer.repository.ExerciseRepository;
import com.mastalerek.mytamer.repository.ExerciseUnitRepository;
import com.mastalerek.mytamer.repository.StudentGoalInitialStateRepository;
import com.mastalerek.mytamer.repository.StudentGoalRepository;
import com.mastalerek.mytamer.repository.StudentRepository;
import com.mastalerek.mytamer.repository.StudentScoreRepository;
import com.mastalerek.mytamer.webmodel.ScoreWebModel;

@Component
public class ResultService {
	@Inject
	private StudentScoreRepository studentScoreRepository;
	@Inject
	private StudentGoalRepository studentGoalRepository;
	@Inject
	private StudentGoalInitialStateRepository initialStateRepository;
	@Inject
	private StudentRepository studentRepository;
	@Inject
	private ExerciseRepository exerciseRepository;
	@Inject
	private ExerciseUnitRepository unitRepository;
	@Inject
	private RankService rankService;
	@Inject
	private GoalService goalService;

	public void saveResult(ScoreWebModel result) {
		StudentScore score = new StudentScore();
		Student student = studentRepository.findOne(result.getStudentId());
		Exercise exercise = exerciseRepository.findOne(result.getExerciseId());
		ExerciseUnit unit = unitRepository.findOne(result.getUnitId());

		score.setDate(new Date());
		score.setStudent(student);
		score.setExercise(exercise);
		score.setUnit(unit);
		score.setValue(result.getValue());

		StudentGoal studentGoal = studentGoalRepository.findByStudentIdAndExerciseIdAndAccomplishedAndUnitId(
				student.getId(), exercise.getId(), null, exercise.getUnit().getId());
		List<StudentScore> studentScore = studentScoreRepository.findByStudentIdAndExerciseIdAndUnitId(student.getId(),
				exercise.getId(), exercise.getUnit().getId());
		if (studentGoal != null && studentScore.size() <= 0) {
			StudentGoalInitialState initialState = new StudentGoalInitialState();
			initialState.setExercise(exercise);
			initialState.setFirstState(result.getValue());
			initialState.setStudent(student);
			initialState.setUnit(exercise.getUnit());
			initialStateRepository.save(initialState);
		}

		studentScoreRepository.save(score);
		goalService.updateGoal(student, exercise, score);
		rankService.calculateRank(student, exercise, score);
	}
}
