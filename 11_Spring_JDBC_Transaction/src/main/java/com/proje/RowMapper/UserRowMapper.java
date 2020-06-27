package com.proje.RowMapper;

import java.sql.ResultSet;

import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.proje.model.User;


public class UserRowMapper implements RowMapper<User>{


	@Override
	public User mapRow(ResultSet rs, int rowNum) throws SQLException {

		return new User(rs.getInt("userID"), rs.getString("name"), rs.getString("password"), rs.getString("personelNumber"));

}
}