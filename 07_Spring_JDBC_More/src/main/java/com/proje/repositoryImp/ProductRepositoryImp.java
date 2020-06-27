package com.proje.repositoryImp;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import java.util.List;


import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.stereotype.Repository;

import com.proje.model.Product;
import com.proje.repository.ProductRepository;

@Repository
public class ProductRepositoryImp implements ProductRepository {

	private JdbcTemplate template;

	

	@Override
	public Product findByProductID(int productID) {
		String query=" Select * from product where productID=?";
		Product product=new Product();
		try {
			this.template.query(new PreparedStatementCreator() {
				
				@Override
				public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
					PreparedStatement preparedStatement=con.prepareStatement(query);
					preparedStatement.setInt(1, productID);
					return preparedStatement;
				}
			}, new RowCallbackHandler() {
				
				@Override
				public void processRow(ResultSet rs) throws SQLException {
					product.setProductID(rs.getInt(1));
					product.setProductName(rs.getString(2));
					product.setUnitPrice(rs.getDouble(3));
				}
			});
			
			System.out.println("product bulma basarili");
		} catch (Exception e) {
			System.out.println("product bulma hatasi :" +e);
		}
		
		return product;
	}


	@Override
	public List<Product> findProductsList() {
		String query=" Select * from product";
		List<Product> products=new ArrayList<Product>();
		try {
			this.template.query(new PreparedStatementCreator() {
				
				@Override
				public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
					PreparedStatement preparedStatement=con.prepareStatement(query);
					return preparedStatement;
				}
			}, new RowCallbackHandler() {
				
				@Override
				public void processRow(ResultSet rs) throws SQLException {
					Product product=new Product();
					product.setProductID(rs.getInt(1));
					product.setProductName(rs.getString(2));
					product.setUnitPrice(rs.getDouble(3));
					products.add(product);
					
				}
			});
			
			System.out.println("product listeleme basarili");
		} catch (Exception e) {
			System.out.println(" product listeleme hatasi :" +e);
		}
		
		return products;
	}

	@Autowired
	public void setDataSource(DataSource dataSource) {

		this.template = new JdbcTemplate(dataSource);
	}


}
