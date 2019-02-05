package com.opm.loginDatabase;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class LoginMapper implements RowMapper<LoginData> {

@Override
public LoginData mapRow(ResultSet rs, int rowNum) throws SQLException {
	LoginData user =new LoginData();
	user.setUsername(rs.getString("username"));
	user.setPassword(rs.getString("password"));
	return user;
}
}