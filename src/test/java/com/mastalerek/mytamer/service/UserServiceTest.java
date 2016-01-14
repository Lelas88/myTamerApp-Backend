package com.mastalerek.mytamer.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.mastalerek.mytamer.builder.UserBuilder;
import com.mastalerek.mytamer.builder.UserWebModelBuilder;
import com.mastalerek.mytamer.entity.User;
import com.mastalerek.mytamer.functions.UserEntityToUserWebModelFunction;
import com.mastalerek.mytamer.repository.UserRepository;
import com.mastalerek.mytamer.webmodel.UserWebModel;

public class UserServiceTest {

	private static final String EMAIL = "test@test.com";
	private static final String PASSWORD = "password";
	private static final String USERNAME = "username";
	private static final int USER_ID = 2323;
	@Mock
	private UserRepository userRepository;
	@Mock
	private UserEntityToUserWebModelFunction userEntityToUserWebModelFunction;
	@Mock
	private PasswordEncoderGenerator passwordEncoder;
	@InjectMocks
	private UserService tested;

	@Before
	public void before() {
		tested = new UserService();
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void shouldGetUserWebModelByUserId() {
		// given
		User user = new UserBuilder().withId(USER_ID).withUsername(USERNAME).withPassword(PASSWORD).withEmail(EMAIL)
				.build();
		UserWebModel userModel = new UserWebModelBuilder().withEmail(EMAIL).withUsername(USERNAME)
				.withPassword(PASSWORD).withId(USER_ID).build();
		when(userRepository.findOne(eq(USER_ID))).thenReturn(user);
		when(userEntityToUserWebModelFunction.apply(eq(user))).thenReturn(userModel);
		// when
		UserWebModel actual = tested.getByUserId(USER_ID);
		// then
		assertThat(actual.getUsername()).isEqualTo(user.getUsername());
		assertThat(actual.getPassword()).isEqualTo(user.getPassword());
	}
}
