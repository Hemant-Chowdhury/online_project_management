package com.opm.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.opm.database.Task;

public class TaskMapper implements RowMapper<Task> {

@Override
public Task mapRow(ResultSet rs, int rowNum) throws SQLException {
	Task task =new Task();
	task.setTaskId(rs.getInt("taskid"));
	task.setTaskName(rs.getString("taskname"));
	task.setDescription(rs.getString("description"));
	task.setStartDate(rs.getDate("startdate"));
	task.setEndDate(rs.getDate("enddate"));
	task.setStatus(rs.getString("status"));
	task.setMilestoneId(rs.getInt("milestoneid"));
	task.setTimestamp(rs.getTimestamp("timestamp"));
	return task;
}
}