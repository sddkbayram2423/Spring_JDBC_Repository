package com.proje.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.proje.model.UserDetail;

public class UserDetailRowMapper implements RowMapper<UserDetail> {

	@Override
	public UserDetail mapRow(ResultSet rs, int rowNum) throws SQLException {
		// TODO Auto-generated method stub
		return new UserDetail(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4));
	}

}
