package com.proje.config;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.proje.repository.UserDetailRepository;
import com.proje.repository.UserRepository;
import com.proje.repositoryImp.UserDetailRepositoryImp;
import com.proje.repositoryImp.UserRepositoryImp;
@Configuration
@ComponentScan("com.proje")
@EnableTransactionManagement
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
	public UserRepository userRepository() {
		UserRepositoryImp repository=new UserRepositoryImp();
		repository.setDataSource(this.dataSource());
		return repository;
	}
	@Bean
	public UserDetailRepository userDetailRepository() {
		UserDetailRepositoryImp detailRepositoryImp=new UserDetailRepositoryImp();
		detailRepositoryImp.setDataSource(this.dataSource());
		return detailRepositoryImp;
		
	}
	@Bean
	public DataSourceTransactionManager dataSourceTransactionManager() {
		DataSourceTransactionManager dataSourceTransactionManager=new DataSourceTransactionManager();
		dataSourceTransactionManager.setDataSource(this.dataSource());
		return dataSourceTransactionManager;
		
		
		
	}

}
