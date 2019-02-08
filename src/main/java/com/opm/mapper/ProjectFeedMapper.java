package com.opm.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.opm.database.ProjectFeed;

public class ProjectFeedMapper implements RowMapper<ProjectFeed> {

@Override
public ProjectFeed mapRow(ResultSet rs, int rowNum) throws SQLException {
	ProjectFeed projectFeed =new ProjectFeed();
	projectFeed.setTimestamp(rs.getTimestamp("timestamp"));
	projectFeed.setProjectId(rs.getInt("projectid"));
	projectFeed.setComment(rs.getString("comment"));
	return projectFeed;
}
}