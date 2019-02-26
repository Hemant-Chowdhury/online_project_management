package com.opm.service;

import java.sql.Timestamp;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

import com.opm.database.TaskFeed;
import com.opm.mapper.TaskFeedMapper;

public class TaskFeedDAOJDBCImpl implements TaskFeedDAO{
	
	@Autowired
	private UserDAOJDBCImpl userJBDC;
	@Autowired
	private ProjectDAOJDBCImpl projectJDBC;
	@Autowired
	private MilestoneDAOJDBCImpl milestoneJDBC;
	@Autowired
	private TaskDAOJDBCImpl taskJDBC;
	
	private DataSource dataSource;
	private JdbcTemplate jdbcTemplate;
	
	private String getTaskName(int taskId) {
		int milestoneId = taskJDBC.getMilestoneId(taskId);
		int projectId = milestoneJDBC.getProjectId(milestoneId);
		String taskName = taskJDBC.getTask(taskId).getTaskName()+"(Milestone: "+milestoneJDBC.getMilestone(milestoneId).getMilestoneName()+";Project: "+projectJDBC.getProject(projectId).getProjectName()+")";
		return taskName;
	}
	
	private String getName(String username) {
		return userJBDC.getUser(username).getName();
	}
	
	private String getLoggedInUserName() {
		Object principal = SecurityContextHolder.getContext()
				.getAuthentication().getPrincipal();

		if (principal instanceof UserDetails)
			return ((UserDetails) principal).getUsername();

		return principal.toString();
	}
	
	@Override
	public void setDataSource(DataSource ds) {
		dataSource = ds;
		jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public void addParticipantFeed(int taskId, String added_Participant) {
		String comment=getName(added_Participant)+" added in the Task "+getTaskName(taskId)+" by "+getName(getLoggedInUserName());
		String sql = "insert into taskfeed(taskId, comment) value(?, ?)";
		jdbcTemplate.update(sql, taskId, comment);
	}

	@Override
	public void removeParticipantFeed(int taskId, String removed_Participant) {
		String comment=getName(removed_Participant)+" removed from the Task "+getTaskName(taskId)+" by "+getName(getLoggedInUserName());
		String sql = "insert into taskfeed(taskId, comment) value(?, ?)";
		jdbcTemplate.update(sql, taskId, comment);
	}

	@Override
	public void chatFeed(int taskId) {
		String comment=getName(getLoggedInUserName())+ "added a comment in the Task "+getTaskName(taskId) ;
		String sql = "insert into taskfeed(taskId, comment) value(?, ?)";
		jdbcTemplate.update(sql, taskId, comment);
	}

	@Override
	public void addFileFeed(int taskId, String filename) {
		String comment=filename+" was added in the Task "+getTaskName(taskId)+" by "+getName(getLoggedInUserName());
		String sql = "insert into taskfeed(taskId, comment) value(?, ?)";
		jdbcTemplate.update(sql, taskId, comment);
	}

	@Override
	public void removeFileFeed(int taskId, String filename) {
		String comment=filename+" was deleted from the Task "+getTaskName(taskId)+" by "+getName(getLoggedInUserName());
		String sql = "insert into taskfeed(taskId, comment) value(?, ?)";
		jdbcTemplate.update(sql, taskId, comment);
	}

	@Override
	public void changeStatusFeed(int taskId, String status) {
		String comment=getName(getLoggedInUserName())+ "marked Task "+getTaskName(taskId)+" as "+status ;
		String sql = "insert into taskfeed(taskId, comment) value(?, ?)";
		jdbcTemplate.update(sql, taskId, comment);
	}

	@Override
	public void changeDependencyFeed(int taskId, String status) {
		String comment=getName(getLoggedInUserName())+" "+status+" dependency in Task "+getTaskName(taskId);
		String sql = "insert into taskfeed(taskId, comment) value(?, ?)";
		jdbcTemplate.update(sql, taskId, comment);
	}

	@Override
	public List<TaskFeed> getTaskFeeds(int taskId) {
		String sql = "select * from taskfeed where taskid = ?";
		List<TaskFeed> taskFeed = jdbcTemplate.query(sql, new Object[] {taskId}, new TaskFeedMapper());
		return taskFeed;
	}

	@Override
	public List<TaskFeed> getNotifiedFeeds(int taskId, Timestamp timestamp) {
		String sql = "select * from taskfeed where taskid = ? and timestamp> ?";
		List<TaskFeed> taskFeed = jdbcTemplate.query(sql, new Object[] {taskId, timestamp}, new TaskFeedMapper());
		return taskFeed;
	}

}
