package com.proje.Test;

import java.util.List;


import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.proje.appCofig.AppConfig;
import com.proje.model.Product;
import com.proje.repositoryImp.ProductRepositoryImp;

public class TestConfig {

	public static void main(String[] args) {
		ConfigurableApplicationContext applicationContext=new AnnotationConfigApplicationContext(AppConfig.class);
		ProductRepositoryImp productRepository=applicationContext.getBean("productRepositoryImp",ProductRepositoryImp.class);

		
		System.out.println(productRepository.findByProductID(1));
		List<Product> products=productRepository.findProductsList();
		
		for(Product product:products) {
			System.out.println(product);
		}
		
		
		
		applicationContext.close();

	}

}
