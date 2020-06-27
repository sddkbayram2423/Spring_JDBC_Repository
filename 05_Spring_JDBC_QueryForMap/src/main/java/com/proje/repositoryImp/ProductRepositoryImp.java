package com.proje.repositoryImp;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.proje.model.Product;
import com.proje.repository.ProductRepository;

@Repository
public class ProductRepositoryImp implements ProductRepository {

	private JdbcTemplate template;

	

	@Override
	public Product findByProductID(int productID) {
		String query=" Select * from product where productID=?";
		Product product=null;
		try {
			Map<String, Object> map=this.template.queryForMap(query, new Object[] {productID} );
			product=new Product((int)map.get("productID"),(String) map.get("productName"),(double) map.get("unitPrice"));
			System.out.println("Map ile product bulma basarili");
		} catch (Exception e) {
			System.out.println("Map ile product bulma hatasi :" +e);
		}
		
		return product;
	}


	@Override
	public List<Product> findProductsList() {
		String query=" Select * from product";
		List<Product> products=new ArrayList<Product>();
		try {
			List< Map<String, Object> > maps=this.template.queryForList(query);
			
			for(Map<String, Object> map:maps) {
				products.add(new Product((int)map.get("productID"),(String) map.get("productName"),(double) map.get("unitPrice")));
				
			}
			
			System.out.println("Map ile product listeleme basarili");
		} catch (Exception e) {
			System.out.println("Map ile product listeleme hatasi :" +e);
		}
		
		return products;
	}

	@Autowired
	public void setDataSource(DataSource dataSource) {

		this.template = new JdbcTemplate(dataSource);
	}


}
