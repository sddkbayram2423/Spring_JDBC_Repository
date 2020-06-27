package com.proje.test;



import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import com.proje.config.AppConfig;
import com.proje.service.UserService;
import com.proje.serviceImp.UserServiceImp;


public class TestConfig {
	public static void main(String[] args) {
		ConfigurableApplicationContext applicationContext=new AnnotationConfigApplicationContext(AppConfig.class);
		UserService userService=applicationContext.getBean(UserServiceImp.class);
		System.out.println(userService.findUserDetaisById(1));


		
		
		applicationContext.close();
	}

}

