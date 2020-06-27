package com.proje.personelrepositoryImp;

import java.util.List;




import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcDaoSupport;

import org.springframework.jdbc.core.namedparam.SqlParameterSource;



import com.proje.model.Personel;
import com.proje.personelrepository.PersonelRepository;
import com.proje.rowmapper.PersonelRowMapper;

public class PersonelRepositoryImp extends NamedParameterJdbcDaoSupport implements PersonelRepository {


	@Override
	public Personel savePersonel(Personel personel) {
		String sorgu="insert into Personel(personelID , Name ,LastName ,personelNumber) values (:personelID , :Name ,:LastName ,:personelNumber)";
		
		try {
			SqlParameterSource parameterSource=new MapSqlParameterSource("personelID", personel.getPersonelID())
					.addValue("Name", personel.getName())
					.addValue("LastName", personel.getLastName())
					.addValue("personelNumber", personel.getPersonelNumber());
			this.getNamedParameterJdbcTemplate().update(sorgu, parameterSource);
			
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
			this.getNamedParameterJdbcTemplate().update(sorgu, parameterSource);
			System.out.println("Personel guncelleme basarili");
		} catch (Exception e) {
			System.out.println("Personel guncelleme hatasi: "+e);
			return null;
		}
		return personel;
	}

	@Override
	public boolean deletePersonelByID(int ID) {
		String sorgu="delete from personel where personelID=:personelID";
		
		try {
			SqlParameterSource parameterSource=new MapSqlParameterSource("personelID",ID);		
			this.getNamedParameterJdbcTemplate().update(sorgu, parameterSource);
			
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
			personel=this.getNamedParameterJdbcTemplate().queryForObject(sorgu, parameterSource, new PersonelRowMapper());
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
			personels=this.getNamedParameterJdbcTemplate().query(sorgu, new PersonelRowMapper());
			
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
			personels=this.getNamedParameterJdbcTemplate().query(sorgu ,parameterSource,new PersonelRowMapper());
			
			System.out.println("Personel listeleme basarili");
		} catch (Exception e) {
			System.out.println("Personel listeleme hatasi :"+e);
			return null;
		}
		return personels;
	}

	
	
	
	

}
