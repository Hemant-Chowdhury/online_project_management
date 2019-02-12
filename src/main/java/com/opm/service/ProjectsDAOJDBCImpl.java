package com.opm.service;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

import com.opm.database.Project;
import com.opm.database.UserProject;
import com.opm.mapper.ProjectMapper;
import com.opm.mapper.UserProjectMapper;


public class ProjectsDAOJDBCImpl implements ProjectsDAO {

	private DataSource dataSource;
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public void setDataSource(DataSource ds) {
		dataSource = ds;
		jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	@Override
	public void addProject(Project project) {
		String sql="insert into projects (projectname,owner,description,) value (?, ?, ?)";
		jdbcTemplate.update(sql, project.getProjectName(),project.getOwner(),project.getDescription());
	}

	@Override
	public List<Project> getProjectsOwned(String username) {
		String sql = "select * from project where owner = ?";
		List<Project> project = jdbcTemplate.query(sql,new Object[] {username} ,new ProjectMapper());
		return project;
	}
	
	@Override
	public List<Project> getProjectsManaged(String username) {
		String sql = "select * from userproject where username = ? and type=?";
		List<UserProject> user = jdbcTemplate.query(sql,new Object[] {username,"Manager"},new UserProjectMapper());
		sql = "select * from project where projectid = ?";
		List<Project> project = null;
		for(UserProject up:user) {
			project.add(jdbcTemplate.queryForObject(sql, new Object[]{up.getProjectId()}, new ProjectMapper()));
		}
		return project;
	}

	@Override
	public List<Project> getProjectDeveloped(String username) {
		String sql = "select * from userproject where username = ? and type=?";
		List<UserProject> user = jdbcTemplate.query(sql,new Object[] {username,"Developer"},new UserProjectMapper());
		sql = "select * from project where projectid = ?";
		List<Project> project = null;
		for(UserProject up:user) {
			project.add(jdbcTemplate.queryForObject(sql, new Object[]{up.getProjectId()}, new ProjectMapper()));
		}
		return project;
	}

	@Override
	public void deleteProject(int projectId) {
		String sql = "delete from project where projectid = ?";
		jdbcTemplate.update(sql, projectId);
	}

	

}

