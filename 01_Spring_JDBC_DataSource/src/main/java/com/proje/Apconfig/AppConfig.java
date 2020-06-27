package com.proje.Apconfig;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import com.proje.database.DataBase;
@Configuration
public class AppConfig {
	@Bean
	public DataBase dataBase() {
		
		DataBase dataBase=new DataBase("com.mysql.cj.jdbc.Driver", "jdbc:mysql://localhost:3306/deneme?serverTimezone=Turkey", "root", "1234");
		
		return dataBase;
	}
	@Bean
	public DataSource dataSource() {
		
		DriverManagerDataSource dataSource=new DriverManagerDataSource();
		dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost:3306/deneme?serverTimezone=Turkey");
		dataSource.setUsername("root");
		dataSource.setPassword("1234");
		return dataSource;
		
		
	}

}
