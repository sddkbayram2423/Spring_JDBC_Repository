package com.proje.repositoryImp;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcDaoSupport;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.proje.RowMapper.UserRowMapper;
import com.proje.model.User;
import com.proje.model.UserDetail;
import com.proje.repository.UserRepository;
@Transactional
public class UserRepositoryImp extends NamedParameterJdbcDaoSupport implements UserRepository{

	@Override
	@Transactional(isolation=Isolation.READ_COMMITTED,propagation=Propagation.REQUIRED,timeout=3,rollbackFor=RuntimeException.class)
	public boolean saveUser(User user) {
		final String query="insert into User(userID,name,password,personelNumber) values(:userID,:name,:password,:personelNumber)";
		try {
			SqlParameterSource parameterSource=new MapSqlParameterSource("userID",user.getUserId())
								.addValue("name", user.getName())
								.addValue("password", user.getPassword())
								.addValue("personelNumber", user.getPersonelNumber());
			
			
			this.getNamedParameterJdbcTemplate().update(query, parameterSource);
			System.out.println("User baþarýlý bir þekilde kaydeildi");
		} catch (Exception e) {
			System.out.println("User kaydetme hatasý: "+e);
			return false;
		}	
		return true;
	}

	@Override
	public boolean updateUser(User user) {
		final String query="update User set name=:name ,password=:password ,personelNumber=:personelNumber where userID=:userID";
		try {
			SqlParameterSource parameterSource=new MapSqlParameterSource("name", user.getName())
								.addValue("password", user.getPassword())
								.addValue("userID",user.getUserId())
								.addValue("personelNumber", user.getPersonelNumber());
			
			
			this.getNamedParameterJdbcTemplate().update(query, parameterSource);
			System.out.println("User baþarýlý bir þekilde güncellendi");
		} catch (Exception e) {
			System.out.println("User güncelleme hatasý: "+e);
			return false;
		}	
		return true;
	}

	@Override
	public boolean deleteUserById(int id) {
		final String finUserId="select userDetailID from user where userID=:userID";
		final String deleteUserQuery="delete from User where userID=:userID";
		final String deleteUserDetailQuery="delete from user_detail where userDetailID=:userDetailID";
		try {
			SqlParameterSource parameterSource=new MapSqlParameterSource("userID",id);
			Integer userDetailID=this.getNamedParameterJdbcTemplate().query(finUserId, parameterSource, new ResultSetExtractor<Integer>() {

				@Override
				public Integer extractData(ResultSet rs) throws SQLException, DataAccessException {
					Integer integer=null;
					if(rs.next()) {
						integer=rs.getInt("userDetailID");
					}
					return integer;
				}
			});
			
			SqlParameterSource parameterSource1=new MapSqlParameterSource("userID",id);
			this.getNamedParameterJdbcTemplate().update(deleteUserQuery, parameterSource1);
			
		
			SqlParameterSource parameterSource3=new MapSqlParameterSource("userDetailID",userDetailID.intValue());
			this.getNamedParameterJdbcTemplate().update(deleteUserDetailQuery, parameterSource3);
			
			
			System.out.println("User baþarýlý bir þekilde silindi");
		} catch (Exception e) {
			System.out.println("User silme hatasý: "+e);
			return false;
		}	
		return true;
	}

	@Override
	@Transactional(readOnly=true)
	public User findUserById(int id) {
		final String query="select* from User where userID=:userID";
		User user=null;
		try {
			SqlParameterSource parameterSource=new MapSqlParameterSource("userID",id);
	
			user=this.getNamedParameterJdbcTemplate().queryForObject(query, parameterSource, new UserRowMapper());
			System.out.println("User baþarýlý bir þekilde bulundu");
		} catch (Exception e) {
			System.out.println("User bulma hatasý: "+e);
			return null;
		}	
		return user;
	}

	@Override	
	@Transactional(readOnly=true)
	public User findUserDetaisById(int id) {
		
		final String findUserId="select *from user u left join user_detail ud on(u.userDetailID=ud.userDetailID)  where userID=:userID";
		User user=null;
	
		try {
			SqlParameterSource parameterSource=new MapSqlParameterSource("userID",id);
			user=this.getNamedParameterJdbcTemplate().query(findUserId,parameterSource, new ResultSetExtractor<User>() {

				@Override
				public User extractData(ResultSet rs) throws SQLException, DataAccessException {
					User user1=null;
					if(rs.next()) {
						
						user1=new User(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4));
						user1.setUserDetail(new UserDetail(rs.getInt("userDetailID"), rs.getString("name"), rs.getString("lastname"), rs.getString("city")));
					
					}
					return user1;
				}	
				
			} );
			
			System.out.println("User bulma baþarýlý: ");
		} catch (Exception e) {
			System.out.println("User bulma hatasý: "+e);
			return null;
		}
		return user;
	}

	@Override
	@Transactional(readOnly=true)
	public List<User> findUsers() {
		final String query="select* from User";
		List<User> users=null;
		try {
				
			users=this.getNamedParameterJdbcTemplate().query(query, new UserRowMapper());
			System.out.println("User listeleme baþarýlý");
		} catch (Exception e) {
			System.out.println("User listeleme hatasý: "+e);
			return null;
		}	
		
		
		return users;
	}

}
