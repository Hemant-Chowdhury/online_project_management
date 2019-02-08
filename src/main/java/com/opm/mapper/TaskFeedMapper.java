package com.opm.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.opm.database.TaskFeed;

public class TaskFeedMapper implements RowMapper<TaskFeed> {

@Override
public TaskFeed mapRow(ResultSet rs, int rowNum) throws SQLException {
	TaskFeed taskFeed =new TaskFeed();
	taskFeed.setTaskId(rs.getInt("taskid"));
	taskFeed.setTimestamp(rs.getTimestamp("timestamp"));
	taskFeed.setComment(rs.getString("comment"));
	return taskFeed;
}
}