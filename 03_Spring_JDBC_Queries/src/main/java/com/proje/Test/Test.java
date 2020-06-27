package com.proje.Test;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.ConfigurableApplicationContext;




import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.proje.model.Product;
import com.proje.repositoryImp.ProductRepositoryImp;

public class Test {

	public static void main(String[] args) {
		ConfigurableApplicationContext applicationContext=new ClassPathXmlApplicationContext("applicationContext.xml");
		ProductRepositoryImp productRepository=applicationContext.getBean("productRepositoryImp",ProductRepositoryImp.class);

		Product product=new Product(1, "Araba", 35000);
		Product product1=new Product(2, "Telefon", 2800);
		Product product2=new Product(3, "TV", 3500);
		
		List<Product> products=new ArrayList<Product>();
		
		products.add(product);
		products.add(product1);
		products.add(product2);
		productRepository.saveBatch(products);
	
	
	
		
		
		applicationContext.close();

	}

}
