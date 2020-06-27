package com.proje.personelrepository;

import java.util.List;

import com.proje.model.Personel;


public interface PersonelRepository{
	
	boolean createTable();
	Personel savePersonel(Personel personel);
	Personel upDatePersonel(Personel personel);
	boolean deletePersonelByID(int ID);
	Personel findPersonelByID(int ID);
	List<Personel> listPersonels();
	List<Personel> listPersonelsByName(String name);

}
