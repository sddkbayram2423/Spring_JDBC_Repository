package com.proje.appconfig;

import javax.sql.DataSource;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import com.proje.personelrepositoryImp.PersonelRepositoryImp;



@Configuration
@ComponentScan("com.proje")
public class AppConfig {
	@Bean
	public DataSource dataSource() {
		DriverManagerDataSource dataSource=new DriverManagerDataSource();
		dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost:3306/örnek?serverTimezone=Turkey");
		dataSource.setUsername("root");
		dataSource.setPassword("1234");
			
		return dataSource;
			
	}
	@Bean
	public PersonelRepositoryImp personelRepositoryImp() {
		PersonelRepositoryImp repositoryImp=new PersonelRepositoryImp();
		repositoryImp.setDataSource(this.dataSource());
		return repositoryImp;
	}
	

}
