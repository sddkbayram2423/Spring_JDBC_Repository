package com.proje.ResultSetExtractor;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import com.proje.model.User;
import com.proje.model.UserDetail;

public class UserResultSetExtractor implements ResultSetExtractor<User>{

	@Override
	public User extractData(ResultSet rs) throws SQLException, DataAccessException {
		User user1=null;
		if(rs.next()) {
			
			user1=new User(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4));
			user1.setUserDetail(new UserDetail(rs.getInt("userDetailID"), rs.getString("name"), rs.getString("lastname"), rs.getString("city")));
		}
		return user1;
	}

}
