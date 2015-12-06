package com.mastalerek.mytamer.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "beacons")
public class Beacon {
	private Integer id;
	private Exercise exerciseId;
	private String uuid;

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
	@JoinColumn(name = "exercise_id", nullable = false)
	public Exercise getExerciseId() {
		return exerciseId;
	}

	public void setExerciseId(Exercise exerciseId) {
		this.exerciseId = exerciseId;
	}

	@Column(name = "uuid", nullable = false)
	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

}
