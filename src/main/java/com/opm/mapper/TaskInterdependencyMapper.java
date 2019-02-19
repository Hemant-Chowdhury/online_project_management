package com.opm.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.opm.database.TaskInterdependency;

public class TaskInterdependencyMapper implements RowMapper<TaskInterdependency> {

	@Override
	public TaskInterdependency mapRow(ResultSet rs, int rowNum) throws SQLException {
		TaskInterdependency taskInterdependency = new TaskInterdependency();
		taskInterdependency.setParentTask(rs.getInt("parenttask"));
		taskInterdependency.setChildTask(rs.getInt("childtask"));
		return taskInterdependency;
	}

}
