package com.proje.repositoryImp2;

import java.util.ArrayList;

import java.util.List;


import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.proje.model.Product;
import com.proje.repository.ProductRepository;

@Repository
public class ProductRepositoryImp2 implements ProductRepository {

	private JdbcTemplate template;

	

	@Override
	public Product findByProductID(int productID) {
		String query=" Select * from product where productID=?";
		Product product=null;
		try {
			product=this.template.queryForObject(query,new Object[] {productID},new BeanPropertyRowMapper<Product>(Product.class));
			System.out.println("BeanPropertyRowMapper ile product bulma basarili");
		} catch (Exception e) {
			System.out.println("BeanPropertyRowMapper ile product bulma hatasi :" +e);
		}
		
		return product;
	}


	@Override
	public List<Product> findProductsList() {
		String query=" Select * from product";
		List<Product> products=new ArrayList<Product>();
		try {
			products=this.template.query(query,new BeanPropertyRowMapper<Product>(Product.class));
			
			System.out.println("BeanPropertyRowMapper ile product listeleme basarili");
		} catch (Exception e) {
			System.out.println("BeanPropertyRowMapper ile product listeleme hatasi :" +e);
		}
		
		return products;
	}

	@Autowired
	public void setDataSource(DataSource dataSource) {

		this.template = new JdbcTemplate(dataSource);
	}


}
