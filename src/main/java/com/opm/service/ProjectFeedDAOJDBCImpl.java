package com.opm.service;


import java.sql.Timestamp;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

import com.opm.database.ProjectFeed;
import com.opm.mapper.ProjectFeedMapper;


public class ProjectFeedDAOJDBCImpl implements ProjectFeedDAO{

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
	
	private int getProjectId(int milestoneId) {
		int projectId = milestoneJDBC.getProjectId(milestoneId);
		return projectId;
	}
	
	private int getProjectIdForTask(int taskId) {
		int milestoneId = taskJDBC.getMilestoneId(taskId);
		int projectId = milestoneJDBC.getProjectId(milestoneId);
		return projectId;
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
	public void createProjectFeed(int projectId) {
		String comment = "Project "+projectJDBC.getProject(projectId).getProjectName()+"created by "+getName(getLoggedInUserName());
		String sql = "insert into projectfeed(projectid,comment) value(?, ?)";
		jdbcTemplate.update(sql, projectId, comment);
	}

	@Override
	public void addParticipantFeed(int projectId,String added_Participant) {
			String comment = getName(added_Participant)+" added in the Project "+projectJDBC.getProject(projectId).getProjectName()+" by "+getName(getLoggedInUserName());
			String sql = "insert into projectfeed(projectid,comment) value(?, ?)";
			jdbcTemplate.update(sql, projectId, comment);
	}

	@Override
	public void chatFeed(int projectId) {
			String comment =getName(getLoggedInUserName())+" added a comment in Project "+projectJDBC.getProject(projectId).getProjectName();
			String sql = "insert into projectfeed(projectid,comment) value(?, ?)";
			jdbcTemplate.update(sql, projectId, comment);
	}

	@Override
	public void createMilestoneFeed(int milestoneId) {
			String comment = getName(getLoggedInUserName())+" created Milestone "+milestoneJDBC.getMilestone(milestoneId).getMilestoneName()+" in the Project "+projectJDBC.getProject(getProjectId(milestoneId)).getProjectName();
			String sql = "insert into projectfeed(projectid,comment) value(?, ?)";
			jdbcTemplate.update(sql, getProjectId(milestoneId), comment);
	}

	@Override
	public void deleteMilestoneFeed(int milestoneId) {
		String comment = getName(getLoggedInUserName())+" deleted Milestone "+milestoneJDBC.getMilestone(milestoneId).getMilestoneName()+" in the Project "+projectJDBC.getProject(getProjectId(milestoneId)).getProjectName();
		String sql = "insert into projectfeed(projectid,comment) value(?, ?)";
		jdbcTemplate.update(sql, getProjectId(milestoneId), comment);
	}

	@Override
	public void removeParticipantFeed(int projectId,String removed_Participant) {
		String comment = getName(removed_Participant)+" removed from Project "+projectJDBC.getProject(projectId).getProjectName()+" by "+getName(getLoggedInUserName());
		String sql = "insert into projectfeed(projectid,comment) value(?, ?)";
		jdbcTemplate.update(sql, projectId, comment);
		
	}
	
	@Override
	public void createTaskFeed(int taskId) {
		String comment="Task "+getTaskName(taskId)+" created by "+getName(getLoggedInUserName());
		String sql = "insert into projectfeed(projectId, comment) value(?, ?)";
		jdbcTemplate.update(sql, getProjectIdForTask(taskId), comment);
	}

	@Override
	public void deleteTaskFeed(int taskId) {
		String comment="Task "+getTaskName(taskId)+" deleted by "+getName(getLoggedInUserName());
		String sql = "insert into projectfeed(projectId, comment) value(?, ?)";
		jdbcTemplate.update(sql, getProjectIdForTask(taskId), comment);
	}

	@Override
	public List<ProjectFeed> getProjectFeeds(int projectId) {
		String sql = "select * from projectfeed where projectid = ?";
		List<ProjectFeed> projectFeed = jdbcTemplate.query(sql, new Object[] {projectId}, new ProjectFeedMapper());
		return projectFeed;
	}

	@Override
	public List<ProjectFeed> getNotifiedFeeds(int projectId, Timestamp timestamp) {
		String sql = "select * from projectfeed where projectid = ? and timestamp> ?";
		List<ProjectFeed> projectFeed = jdbcTemplate.query(sql, new Object[] {projectId, timestamp}, new ProjectFeedMapper());
		return projectFeed;
	}

}
