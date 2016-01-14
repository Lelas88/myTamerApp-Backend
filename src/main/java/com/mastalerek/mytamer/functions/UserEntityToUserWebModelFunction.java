package com.mastalerek.mytamer.functions;


import org.springframework.stereotype.Service;

import com.google.common.base.Function;
import com.mastalerek.mytamer.entity.User;
import com.mastalerek.mytamer.webmodel.UserWebModel;

@Service
public class UserEntityToUserWebModelFunction implements Function<User, UserWebModel> {

	@Override
	public UserWebModel apply(User input) {
		UserWebModel output = new UserWebModel();

		output.setId(input.getId());
		output.setEmail(input.getEmail());
		output.setPassword(input.getPassword());
		output.setUsername(input.getUsername());
		output.setRole(input.getRole());
		return output;
	}
}
