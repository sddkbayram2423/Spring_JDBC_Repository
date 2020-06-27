package com.proje.repository;

import java.util.List;

import com.proje.model.Product;

public interface ProductRepository {
	
	Product findByProductID(int productID);
	
	List<Product> findProductsList();
}
