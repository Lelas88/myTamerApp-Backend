package com.mastalerek.mytamer.entity;

import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "students")
public class Student {
	private Integer id;
	private Group group;
	private Rank rank;
	private String firstName;
	private String lastName;
	private Date birthdate;
	private String photo;
	private List<StudentMeasurement> studentMeasurements;
	private List<StudentExercise> studentExercises;
	private List<StudentGoal> studentGoals;
	private List<StudentScore> studentScores;
	private List<StudentGoalInitialState> studentGoalInitialStates;
	private List<Progress> studentProgresses;
	private List<Contraindication> studentContraindications;
	private User user;
	private User trainer;
	private List<Timesheet> timesheets;

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
	@JoinColumn(name = "group_id", nullable = true)
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
	@Temporal(TemporalType.DATE)
	@Column(name = "birthdate", nullable = false)
	public Date getBirthdate() {
		return birthdate;
	}

	public void setBirthdate(Date birthdate) {
		this.birthdate = birthdate;
	}

	@Column(name = "photo", nullable = true)
	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "student", cascade = CascadeType.ALL)
	public List<StudentMeasurement> getStudentMeasurements() {
		return studentMeasurements;
	}

	public void setStudentMeasurements(List<StudentMeasurement> studentMeasurements) {
		this.studentMeasurements = studentMeasurements;
	}

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "student", cascade = CascadeType.ALL)
	public List<StudentExercise> getStudentExercises() {
		return studentExercises;
	}

	public void setStudentExercises(List<StudentExercise> studentExercises) {
		this.studentExercises = studentExercises;
	}

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "student", cascade = CascadeType.ALL)
	public List<StudentGoal> getStudentGoals() {
		return studentGoals;
	}

	public void setStudentGoals(List<StudentGoal> studentGoals) {
		this.studentGoals = studentGoals;
	}

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "student", cascade = CascadeType.ALL)
	public List<StudentScore> getStudentScores() {
		return studentScores;
	}

	public void setStudentScores(List<StudentScore> studentScores) {
		this.studentScores = studentScores;
	}

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "student", cascade = CascadeType.ALL)
	public List<StudentGoalInitialState> getStudentGoalInitialStates() {
		return studentGoalInitialStates;
	}

	public void setStudentGoalInitialStates(List<StudentGoalInitialState> studentGoalInitialStates) {
		this.studentGoalInitialStates = studentGoalInitialStates;
	}

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "student", cascade = CascadeType.ALL)
	public List<Progress> getStudentProgresses() {
		return studentProgresses;
	}

	public void setStudentProgresses(List<Progress> studentProgresses) {
		this.studentProgresses = studentProgresses;
	}

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "student", cascade = CascadeType.ALL)
	public List<Contraindication> getStudentContraindications() {
		return studentContraindications;
	}

	public void setStudentContraindications(List<Contraindication> studentContraindications) {
		this.studentContraindications = studentContraindications;
	}

	@OneToOne(mappedBy = "student", cascade = CascadeType.ALL)
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "trainer_id", nullable = false)
	public User getTrainer() {
		return trainer;
	}

	public void setTrainer(User trainer) {
		this.trainer = trainer;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "student")
	public List<Timesheet> getTimesheets() {
		return timesheets;
	}

	public void setTimesheets(List<Timesheet> timesheets) {
		this.timesheets = timesheets;
	}

}
