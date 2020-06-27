package com.proje.personelrepositoryImp;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;

import org.springframework.stereotype.Repository;

import com.proje.model.Personel;
import com.proje.personelrepository.PersonelRepository;
import com.proje.rowmapper.PersonelRowMapper;
@Repository
public class PersonelRepositoryImp implements PersonelRepository {

	
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	@Override
	public boolean createTable() {
//		String sorgu="create table Personel2(personelID int not null primary key, Name varchar(30),LastName varchar(30),personelNumber varchar(30))";
		try {
		
			System.out.println("TABLO olusturma basarili");
		} catch (Exception e) {
			System.out.println("TABLO olusturma hatasi");
			return false;
		}
		return true;
	}

	@Override
	public Personel savePersonel(Personel personel) {
		String sorgu="insert into Personel(personelID , Name ,LastName ,personelNumber) values (:personelID , :Name ,:LastName ,:personelNumber)";
		
		try {
			SqlParameterSource parameterSource=new MapSqlParameterSource("personelID", personel.getPersonelID())
					.addValue("Name", personel.getName())
					.addValue("LastName", personel.getLastName())
					.addValue("personelNumber", personel.getPersonelNumber());
			this.namedParameterJdbcTemplate.update(sorgu, parameterSource);
			
			System.out.println("Personel kaydetme basarli");
		} catch (Exception e) {
			System.out.println("Personel kaydetme hatasi: "+e);
			return null;
		}
		return personel;
	}

	@Override
	public Personel upDatePersonel(Personel personel) {
		String sorgu="update Personel set Name=:Name ,LastName=:LastName ,personelNumber=:personelNumber where personelID=:personelID ";
		try {
			SqlParameterSource parameterSource=new MapSqlParameterSource("Name", personel.getName())
					.addValue("LastName", personel.getLastName())
					.addValue("personelNumber", personel.getPersonelNumber())
					.addValue("personelID", personel.getPersonelID());
			this.namedParameterJdbcTemplate.update(sorgu, parameterSource);
			System.out.println("Personel güncelleme basarili");
		} catch (Exception e) {
			System.out.println("Personel güncelleme hatasi: "+e);
			return null;
		}
		return personel;
	}

	@Override
	public boolean deletePersonelByID(int ID) {
		String sorgu="delete from personel where personelID=:personelID";
		
		try {
			SqlParameterSource parameterSource=new MapSqlParameterSource("personelID",ID);		
			this.namedParameterJdbcTemplate.update(sorgu, parameterSource);
			
			System.out.println("Pesonel silme basarili");
		} catch (Exception e) {
			System.out.println("Pesonel silme hatasi :"+e);
			return false;
		}
		return true;
	}

	@Override
	public Personel findPersonelByID(int ID) {
		String sorgu="select * from personel where personelID=:personelID";
		Personel personel=null;
		try {
			SqlParameterSource parameterSource=new MapSqlParameterSource("personelID",ID);	
			personel=this.namedParameterJdbcTemplate.queryForObject(sorgu, parameterSource, new PersonelRowMapper());
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
			personels=this.namedParameterJdbcTemplate.query(sorgu, new PersonelRowMapper());
			
			System.out.println("Personel listeleme basarili");
		} catch (Exception e) {
			System.out.println("Personel listeleme hatasi :"+e);
			return null;
		}
		return personels;
	}

	@Override
	public List<Personel> listPersonelsByName(String name) {
		String sorgu="select *from personel where name=:name";
		List<Personel> personels=null;
		try {
			SqlParameterSource parameterSource=new MapSqlParameterSource("name",name);	
			personels=this.namedParameterJdbcTemplate.query(sorgu ,parameterSource,new PersonelRowMapper());
			
			System.out.println("Personel listeleme basarili");
		} catch (Exception e) {
			System.out.println("Personel listeleme hatasi :"+e);
			return null;
		}
		return personels;
	}

	
	@Autowired
	public void setDataSource(DataSource dataSource) {
		this.namedParameterJdbcTemplate=new NamedParameterJdbcTemplate(dataSource);
	}
	
	

}
