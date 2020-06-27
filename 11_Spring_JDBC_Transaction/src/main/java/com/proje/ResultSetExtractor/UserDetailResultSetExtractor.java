package com.proje.ResultSetExtractor;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import com.proje.model.UserDetail;

public class UserDetailResultSetExtractor implements ResultSetExtractor<UserDetail> {

	@Override
	public UserDetail extractData(ResultSet rs) throws SQLException, DataAccessException {
		UserDetail detail=null;
		if(rs.next()) {
			detail=new UserDetail(rs.getInt(1), rs.getString(2),rs.getString(3), rs.getString(4));
		}
		
		return detail;
	}

}
