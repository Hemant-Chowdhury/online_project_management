package com.opm.userDatabase;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class UserMapper implements RowMapper<User> {

@Override
public User mapRow(ResultSet rs, int rowNum) throws SQLException {
	User user =new User();
	user.setUsername(rs.getString("username"));
	user.setPassword(rs.getString("password"));
	user.setName(rs.getString("name"));
	user.setEmail(rs.getString("email"));
	user.setImage(rs.getString("image"));
	user.setCompany(rs.getString("company"));
	return user;
}
}