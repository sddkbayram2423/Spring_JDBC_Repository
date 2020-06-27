package com.proje.model;

import java.io.Serializable;

public class User implements Serializable{

	private static final long serialVersionUID = 1L;
	private int userId;
	private String name;
	private String password;
	private String personelNumber;
	private UserDetail userDetail;
	
	public User() {
		// TODO Auto-generated constructor stub
	}

	

	public User(int userId, String name, String password, String personelNumber) {
		super();
		this.userId = userId;
		this.name = name;
		this.password = password;
		this.personelNumber = personelNumber;
		
	}



	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public UserDetail getUserDetail() {
		return userDetail;
	}

	public void setUserDetail(UserDetail userDetail) {
		this.userDetail = userDetail;
	}
	

	public String getPersonelNumber() {
		return personelNumber;
	}



	public void setPersonelNumber(String personelNumber) {
		this.personelNumber = personelNumber;
	}



	@Override
	public String toString() {
		return "User [userId=" + userId + ", name=" + name + ", password=" + password + ", personelNumber="
				+ personelNumber + ", userDetail=" + userDetail + "]";
	}
	
	
}
