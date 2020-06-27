package com.proje.test;

import java.util.List;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.proje.model.Personel;
import com.proje.personelrepository.PersonelRepository;
import com.proje.personelrepositoryImp.PersonelRepositoryImp;

public class Test {

	public static void main(String[] args) {
		ConfigurableApplicationContext applicationContext=new ClassPathXmlApplicationContext("applicationContext.xml");
		PersonelRepository personelRepository=applicationContext.getBean("personelRepositoryImp",PersonelRepositoryImp.class);
	
		
	List<Personel> personels=personelRepository.listPersonels();
	for(Personel personel:personels) {
		System.out.println(personel);
	}
		
		applicationContext.close();
	}
	public static void personelTest() {
		
		ConfigurableApplicationContext applicationContext=new ClassPathXmlApplicationContext("applicationContext.xml");
		PersonelRepository personelRepository=applicationContext.getBean("personelRepositoryÝmp",PersonelRepositoryImp.class);
		
		Personel personel=new Personel(1, "Ali", "Kara", "12131");
		Personel personel2=new Personel(2, "Nazlý", "Atak", "54456");
		Personel personel3=new Personel(3, "Bahar", "Baran", "787545");
		Personel personel4=new Personel(4, "Zahide", "Yaþar", "78978");
		Personel personel5=new Personel(5, "Onur", "Baran", "34454");
		Personel personel6=new Personel(6, "Zahide", "Sergen", "21458");
		Personel personel7=new Personel(7, "Zahide", "Peltek", "354555");
		
		personelRepository.savePersonel(personel);
		personelRepository.savePersonel(personel2);
		personelRepository.savePersonel(personel3);
		personelRepository.savePersonel(personel4);
		personelRepository.savePersonel(personel5);
		personelRepository.savePersonel(personel6);
		personelRepository.savePersonel(personel7);
		
		System.out.println(personelRepository.deletePersonelByID(1));
		
		List<Personel> personels=personelRepository.listPersonels();
		for(Personel personell:personels) {
			System.out.println(personell);
		}
			
		
		applicationContext.close();
	}

}
