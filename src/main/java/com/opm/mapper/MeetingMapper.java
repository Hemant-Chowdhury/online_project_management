package com.opm.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.opm.database.Meeting;


public class MeetingMapper implements RowMapper<Meeting> {

@Override
public Meeting mapRow(ResultSet rs, int rowNum) throws SQLException {
	
	Meeting meeting = new Meeting();
	meeting.setProjectId(rs.getInt("projectId"));
	meeting.setTopic(rs.getString("topic"));
	meeting.setConclusion(rs.getString("conclusion"));
	meeting.setDate(rs.getDate("date"));
	return meeting;
	
	
}
}