package com.opm.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.opm.database.UserTask;

public class UserTaskMapper implements RowMapper<UserTask> {

@Override
public UserTask mapRow(ResultSet rs, int rowNum) throws SQLException {
	UserTask userTask =new UserTask();
	userTask.setProjectId(rs.getInt("projectid"));
	userTask.setTaskId(rs.getInt("taskid"));
	userTask.setUsername(rs.getString("username"));
	return userTask;
}
}