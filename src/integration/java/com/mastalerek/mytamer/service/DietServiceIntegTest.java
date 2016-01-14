package com.mastalerek.mytamer.service;

import static org.assertj.core.api.Assertions.assertThat;

import javax.inject.Inject;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.mastalerek.mytamer.Application;
import com.mastalerek.mytamer.builder.DietBuilder;
import com.mastalerek.mytamer.builder.UserBuilder;
import com.mastalerek.mytamer.entity.Diet;
import com.mastalerek.mytamer.entity.User;
import com.mastalerek.mytamer.repository.DietRepository;
import com.mastalerek.mytamer.repository.UserRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
@PropertySource({ "classpath:application.properties" })
@ComponentScan({ "com.mastalerek.mytamer" })
public class DietServiceIntegTest {

	@Inject
	private DietRepository dietRepository;
	@Inject
	private UserRepository userRepository;

	@Before
	public void setUp() {
		dietRepository.deleteAll();
		userRepository.deleteAll();
	}

	@Test
	public void shouldAddDiet() {
		// given
		User user = userRepository.save(
				new UserBuilder().withUsername("username").withEmail("test@test.com").withPassword("dfhg35&!").build());
		Diet diet = new DietBuilder().withName("diet").withDescription("test").withUser(user).build();
		Diet savedDiet = dietRepository.save(diet);
		// when
		Diet actual = dietRepository.findOne(savedDiet.getId());
		// then
		assertThat(actual).isNotNull();
		assertThat(actual.getName()).isEqualTo(savedDiet.getName());
	}
}
