package com.mastalerek.mytamer.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.google.common.collect.Lists;
import com.mastalerek.mytamer.entity.Student;
import com.mastalerek.mytamer.entity.User;
import com.mastalerek.mytamer.functions.UserEntityToUserWebModelFunction;
import com.mastalerek.mytamer.repository.StudentRepository;
import com.mastalerek.mytamer.repository.UserRepository;
import com.mastalerek.mytamer.webmodel.StudentCredentials;
import com.mastalerek.mytamer.webmodel.UserWebModel;

@Component
public class UserService {

	@Inject
	private UserRepository userRepository;
	@Inject
	private PasswordEncoderGenerator passwordEncoder;
	@Inject
	private UserEntityToUserWebModelFunction userEntityToUserWebModelFunction;
	@Inject
	private AuthorisationService authorisationService;
	@Inject
	private StudentRepository studentRepository;
	@Inject
	private MailService mailService;

	public UserWebModel getUserByUsername(String username) {
		User user = userRepository.findByUsername(username);
		return userEntityToUserWebModelFunction.apply(user);
	}

	public List<UserWebModel> getAllUsers() {
		List<UserWebModel> allUsersWebModel = Lists.newArrayList();
		Iterable<User> allUsers = userRepository.findAll();
		for (User user : allUsers) {
			allUsersWebModel.add(userEntityToUserWebModelFunction.apply(user));
		}
		return allUsersWebModel;
	}

	public UserWebModel getByUserId(Integer userId) {
		User user = userRepository.findOne(userId);
		return userEntityToUserWebModelFunction.apply(user);
	}

	public boolean verifyData(String username, String password) {
		return userRepository.findByUsernameAndPassword(username, password) != null ? true : false;
	}

	public void createUser(UserWebModel userModel) {
		User user = new User();
		user.setEmail(userModel.getEmail());
		user.setUsername(userModel.getUsername());
		user.setPassword(passwordEncoder.encodePassword(userModel.getPassword()));
		user.setRole(userModel.getRole());
		userRepository.save(user);
	}

	public Integer getUserIdByUsername(String username) {
		User user = userRepository.findByUsername(username);
		return user.getId();
	}

	public UserWebModel verifyLogin(String login) {
		User user = userRepository.findByUsername(login);
		return user != null ? userEntityToUserWebModelFunction.apply(user) : null;
	}

	public UserWebModel verifyEmail(String email) {
		User user = userRepository.findByEmail(email);
		return user != null ? userEntityToUserWebModelFunction.apply(user) : null;
	}

	@Transactional
	public void registerStudent(StudentCredentials credentials) {
		credentials.setPassword(authorisationService.generatePassword());
		User user = new User();
		user.setUsername(credentials.getLogin());
		user.setEmail(credentials.getEmail());
		user.setPassword(credentials.getPassword());
		user.setRole("STUDENT");
		Student student = studentRepository.findOne(credentials.getStudentId());
		user.setStudent(student);
		mailService.sendEmailForNewStudent(credentials);
		User savedUser = userRepository.save(user);
		student.setUser(savedUser);
		studentRepository.save(student);
	}

	public void registerCoach(UserWebModel coach) {
		User user = new User();
		user.setEmail(coach.getEmail());
		user.setUsername(coach.getUsername());
		user.setPassword(authorisationService.generatePassword());
		user.setRole("COACH");
		userRepository.save(user);
	}
}
