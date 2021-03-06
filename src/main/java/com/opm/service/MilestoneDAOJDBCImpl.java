package com.opm.service;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import com.opm.database.Milestone;
import com.opm.database.Task;
import com.opm.mapper.MilestoneMapper;
import com.opm.mapper.TaskMapper;


public class MilestoneDAOJDBCImpl implements MilestoneDAO {
	
	@Autowired
	private ProjectFeedDAOJDBCImpl projectFeedJDBC;
	private DataSource dataSource;
	private JdbcTemplate jdbcTemplate;
	@Override
	public void setDataSource(DataSource ds) {
		dataSource = ds;
		jdbcTemplate = new JdbcTemplate(dataSource);
	}
	@Override
	public Milestone getMilestone(int milestoneId) {
		String sql = "select * from milestone where milestoneid = ?";
		Milestone milestone = jdbcTemplate.queryForObject(sql, new Object[] {milestoneId}, new MilestoneMapper());
		return milestone;
	}
	@Override
	public List<Milestone> getMilestones(int projectId) {
		String sql = "select * from milestone where projectid = ? ";
		List<Milestone> milestone = jdbcTemplate.query(sql, new Object[] {projectId}, new MilestoneMapper());
		return milestone;
	}
	@Override
	public List<Task> getTasks(int milestoneId) {
		String sql = "select * from task where milestoneid = ? ";
		List<Task> task = jdbcTemplate.query(sql, new Object[] {milestoneId}, new TaskMapper());
		return task;
	}
	@Override
	public void addMilestone(Milestone milestone) {
		String sql = "insert into milestone(milestonename, projectid) value (?, ?)";
		jdbcTemplate.update(sql, milestone.getMilestoneName(), milestone.getProjectId());
		projectFeedJDBC.createMilestoneFeed(jdbcTemplate.queryForObject("select MAX(milestoneId) from milestone", Integer.class));
	}
	@Override
	public void addTask(Task task) {
		String sql = "insert into task(taskname, startdate, enddate, description, milestoneid) value(?,?,?,?,?)";
		jdbcTemplate.update(sql, task.getTaskName(),task.getStartDate(),task.getEndDate(),task.getDescription(),task.getMilestoneId());
		projectFeedJDBC.createTaskFeed(jdbcTemplate.queryForObject("select MAX(taskId) from task", Integer.class));
	}
	@Override
	public void removeMilestone(int milestoneId) {
		projectFeedJDBC.deleteMilestoneFeed(milestoneId);
		String sql = "delete from milestone where milestoneid = ?";
		jdbcTemplate.update(sql,milestoneId);
	}
	@Override
	public void removeTask(int taskId) {
		projectFeedJDBC.deleteTaskFeed(taskId);
		String sql = "delete from task where taskid = ? ";
		jdbcTemplate.update(sql, taskId);
	}
	@Override
	public int getProjectId(int milestoneId) {
		String sql = "select * from milestone where milestoneid = ?";
		Milestone mile = jdbcTemplate.queryForObject(sql, new Object[] {milestoneId}, new MilestoneMapper());
		return mile.getProjectId();
	}

}

