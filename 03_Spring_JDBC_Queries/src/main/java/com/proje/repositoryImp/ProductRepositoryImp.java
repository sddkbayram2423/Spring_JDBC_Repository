package com.proje.repositoryImp;

import java.sql.Connection;


//import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.stereotype.Repository;

import com.proje.model.Product;
import com.proje.repository.ProductRepository;

@Repository
public class ProductRepositoryImp implements ProductRepository {

	private JdbcTemplate template;

	@Override
	public boolean createTable() {

		String sorgu = "create table Product(productID int primary key not null,productName varchar(30),unitPrice Double)";
		try {
			this.template.execute(sorgu);
			System.out.println("Tablo olusturma basarili");
		} catch (Exception e) {
			System.out.println("Tablo olusturma hatasi " + e);
			return false;

		}
		return true;
	}

	@Override
	public boolean save(Product product) {
		String sorgu = "insert into Product(productID ,productName ,unitPrice) values(?,?,?)";
		try {

			this.template.update(sorgu,
					new Object[] { product.getProductID(), product.getProductName(), product.getUnitPrice() });
			
			
			/*
			this.template.update(new PreparedStatementCreator() {
			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				PreparedStatement preparedStatement=con.prepareStatement(sorgu);
				preparedStatement.setString(2, product.getProductName());
				preparedStatement.setDouble(3, product.getUnitPrice());
				preparedStatement.setInt(1, product.getProductID());
				return preparedStatement;
			}
		});
 
			 */
			System.out.println("Product ekleme basarili");
		} catch (Exception e) {
			System.out.println("Product ekleme hatasi " + e);
			return false;

		}
		return true;
	}

	@Override
	public boolean update(Product product) {
		String sorgu = "update product set productName=?,unitPrice=? where productID=?";

		try {
			/*
			this.template.update(new PreparedStatementCreator() {
				@Override
				public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
					PreparedStatement preparedStatement=con.prepareStatement(sorgu);
					preparedStatement.setString(1, product.getProductName());
					preparedStatement.setDouble(2, product.getUnitPrice());
					preparedStatement.setInt(3, product.getProductID());
					return preparedStatement;
				}
			});
		 */
			this.template.update(sorgu, new PreparedStatementSetter() {

				@Override
				public void setValues(PreparedStatement ps) throws SQLException {
					ps.setString(1, product.getProductName());
					ps.setDouble(2, product.getUnitPrice());
					ps.setInt(3, product.getProductID());

				}
			});

//			this.template.update(sorgu,new  Object[] {product.getProductName(),product.getUnitPrice(),product.getProductID()});

			System.out.println("Urun guncellendi");
		} catch (Exception e) {
			System.out.println("Urun guncelleme hatasi :" + e);
			return false;
		}

		return true;
	}

	@Override
	public boolean deleteProduct(int id) {

		String sorgu="delete from product where productID=?";
		
		try {
			//ilk yol
			this.template.update(new PreparedStatementCreator() {
				
				@Override
				public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
					PreparedStatement preparedStatement=con.prepareStatement(sorgu);
					preparedStatement.setInt(1, id);
					return preparedStatement;
				}
			});
			
			//ikinci  yol
			this.template.update(sorgu, new Object[]{id});
			//ucuncu  yol
			this.template.update(sorgu, new PreparedStatementSetter() {
				
				@Override
				public void setValues(PreparedStatement ps) throws SQLException {
					ps.setInt(1, id);
					
				}
			});
			
		System.out.println("Urun silindi");
		} catch (Exception e) {
			System.out.println("Urun silinme hatasi: "+e);
			return false;
		}
		
	
		return true;
	}
	
	
	@Override
	public boolean saveBatch(List<Product> products) {
		
		String sorgu = "insert into Product(productID ,productName ,unitPrice) values(?,?,?)";
		
		try {
			
//			for(Product product:products) {
//				
//				this.template.update(sorgu, new Object[] {product.getProductID(),product.getProductName(),product.getUnitPrice()});
//				
//			}
			
			this.template.batchUpdate(sorgu, new BatchPreparedStatementSetter() {
				
				@Override
				public void setValues(PreparedStatement ps, int i) throws SQLException {
					Product product1=products.get(i);
					ps.setInt(1, product1.getProductID());
					ps.setString(2, product1.getProductName());
					ps.setDouble(3, product1.getUnitPrice());
	
				}
				
				@Override
				public int getBatchSize() {
					
					return products.size();
				}
			});
			
			System.out.println("liste basarili bir sekilde eklendi");
		} catch (Exception e) {
			System.out.println("Liste ekleme hatasi: "+e);
			return false;
		}
	
		return true;
	}
	
	@Autowired
	public void setDataSource(DataSource dataSource) {

		this.template = new JdbcTemplate(dataSource);
	}

}
