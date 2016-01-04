package com.mastalerek.mytamer.entity;


import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "progresses")
public class Progress {
	private Integer id;
	private Student student;
	private Exercise exercise;
	private StudentGoal goal;
	private Date date;
	private Double score;

	@Id
	@GeneratedValue
	@Column(name = "id", unique = true, nullable = false)
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@ManyToOne
	@JoinColumn(name = "student_id", nullable = false)
	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	@ManyToOne
	@JoinColumn(name = "exercise_id", nullable = false)
	public Exercise getExercise() {
		return exercise;
	}

	public void setExercise(Exercise exercise) {
		this.exercise = exercise;
	}

	@ManyToOne
	@JoinColumn(name = "goal_id", nullable = false)
	public StudentGoal getGoal() {
		return goal;
	}

	public void setGoal(StudentGoal goal) {
		this.goal = goal;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "date", nullable = false)
	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	@Column(name = "score", nullable = false)
	public Double getScore() {
		return score;
	}

	public void setScore(Double score) {
		this.score = score;
	}

}
