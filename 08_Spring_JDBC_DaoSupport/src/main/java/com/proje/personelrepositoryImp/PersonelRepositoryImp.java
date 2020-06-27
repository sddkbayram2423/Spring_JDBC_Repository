package com.proje.personelrepositoryImp;

import java.util.List;

import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import com.proje.model.Personel;
import com.proje.personelrepository.PersonelRepository;
import com.proje.rowmapper.PersonelRowMapper;
@Repository
public class PersonelRepositoryImp extends JdbcDaoSupport implements PersonelRepository {

	@Override
	public boolean createTable() {
		String sorgu="create table Personel(personelID int not null primary key, Name varchar(30),LastName varchar(30),personelNumber varchar(30))";
		try {
			this.getJdbcTemplate().execute(sorgu);
			System.out.println("TABLO olusturma basarili");
		} catch (Exception e) {
			System.out.println("TABLO olusturma hatasi");
			return false;
		}
		return true;
	}

	@Override
	public Personel savePersonel(Personel personel) {
		String sorgu="insert into Personel(personelID , Name ,LastName ,personelNumber) values (?,?,?,?)";
		
		try {
			this.getJdbcTemplate().update(sorgu, new Object[] {personel.getPersonelID(),personel.getName(),personel.getLastName(),personel.getPersonelNumber()});
			System.out.println("Personel kaydetme basarili");
		} catch (Exception e) {
			System.out.println("Personel kaydetme hatasi: "+e);
			return null;
		}
		return personel;
	}

	@Override
	public Personel upDatePersonel(Personel personel) {
		String sorgu="update Personel set Name=? ,LastName=? ,personelNumber=? where personelID=? ";
		try {
			this.getJdbcTemplate().update(sorgu, new Object[] {personel.getName(),personel.getLastName(),personel.getPersonelNumber(),personel.getPersonelID()});
			System.out.println("Personel güncelleme basarili");
		} catch (Exception e) {
			System.out.println("Personel güncelleme hatasi: "+e);
			return null;
		}
		return personel;
	}

	@Override
	public boolean deletePersonelByID(int ID) {
		String sorgu="delete from personel where personelID=?";
		
		try {
			this.getJdbcTemplate().update(sorgu, new Object[] {ID});
			
			System.out.println("Pesonel silme basarili");
		} catch (Exception e) {
			System.out.println("Pesonel silme hatasi :"+e);
			return false;
		}
		return true;
	}

	@Override
	public Personel findPersonelByID(int ID) {
		String sorgu="select * from personel where personelID=?";
		Personel personel=null;
		try {
			personel=this.getJdbcTemplate().queryForObject(sorgu,new Object[] {ID},new PersonelRowMapper());
			System.out.println(ID+" 'IDli personel bulma basarili");
		} catch (Exception e) {
			System.out.println(ID+" 'IDli personel bulma hatasi : "+e);
			return null;
		}
		
	return personel;
	}

	@Override
	public List<Personel> listPersonels() {
		String sorgu="select *from personel";
		List<Personel> personels=null;
		try {
			personels=this.getJdbcTemplate().query(sorgu, new PersonelRowMapper());
			
			System.out.println("Personel listeleme basarili");
		} catch (Exception e) {
			System.out.println("Personel listeleme hatasi :"+e);
			return null;
		}
		return personels;
	}

	@Override
	public List<Personel> listPersonelsByName(String name) {
		String sorgu="select *from personel where name=?";
		List<Personel> personels=null;
		try {
			personels=this.getJdbcTemplate().query(sorgu,new Object[] {name} ,new PersonelRowMapper());
			
			System.out.println("Personel listeleme basarili");
		} catch (Exception e) {
			System.out.println("Personel listeleme hatasi :"+e);
			return null;
		}
		return personels;
	}

}
