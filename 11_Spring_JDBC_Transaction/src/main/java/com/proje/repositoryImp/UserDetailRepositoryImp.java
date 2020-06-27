package com.proje.repositoryImp;

import java.util.List;

import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcDaoSupport;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.transaction.annotation.Transactional;

import com.proje.ResultSetExtractor.UserDetailResultSetExtractor;
import com.proje.RowMapper.UserDetailRowMapper;
import com.proje.model.UserDetail;
import com.proje.repository.UserDetailRepository;
@Transactional
public class UserDetailRepositoryImp extends NamedParameterJdbcDaoSupport implements UserDetailRepository {

	@Override
	public boolean saveUserDetail(int id, UserDetail userDetail) {
		final String query="insert into user_detail(userDetailID,name,lastname,city) values(:userDetailID,:name,:lastname,:city)";
		final String updateUser="update user set userDetailID=:userDetailID where userID=:userID";
		try {
			SqlParameterSource parameterSource=new MapSqlParameterSource("userDetailID",userDetail.getUserDetailId())
												.addValue("name", userDetail.getName())
												.addValue("lastname", userDetail.getLastName())
												.addValue("city", userDetail.getCity());
			this.getNamedParameterJdbcTemplate().update(query, parameterSource);
			
			SqlParameterSource parameterSource2=new MapSqlParameterSource("userID",id)
								.addValue("userDetailID", userDetail.getUserDetailId());
			this.getNamedParameterJdbcTemplate().update(updateUser, parameterSource2);
			
			System.out.println("UserDetail Kaydetme basarili");
			
		} catch (Exception e) {
			System.out.println("UserDetail Kaydetme hatasi"+e);
			return false;
		}
		return true;
	}

	@Override
	public boolean updateUserDetail(UserDetail userDetail) {
		final String query="update user_detail set name=:name,lastname=:lastname,city=:city where userDetailID=:userDetailID";
		
		try {
			SqlParameterSource parameterSource=new MapSqlParameterSource("name", userDetail.getName())
												.addValue("lastname", userDetail.getLastName())
												.addValue("city", userDetail.getCity())
												.addValue("userDetailID",userDetail.getUserDetailId());
			this.getNamedParameterJdbcTemplate().update(query, parameterSource);
		
			
			System.out.println("UserDetail guncelleme basarili");
			
		} catch (Exception e) {
			System.out.println("UserDetail guncelleme hatasi");
			return false;
		}
		return true;
	}

	@Override
	public UserDetail findUserDetailById(int id) {
		final String query="select* from user_detail where userDetailID=:userDetailID";
		UserDetail userDetail=null;
		try {
			SqlParameterSource parameterSource=new MapSqlParameterSource("userDetailID",id);
			userDetail=this.getNamedParameterJdbcTemplate().query(query, parameterSource, new UserDetailResultSetExtractor());
//			userDetail=this.getNamedParameterJdbcTemplate().queryForObject(query, parameterSource,  new UserDetailRowMapper());
			System.out.println("UserDetail bulma basarili");
			
		} catch (Exception e) {
			System.out.println("UserDetail bulma hatasi");
			return null;
		}
		
		
		return userDetail;
	}

	@Override
	public List<UserDetail> findUserDetais() {
		final String query="select* from user_detail";
		List<UserDetail> userDetails=null;
		try {
			
			userDetails=this.getNamedParameterJdbcTemplate().query(query, new UserDetailRowMapper());
			
			System.out.println("UserDetail bulma basarili");
			
		} catch (Exception e) {
			System.out.println("UserDetail bulma hatasi");
			return null;
		}
		
		
		return userDetails;
	}

}
