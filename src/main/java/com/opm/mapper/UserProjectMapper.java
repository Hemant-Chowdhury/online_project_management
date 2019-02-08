package com.opm.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.opm.database.UserProject;

public class UserProjectMapper implements RowMapper<UserProject> {

@Override
public UserProject mapRow(ResultSet rs, int rowNum) throws SQLException {
	UserProject userProject =new UserProject();
	userProject.setProjectId(rs.getInt("projectid"));
	userProject.setType(rs.getString("type"));
	userProject.setUsername(rs.getString("username"));
	return userProject;
}
}