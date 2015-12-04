package com.mastalerek.mytamer.webapi.impl;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.core.Response;

import org.springframework.stereotype.Component;

import com.mastalerek.mytamer.service.UserService;
import com.mastalerek.mytamer.webapi.UserWebApi;
import com.mastalerek.mytamer.webmodel.UserWebModel;

@Component
public class UserWebApiImpl implements UserWebApi {
	
	@Inject 
	UserService userService;

	@Override
	public UserWebModel getUserByUsername(String username) {
		try {
			return userService.getUserByUsername(username);
		} catch (Exception e) {
			System.out.println(e);
			return null;
			// return new ExceptionToResponseMapper().getResponse(e);
		}
	}

	@Override
	public List<UserWebModel> getAllUsers() {
		return userService.getAllUsers();
	}

	@Override
	public UserWebModel getById(Integer userId) {
		try {
			return userService.getByUserId(userId);
		} catch (Exception e) {
			System.out.println(e);
			return null;
			// return new ExceptionToResponseMapper().getResponse(e);
		}
	}

	@Override
	public boolean loginUser(String username, String password) {
		try {
			return userService.verifyData(username, password);
		} catch (Exception e) {
			System.out.println(e);
			return false;
			// return new ExceptionToResponseMapper().getResponse(e);
		}
	}

	@Override
	public Response createUser(UserWebModel user) {
		userService.createUser(user);
		return Response.ok().build();
	}

}
