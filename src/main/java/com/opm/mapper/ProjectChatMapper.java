package com.opm.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.opm.database.ProjectChat;

public class ProjectChatMapper implements RowMapper<ProjectChat> {

@Override
public ProjectChat mapRow(ResultSet rs, int rowNum) throws SQLException {
	ProjectChat projectChat =new ProjectChat();
	projectChat.setTimestamp(rs.getTimestamp("timestamp"));
	projectChat.setProjectId(rs.getInt("projectid"));
	projectChat.setUsername(rs.getString("username"));
	projectChat.setMessage(rs.getString("message"));
	return projectChat;
}
}