package com.opm.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.opm.database.TaskChat;

public class TaskChatMapper implements RowMapper<TaskChat> {

@Override
public TaskChat mapRow(ResultSet rs, int rowNum) throws SQLException {
	TaskChat taskChat =new TaskChat();
	taskChat.setTimestamp(rs.getTimestamp("timestamp"));
	taskChat.setTaskId(rs.getInt("taskid"));
	taskChat.setUsername(rs.getString("username"));
	taskChat.setMessage(rs.getString("message"));
	return taskChat;
}
}