package com.proje.repository;

import java.util.List;

import com.proje.model.UserDetail;

public interface UserDetailRepository {

	boolean saveUserDetail(int id, UserDetail userDetail);

	boolean updateUserDetail(UserDetail userDetail);

	UserDetail findUserDetailById(int id);

	List<UserDetail> findUserDetais();

}
