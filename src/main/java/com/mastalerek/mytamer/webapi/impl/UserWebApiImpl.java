package com.mastalerek.mytamer.webapi.impl;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Component;

import com.mastalerek.mytamer.service.UserService;
import com.mastalerek.mytamer.webapi.UserWebApi;
import com.mastalerek.mytamer.webmodel.UserWebClientModel;

@Component
public class UserWebApiImpl implements UserWebApi {
	
	@Inject 
	UserService userService;

	@Override
	public UserWebClientModel getUserByUsername(String username) {
		try {
			return userService.getUserByUsername(username);
		} catch (Exception e) {
			System.out.println(e);
			return null;
			// return new ExceptionToResponseMapper().getResponse(e);
		}
	}

	@Override
	public List<UserWebClientModel> getAllUsers() {
		return userService.getAllUsers();
	}

}
