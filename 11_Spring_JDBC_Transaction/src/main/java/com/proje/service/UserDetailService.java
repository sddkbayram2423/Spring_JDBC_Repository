package com.proje.service;

import java.util.List;

import com.proje.model.UserDetail;

public interface UserDetailService {
	
	boolean saveUserDetail(int id, UserDetail userDetail);

	boolean updateUserDetail(UserDetail userDetail);

	UserDetail findUserDetailById(int id);

	List<UserDetail> findUserDetais();

}
