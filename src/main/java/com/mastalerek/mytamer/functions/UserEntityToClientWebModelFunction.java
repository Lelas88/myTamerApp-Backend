package com.mastalerek.mytamer.functions;


import org.springframework.stereotype.Service;

import com.google.common.base.Function;
import com.mastalerek.mytamer.entity.User;
import com.mastalerek.mytamer.webmodel.UserWebClientModel;

@Service
public class UserEntityToClientWebModelFunction implements Function<User, UserWebClientModel> {

	@Override
	public UserWebClientModel apply(User input) {
		UserWebClientModel output = new UserWebClientModel();

		output.setId(input.getId());
		output.setEmail(input.getEmail());
		output.setPassword(input.getPassword());
		output.setUsername(input.getUsername());
		return output;
	}
}
