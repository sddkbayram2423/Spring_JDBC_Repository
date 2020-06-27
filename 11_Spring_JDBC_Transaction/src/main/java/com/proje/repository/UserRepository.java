package com.proje.repository;

import java.util.List;

import com.proje.model.User;

public interface UserRepository {
	
	boolean saveUser(User user);

	boolean updateUser(User user);

	boolean deleteUserById(int id);

	User findUserById(int id);

	User findUserDetaisById(int id);

	List<User> findUsers();

}
