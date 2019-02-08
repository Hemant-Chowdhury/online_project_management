package com.opm.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.opm.database.Project;

public class ProjectMapper implements RowMapper<Project> {

	@Override
	public Project mapRow(ResultSet rs, int rowNum) throws SQLException {
		Project project =new  Project();
		project.setProjectId(rs.getInt("projectid"));
		project.setProjectName(rs.getString("projectname"));
		project.setOwner(rs.getString("owner"));
		project.setDescription(rs.getString("description"));
		project.setTimestamp(rs.getTimestamp("timestamp"));
		return project;
	}
}