package com.proje.test;

import java.util.List;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.proje.model.Personel;
import com.proje.personelrepository.PersonelRepository;
import com.proje.personelrepositoryImp.PersonelRepositoryImp;

public class MainTest {

	public static void main(String[] args) {
		ConfigurableApplicationContext applicationContext=new ClassPathXmlApplicationContext("applicationContext.xml");
		PersonelRepository personelRepository=applicationContext.getBean("personelRepository�mp",PersonelRepositoryImp.class);
		personelRepository.deletePersonelByID(10);
		
		applicationContext.close();
	}
	public static void personelTest() {
		
		ConfigurableApplicationContext applicationContext=new ClassPathXmlApplicationContext("applicationContext.xml");
		PersonelRepository personelRepository=applicationContext.getBean("personelRepository�mp",PersonelRepositoryImp.class);
		
		Personel personel=new Personel(1, "Ali", "Kara", "12131");
		Personel personel2=new Personel(2, "Nazl�", "Atak", "54456");
		Personel personel3=new Personel(3, "Bahar", "Baran", "787545");
		Personel personel4=new Personel(4, "Orhan", "Yasar", "78978");
		Personel personel5=new Personel(5, "Onur", "Baran", "34454");
		Personel personel6=new Personel(6, "Kamil", "Sergen", "21458");
		Personel personel7=new Personel(7, "Polat", "Peltek", "354555");
		
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
