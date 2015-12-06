package com.mastalerek.mytamer.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "student_training_plans")
public class StudentTrainingPlan {
	private Integer id;
	private Integer studentId;
	private Integer trainingPlanId;

	@Id
	@GeneratedValue
	@Column(name = "id", unique = true, nullable = false)
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Column(name = "student_id", nullable = false)
	public Integer getStudentId() {
		return studentId;
	}

	public void setStudentId(Integer studentId) {
		this.studentId = studentId;
	}

	@Column(name = "training_plan_id", nullable = false)
	public Integer getTrainingPlanId() {
		return trainingPlanId;
	}

	public void setTrainingPlanId(Integer trainingPlanId) {
		this.trainingPlanId = trainingPlanId;
	}

}
