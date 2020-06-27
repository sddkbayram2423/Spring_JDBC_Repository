package com.proje.Test;

import java.util.List;



import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.proje.model.Product;
import com.proje.repository.ProductRepository;

import com.proje.repositoryImp2.ProductRepositoryImp2;

public class TestImp2 {

	public static void main(String[] args) {
		ConfigurableApplicationContext applicationContext=new ClassPathXmlApplicationContext("applicationContext.xml");
		ProductRepository productRepository=applicationContext.getBean("productRepositoryImp2",ProductRepositoryImp2.class);

	
		System.out.println(productRepository.findByProductID(2));
		List<Product> products=productRepository.findProductsList();
		
		for(Product product:products) {
			System.out.println(product);
		}
		applicationContext.close();

	}

}
