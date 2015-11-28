package com.mastalerek.mytamer.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Component;

import com.google.common.collect.Lists;
import com.mastalerek.mytamer.entity.User;
import com.mastalerek.mytamer.functions.UserEntityToClientWebModelFunction;
import com.mastalerek.mytamer.repository.UserRepository;
import com.mastalerek.mytamer.webmodel.UserWebClientModel;

@Component
public class UserService {

	@Inject
	private UserRepository userRepository;
	@Inject
	private UserEntityToClientWebModelFunction userEntityToClientWebModelFunction;
	
	public UserWebClientModel getUserByUsername(String username) {
		User user = userRepository.findByUsername(username);
		return userEntityToClientWebModelFunction.apply(user);
	}

	public List<UserWebClientModel> getAllUsers() {
		List<UserWebClientModel> allUsersWebModel = Lists.newArrayList();
		Iterable<User> allUsers = userRepository.findAll(); 
		for (User user : allUsers) {
			allUsersWebModel.add(userEntityToClientWebModelFunction.apply(user));
		}
		return allUsersWebModel;
	}
}
