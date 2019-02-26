package com.opm.service;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

import com.opm.database.Meeting;
import com.opm.mapper.MeetingMapper;

public class MeetingDAOJDBCImpl implements MeetingDAO{
	
	private DataSource dataSource;
	private JdbcTemplate jdbcTemplate;
	@Override
	public void setDataSource(DataSource ds) {
		dataSource = ds;
		jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public void addMeeting(Meeting meeting) {
		String sql = "insert into meeting(projectid,topic,conclusion,date) value(?, ?, ?, ?)";
		jdbcTemplate.update(sql, meeting.getProjectId(), meeting.getTopic(), meeting.getConclusion(), meeting.getDate());
	}

	@Override
	public List<Meeting> getMeetings(int projectId) {
		String sql = "select * from meeting where projectid =?";
		List<Meeting> meeting = jdbcTemplate.query(sql, new Object[] {projectId}, new MeetingMapper());
		return meeting;
	}

	@Override
	public void deleteMeeting(Meeting meeting) {
		String sql = "delete from meeting where projectid = ? and topic = ?";
		jdbcTemplate.update(sql, meeting.getProjectId(), meeting.getTopic());
	}

}
