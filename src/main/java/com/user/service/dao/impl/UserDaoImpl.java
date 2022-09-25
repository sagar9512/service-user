package com.user.service.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.user.service.dao.UserDao;
import com.user.service.model.User;

@Repository
public class UserDaoImpl implements UserDao {
	
	@Autowired
	JdbcTemplate jdbcTemplate;

	@Override
	public Integer saveUser(User user) {
		return jdbcTemplate.update("INSERT INTO user (email,first_name,last_name,password) values (?,?,?,?)",new Object[] {user.getEmail(),user.getFirstName(),user.getLastName(),user.getPassword()});
	}

	@SuppressWarnings("deprecation")
	@Override
	public User fetchUserById(int id) {
		// TODO Auto-generated method stub
		return jdbcTemplate.queryForObject("SELECT * FROM USER WHERE USER_ID = ?",new Object[] {id},new RowMapper<User>() {

			@Override
			public User mapRow(ResultSet rs, int rowNum) throws SQLException {
				User user=new User();
				user.setEmail(rs.getString("email"));
				user.setFirstName(rs.getString("first_name"));
				user.setLastName(rs.getString("last_name"));
				user.setPassword(rs.getString("password"));
				user.setUserId(rs.getInt("user_id"));
				return user;
			}
			
		});
	}

	@Override
	public User updateUserDetails(Long id, User user) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteUser(Long id) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<User> fetchAllUsers() {
		// TODO Auto-generated method stub
		return null;
	}

}
