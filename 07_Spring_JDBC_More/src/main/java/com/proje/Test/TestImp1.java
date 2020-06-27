package com.proje.Test;

import java.util.List;


import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.proje.model.Product;

import com.proje.repositoryImp1.ProductRepositoryImp1;

public class TestImp1 {

	public static void main(String[] args) {
		ConfigurableApplicationContext applicationContext=new ClassPathXmlApplicationContext("applicationContext.xml");
		ProductRepositoryImp1 productRepository=applicationContext.getBean("productRepositoryImp1",ProductRepositoryImp1.class);

	
		System.out.println(productRepository.findByProductID(2));
		List<Product> products=productRepository.findProductsList();
		
		for(Product product:products) {
			System.out.println(product);
		}
		applicationContext.close();

	}

}
