package com.proje.repository;

import java.util.List;

import com.proje.model.Product;

public interface ProductRepository {
	
	boolean createTable();

	boolean save(Product product);

	boolean update(Product product);
	
	boolean deleteProduct(int id); 
	
	boolean saveBatch(List<Product> products);
	
	Product fidProductById(int id);
	
	List<Product> findProducts();
}
