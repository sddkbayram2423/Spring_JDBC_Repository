package com.proje.test;

import java.util.List;

import org.springframework.context.ConfigurableApplicationContext;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.proje.model.User;
import com.proje.model.UserDetail;
import com.proje.service.UserDetailService;
import com.proje.service.UserService;
import com.proje.serviceImp.UserDetailServiceImp;
import com.proje.serviceImp.UserServiceImp;

public class TestXML {
	public static void main(String[] args) {
		ConfigurableApplicationContext applicationContext=new ClassPathXmlApplicationContext("applicationContext.xml");
		UserService userService=applicationContext.getBean("userServiceImp",UserServiceImp.class);
	
		User user=userService.findUserDetaisById(2);
		
		System.out.println(user);
		
		
	
		
	
		applicationContext.close();
	}
	public static void testUser() {	
		ConfigurableApplicationContext applicationContext=new ClassPathXmlApplicationContext("applicationContext.xml");
		UserService userService=applicationContext.getBean("userServiceImp",UserServiceImp.class);
		User user=new User(1, "Bahar", "3121566","123456");
		User user1=new User(2, "Hilal", "gh78544","757422");
		User user2=new User(3, "Zahide", "754654k","75556546");
		User user3=new User(4, "Nazlý", "gfhg4456","1237875");
		userService.saveUser(user);
		userService.saveUser(user1);
		userService.saveUser(user2);
		userService.saveUser(user3);
		
		
		List<User> users=userService.findUsers();
		for(User u:users) {
			System.out.println(u);
		}
		applicationContext.close();
		
		
	}
	public void userDetailTest() {
		
		ConfigurableApplicationContext applicationContext=new ClassPathXmlApplicationContext("applicationContext.xml");
		UserDetailService userDetailService=applicationContext.getBean("userDetailServiceImp",UserDetailServiceImp.class);
		UserDetail userDetail=new UserDetail(100, "A", "B", "Ýstanbul");
		UserDetail userDetail1=new UserDetail(101, "C", "D", "Ýzmir");
		UserDetail userDetail2=new UserDetail(102, "E", "E", "Konya");
		UserDetail userDetail3=new UserDetail(103, "H", "M", "manisa");
		
		userDetailService.saveUserDetail(1, userDetail);
		userDetailService.saveUserDetail(2, userDetail1);
		userDetailService.saveUserDetail(3, userDetail2);
		userDetailService.saveUserDetail(4, userDetail3);
		
		System.out.println(userDetailService.findUserDetailById(101));
		
		List<UserDetail> details=userDetailService.findUserDetais();
		for(UserDetail detail:details) {
			System.out.println(detail);
		}
	
		
//		UserDetail userDetail3=new UserDetail(103, "N", "ATAK", "Þýrnak");
//		userDetailService.updateUserDetail(userDetail3);
		
		applicationContext.close();
		
		
		
	}


}
