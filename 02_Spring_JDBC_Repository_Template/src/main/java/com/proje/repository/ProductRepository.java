package com.proje.repository;

import com.proje.model.Product;

public interface ProductRepository {

	boolean save(Product product);
	boolean update(Product product);

}
