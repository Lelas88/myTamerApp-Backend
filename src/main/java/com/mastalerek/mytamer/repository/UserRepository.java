package com.mastalerek.mytamer.repository;

import org.springframework.data.repository.CrudRepository;

import com.mastalerek.mytamer.entity.User;

public interface UserRepository extends CrudRepository<User, Integer>  {
	public User findByUsername(String username);

	public User findByUsernameAndPassword(String username, String password);

	public User findByUsernameAndEmail(String login, String email);

	public User findByEmail(String email);

	public User findByStudentId(Integer studentId);
}
