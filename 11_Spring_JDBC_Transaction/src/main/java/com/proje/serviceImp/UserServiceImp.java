package com.proje.serviceImp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proje.model.User;
import com.proje.repository.UserRepository;

import com.proje.service.UserService;
@Service
public class UserServiceImp implements UserService {
	
	@Autowired
	private UserRepository userRepository;

	@Override
	public boolean saveUser(User user) {
		
		return this.userRepository.saveUser(user);
	}

	
	@Override
	public boolean updateUser(User user) {
		
		return this.userRepository.updateUser(user);
	}

	@Override
	public boolean deleteUserById(int id) {
		
		return this.userRepository.deleteUserById(id);
	}

	@Override
	public User findUserById(int id) {
		
		return this.userRepository.findUserById(id);
	}

	@Override
	public User findUserDetaisById(int id) {
		
		return this.userRepository.findUserDetaisById(id);
	}

	@Override
	public List<User> findUsers() {
		return this.userRepository.findUsers();
	}
}
