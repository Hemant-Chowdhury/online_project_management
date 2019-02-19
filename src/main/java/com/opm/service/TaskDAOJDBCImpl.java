package com.opm.service;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import com.mysql.fabric.xmlrpc.base.Array;
import com.opm.database.File;
import com.opm.database.Task;
import com.opm.database.TaskChat;
import com.opm.database.TaskInterdependency;
import com.opm.database.User;
import com.opm.database.UserProject;
import com.opm.database.UserTask;
import com.opm.mapper.FileMapper;
import com.opm.mapper.TaskChatMapper;
import com.opm.mapper.TaskInterdependencyMapper;
import com.opm.mapper.TaskMapper;
import com.opm.mapper.UserProjectMapper;
import com.opm.mapper.UserTaskMapper;


public class TaskDAOJDBCImpl implements TaskDAO {

	private DataSource dataSource;
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	private UserDAOJDBCImpl userJDBC;
	
	@Override
	public void setDataSource(DataSource ds) {
		dataSource = ds;
		jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public Task getTask(int taskId) {
		String sql = "select * from task where taskid = ?";
		Task task = jdbcTemplate.queryForObject(sql, new Object[] {taskId}, new TaskMapper());
		return task;
	}

	@Override
	public List<Task> getTasks(int milestoneId) {
		String sql = "select * from task where milestoneid = ? ";
		List<Task> task = jdbcTemplate.query(sql, new Object[] {milestoneId}, new TaskMapper());
		return task;
	}

	

	@Override
	public List<User> getParticipants(int taskId) {
		String sql = "select * from usertask where taskid = ?";
		List<UserTask> userTask = jdbcTemplate.query(sql, new Object[] {taskId}, new UserTaskMapper());
		List<User> user = new ArrayList<User>();
		for(UserTask ut : userTask) {
			user.add(userJDBC.getUser(ut.getUsername()));
		}
		return user;
	}
	
	@Override
	public List<User> getNewParticipants(int projectId, int taskId) {
		String sql = "select * from userproject where projectid = ?";
		List<UserProject> userProject = jdbcTemplate.query(sql, new Object[] {projectId}, new UserProjectMapper());
		List<User> user = new ArrayList<User>();
		for(UserProject up : userProject) {
			sql = "select * from usertask where username = ? and taskid = ?";
			UserTask userTask = null;
			try {
				userTask= jdbcTemplate.queryForObject(sql, new Object[] {up.getUsername(),taskId}, new UserTaskMapper());
			}
			catch(Exception e)
			{
				sql = "select * from user where username = ?";
				user.add(userJDBC.getUser(up.getUsername()));
			}
		}
		return user;
	}
	
	
	@Override
	public void changeStatus(int taskId, String status) {
		String sql ="update task set status = ? where taskid = ?";
		jdbcTemplate.update(sql, status, taskId);
	}


	@Override
	public List<TaskChat> getChats(int taskId) {
		String sql = "select * from taskchat where taskid = ?";
		List<TaskChat> taskChat = jdbcTemplate.query(sql, new Object[] {taskId}, new TaskChatMapper());
		return taskChat;
	}

	@Override
	public void addParticipant(String username,int taskId, int projectId) {
		String sql = "insert into usertask(username,taskid,projectId) value(?, ?, ?)";
		jdbcTemplate.update(sql, username, taskId, projectId);	
	}

	@Override
	public void removeParticipant(String username,int taskId) {
		String sql = "delete from usertask where username = ? and taskid = ?";
		jdbcTemplate.update(sql, username, taskId);
	}

	@Override
	public void addFile(String filename, int taskId) {
		String sql = "insert into file(filename,taskid) value(?, ?)";
		jdbcTemplate.update(sql,filename,taskId);
		
	}

	@Override
	public List<File> getFiles(int taskId) {
		String sql = "select * from file where taskid = ?";
		List<File> files = jdbcTemplate.query(sql, new Object[] {taskId}, new FileMapper());
		return files;
	}

	@Override
	public List<TaskChat> getChat(int taskId) {
		String sql = "select * from taskchat where taskid = ?";
		List<TaskChat> taskChat = jdbcTemplate.query(sql, new Object[] {taskId}, new TaskChatMapper());
		return taskChat;
	}

	@Override
	public void sendMessage(TaskChat tc) {
		String sql = "insert into taskchat(taskid,username,message) value(?, ?, ?)";
		jdbcTemplate.update(sql, tc.getTaskId(),tc.getUsername(),tc.getMessage());
	}

	@Override
	public List<Task> getDependencies(int taskId) {
		String sql ="select * from taskinterdependency where childtask = ?";
		List<TaskInterdependency> taskInterdependency = jdbcTemplate.query(sql, new Object[] {taskId}, new TaskInterdependencyMapper());
		List<Task> task = new ArrayList<Task>();
		for(TaskInterdependency ti: taskInterdependency) {
			task.add(getTask(ti.getParentTask()));
		}
		return task;
	}

	@Override
	public List<Task> getNewDependencies(int projectId, int taskId) {
		String sql = "select t.* from task as t, milestone as m where m.projectid = ? and m.milestoneid=t.milestoneid";
		List<Task> listTask = jdbcTemplate.query(sql,new Object[] {projectId}, new TaskMapper());
		List<Task> task = new ArrayList<Task>();
		Task ts = getTask(taskId);
		for(Task t: listTask) {
			if(t.getEndDate().getTime()-ts.getStartDate().getTime()<=0) {
				task.add(t);
			}
		}
		return task;
	}

	@Override
	public void addDependency(int parentTaskId, int childTaskId) {
		String sql = "insert into taskinterdependency(parenttask,childtask) value (?, ?)";
		jdbcTemplate.update(sql, parentTaskId,childTaskId);
	}

	@Override
	public void removeDependency(int parentTaskId, int childTaskId) {
		String sql = "delete from taskinterdependency where parenttask = ? and childtask = ?";
		jdbcTemplate.update(sql, parentTaskId,childTaskId);
	}
}

