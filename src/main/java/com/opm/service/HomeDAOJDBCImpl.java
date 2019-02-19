package com.opm.service;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

import com.opm.database.Project;
import com.opm.database.Task;
import com.opm.mapper.ProjectMapper;
import com.opm.mapper.TaskMapper;

public class HomeDAOJDBCImpl implements HomeDAO{

	private DataSource dataSource;
	private JdbcTemplate jdbcTemplate;
	  
	  @Override
	  public void setDataSource(DataSource ds) {
	    dataSource = ds;
	    jdbcTemplate = new JdbcTemplate(dataSource);
	  }

	@Override
	public List<Project> getProjects(String username) {
		String sql = "select distinct p.* from userproject as up, project as p where up.username = ? and up.projectId = p.projectId";
		List<Project> projects = jdbcTemplate.query(sql, new Object[] {username}, new ProjectMapper());
		return projects;
	}

	@Override
	public List<Task> getTasks(String username) {
		String sql = "select distinct t.* from usertask as ut, task as t where ut.username = ? and ut.taskId = t.taskId";
		List<Task> tasks = jdbcTemplate.query(sql, new Object[] {username}, new TaskMapper());
		return tasks;
	}

}
