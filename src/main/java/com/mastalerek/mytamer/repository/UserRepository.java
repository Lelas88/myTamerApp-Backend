package com.mastalerek.mytamer.repository;

import org.springframework.data.repository.CrudRepository;

import com.mastalerek.mytamer.entity.User;

public interface UserRepository extends CrudRepository<User, Integer>  {
	public User findByUsername(String username);

	public User findByUsernameAndPassword(String username, String password);
}
