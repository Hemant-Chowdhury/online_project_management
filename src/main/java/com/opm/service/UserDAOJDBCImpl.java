package com.opm.service;

import java.sql.Timestamp;
import java.util.List;
import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.opm.database.User;
import com.opm.mapper.UserMapper;


public class UserDAOJDBCImpl implements UserDAO {

	private DataSource dataSource;
	private JdbcTemplate jdbcTemplate;

	@Override
	public void setDataSource(DataSource ds) {
		dataSource = ds;
		jdbcTemplate = new JdbcTemplate(dataSource);
	}

	
	@Override
	public void updateProfile(String username, String name, String email, String company) {
		String sql = "update user set name = ?, email = ?, company = ? where username = ?";
		jdbcTemplate.update(sql,name,email,company,username);
	}

	@Override
	public User getUser(String username) {
		String sql = "select * from user where username = ?";
		User user =jdbcTemplate.queryForObject(sql, new Object[]{username}, new UserMapper());
		return user;
	}


	@Override
	public List<User> listUsers() {
		String sql = "select * from user";
		List<User> users = jdbcTemplate.query(sql, new UserMapper());
		return users;
	}
	
	 
	  @Override
	  public boolean validateUser(String username, String password) {
		 try {
	    String sql = "select * from user where username = ?";
	    User user =jdbcTemplate.queryForObject(sql, new Object[]{username}, new UserMapper());
	    System.out.println("user : "+user.getUsername()+" "+user.getPassword()+" "+password);
	    if(password.equals(user.getPassword()))
	    return true;
	    return false;
		 }
		 catch(Exception e)
		 {
			 return false;
		 }
	  }

	@Override
	public String updatePassword(String username, String oldPassword, String newPassword){
		if(validateUser(username,oldPassword))
		{
			String sql = "update user set password = ? where username = ?";
			jdbcTemplate.update(sql, newPassword, username);
			return "Password updated";
		}
		return "Password updation failed";
	}



	@Override
	public void delete(String username) {
		String sql = "delete from user where username = ?";
		jdbcTemplate.update(sql, username);
		System.out.println("Deleted Record with username = " + username );
	}



	@Override
	public void updateImage(String username, String image) {
		System.out.println(image);
		String sql = "update user set image = ? where username = ?";
		jdbcTemplate.update(sql,image,username);
	}


	@Override
	public Timestamp getLastChecked(String username) {
		String sql = "select * from user where username = ? ";
		User user = jdbcTemplate.queryForObject(sql, new Object[] {username},new UserMapper());
		return user.getLastChecked();
	}


	@Override
	public void setLastChecked(String username, Timestamp lastChecked) {
		String sql = "update user set lastchecked = ? where username =?";
		jdbcTemplate.update(sql,lastChecked,username);
		System.out.println("updated last checked"+ lastChecked);
	}
}