package com.opm.service;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

import com.opm.database.Task;
import com.opm.mapper.TaskMapper;


public class TasksDAOJDBCImpl implements TasksDAO {

	private DataSource dataSource;
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public void setDataSource(DataSource ds) {
		dataSource = ds;
		jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public Task getTask(int taskId) {
		String sql = "select * from task where taskid = ?";
		Task task = jdbcTemplate.queryForObject(sql, new Object[] {taskId}, new TaskMapper());
		return task;
	}

	@Override
	public List<Task> getTasks(int milestoneId) {
		String sql = "select * from task where milestoneid = ? ";
		List<Task> task = jdbcTemplate.query(sql, new Object[] {milestoneId}, new TaskMapper());
		return task;
	}

	@Override
	public void addTask(Task task) {
		String sql = "insert into task(taskname, startdate, enddate, description, milestoneid) value(?,?,?,?,?)";
		jdbcTemplate.update(sql, task.getTaskName(),task.getStartDate(),task.getEndDate(),task.getDescription(),task.getMilestoneId());
		
	}

	@Override
	public void removeTask(int taskId) {
		String sql = "delete from task where taskid = ? ";
		jdbcTemplate.update(sql, taskId);
		
	}

}

