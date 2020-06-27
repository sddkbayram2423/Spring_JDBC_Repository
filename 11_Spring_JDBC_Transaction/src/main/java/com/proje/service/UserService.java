package com.proje.service;

import java.util.List;

import com.proje.model.User;


public interface UserService {
	
	boolean saveUser(User user);

	boolean updateUser(User user);

	boolean deleteUserById(int id);

	User findUserById(int id);

	User findUserDetaisById(int id);

	List<User> findUsers();

}
