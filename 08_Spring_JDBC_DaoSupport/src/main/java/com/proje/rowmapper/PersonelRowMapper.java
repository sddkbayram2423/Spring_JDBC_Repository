package com.proje.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.proje.model.Personel;

public class PersonelRowMapper implements RowMapper<Personel> {

	@Override
	public Personel mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		return new Personel(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4));
	}

}
