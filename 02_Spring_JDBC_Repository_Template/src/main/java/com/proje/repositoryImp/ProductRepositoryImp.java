package com.proje.repositoryImp;

import javax.sql.DataSource;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.proje.model.Product;
import com.proje.repository.ProductRepository;
@Repository
public class ProductRepositoryImp implements ProductRepository{
	@Autowired
	private DataSource dataSource;
	
	private JdbcTemplate template;
	
	@Override
	public boolean save(Product product) {
		this.template.execute("");
		return false;
	}

	@Override
	public boolean update(Product product) {
		return false;
	}

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	public void setTemplate(JdbcTemplate template) {
		this.template = new JdbcTemplate(dataSource);
	}
	
	

}
