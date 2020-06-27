package com.proje.model;

import java.io.Serializable;

public class UserDetail implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private int userDetailId;
	private String name;
	private String lastName;
	private String city;
	
	public UserDetail() {
		// TODO Auto-generated constructor stub
	}
	public UserDetail(int userDetailId, String name, String lastName, String city) {
		super();
		this.userDetailId = userDetailId;
		this.name = name;
		this.lastName = lastName;
		this.city = city;
	}
	public int getUserDetailId() {
		return userDetailId;
	}
	public void setUserDetailId(int userDetailId) {
		this.userDetailId = userDetailId;
	} 
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	@Override
	public String toString() {
		return "UserDetail [userDetailId=" + userDetailId + ", name=" + name + ", lastName=" + lastName + ", city="
				+ city + "]";
	}
	
	

}
