package com.mastalerek.mytamer.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Component;

import com.google.common.collect.Lists;
import com.mastalerek.mytamer.entity.User;
import com.mastalerek.mytamer.functions.UserEntityToUserWebModelFunction;
import com.mastalerek.mytamer.repository.UserRepository;
import com.mastalerek.mytamer.webmodel.UserWebModel;

@Component
public class UserService {

	@Inject
	private UserRepository userRepository;
	@Inject
	private PasswordEncoderGenerator passwordEncoder;
	@Inject
	private UserEntityToUserWebModelFunction userEntityToUserWebModelFunction;

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
		userRepository.save(user);
	}

	public Integer getUserIdByUsername(String username) {
		User user = userRepository.findByUsername(username);
		return user.getId();
	}
}
