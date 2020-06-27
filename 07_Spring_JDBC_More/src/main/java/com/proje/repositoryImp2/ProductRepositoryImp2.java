package com.proje.repositoryImp2;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import java.util.List;


import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.ResultSetExtractor;
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
			
			product=this.template.query(new PreparedStatementCreator() {
				
				@Override
				public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
					PreparedStatement preparedStatement=con.prepareStatement(query);
					preparedStatement.setInt(1, productID);
					return preparedStatement;
				}
			}, new ResultSetExtractor<Product>() {

				@Override
				public Product extractData(ResultSet rs) throws SQLException, DataAccessException {
					rs.next();
					return new Product(rs.getInt(1), rs.getString(2), rs.getDouble(3));
				}
			});
			
	
			System.out.println("Product bulma basarili");
		} catch (Exception e) {
			System.out.println("Product bulma hatasi :" +e);
		}
		
		return product;
	}


	@Override
	public List<Product> findProductsList() {
		String query=" Select * from product";
		List<Product> products=new ArrayList<Product>();
		try {
			products=this.template.query(new PreparedStatementCreator() {
				
				@Override
				public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				PreparedStatement preparedStatement=con.prepareStatement(query);
					return preparedStatement;
				}
			}, new ResultSetExtractor<List<Product>>() {

				@Override
				public List<Product> extractData(ResultSet rs) throws SQLException, DataAccessException {
					 List<Product> products1=new ArrayList<Product>();
					 while(rs.next()) {
						 products1.add(new Product(rs.getInt(1), rs.getString(2), rs.getDouble(3)));
					 }
					 
					return products1;
				}
			});
			
			System.out.println("Product listeleme basarili");
		} catch (Exception e) {
			System.out.println("Product listeleme hatasi :" +e);
		}
		
		return products;
	}

	@Autowired
	public void setDataSource(DataSource dataSource) {

		this.template = new JdbcTemplate(dataSource);
	}


}
