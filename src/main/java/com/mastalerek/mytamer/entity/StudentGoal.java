package com.mastalerek.mytamer.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "student_goals")
public class StudentGoal {
	private Integer id;
	private Student student;
	private Goal goal;
	private Date accomplished;

	@Id
	@GeneratedValue
	@Column(name = "id", unique = true, nullable = false)
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "student_id", nullable = false)
	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "goal_id", nullable = false)
	public Goal getGoal() {
		return goal;
	}

	public void setGoal(Goal goal) {
		this.goal = goal;
	}

	@Column(name = "accomplished", nullable = false, columnDefinition = "DATETIME")
	public Date getAccomplished() {
		return accomplished;
	}

	public void setAccomplished(Date accomplished) {
		this.accomplished = accomplished;
	}
}
