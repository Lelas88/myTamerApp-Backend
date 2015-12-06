package com.mastalerek.mytamer.entity;

import java.sql.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.sun.istack.internal.NotNull;

@Entity
@Table(name = "students")
public class Student {
	private Integer id;
	private Group group;
	private Rank rank;
	private String firstName;
	private String lastName;
	private Date birthdate;
	private List<StudentMeasurement> studentMeasurements;
	private List<StudentExercise> studentExercises;
	private StudentPhoto studentPhoto;

	@Id
	@GeneratedValue
	@Column(name = "id", unique = true, nullable = false)
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "group_id", nullable = false)
	public Group getGroup() {
		return group;
	}

	public void setGroup(Group group) {
		this.group = group;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "rank_id", nullable = false)
	public Rank getRank() {
		return rank;
	}

	public void setRank(Rank rank) {
		this.rank = rank;
	}

	@NotNull
	@Column(name = "first_name", nullable = false)
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	@NotNull
	@Column(name = "last_name", nullable = false)
	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	@NotNull
	@Column(name = "birthdate", nullable = false, columnDefinition = "DATETIME")
	public Date getBirthdate() {
		return birthdate;
	}

	public void setBirthdate(Date birthdate) {
		this.birthdate = birthdate;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "student", cascade = CascadeType.ALL)
	public List<StudentMeasurement> getStudentMeasurements() {
		return studentMeasurements;
	}

	public void setStudentMeasurements(List<StudentMeasurement> studentMeasurements) {
		this.studentMeasurements = studentMeasurements;
	}

	@OneToOne(fetch = FetchType.LAZY, mappedBy = "student", cascade = CascadeType.ALL)
	public StudentPhoto getStudentPhoto() {
		return studentPhoto;
	}

	public void setStudentPhoto(StudentPhoto studentPhoto) {
		this.studentPhoto = studentPhoto;
	}

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "student", cascade = CascadeType.ALL)
	public List<StudentExercise> getStudentExercises() {
		return studentExercises;
	}

	public void setStudentExercises(List<StudentExercise> studentExercises) {
		this.studentExercises = studentExercises;
	}

}
