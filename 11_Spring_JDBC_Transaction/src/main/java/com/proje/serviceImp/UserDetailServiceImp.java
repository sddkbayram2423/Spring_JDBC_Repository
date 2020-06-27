package com.proje.serviceImp;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proje.model.UserDetail;
import com.proje.repository.UserDetailRepository;

import com.proje.service.UserDetailService;
@Service
public class UserDetailServiceImp implements UserDetailService {
	@Autowired
	private UserDetailRepository userDetailRepository;

	@Override
	public boolean saveUserDetail(int id, UserDetail userDetail) {
		
		return this.userDetailRepository.saveUserDetail(id, userDetail);
	}

	@Override
	public boolean updateUserDetail(UserDetail userDetail) {
		
		return this.userDetailRepository.updateUserDetail(userDetail);
	}

	@Override
	public UserDetail findUserDetailById(int id) {
		
		return this.userDetailRepository.findUserDetailById(id);
	}

	@Override
	public List<UserDetail> findUserDetais() {
		
		return this.userDetailRepository.findUserDetais();
	}

}
