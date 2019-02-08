package com.opm.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.opm.database.Milestone;


public class MilestoneMapper implements RowMapper<Milestone> {

@Override
public Milestone mapRow(ResultSet rs, int rowNum) throws SQLException {
	Milestone milestone =new Milestone();
	milestone.setMilestoneId(rs.getInt("milestoneid"));
	milestone.setMilestoneName(rs.getString("milestonename"));
	milestone.setProjectId(rs.getInt("projectid"));
	milestone.setTimestamp(rs.getTimestamp("timestamp"));
	return milestone;
}
}