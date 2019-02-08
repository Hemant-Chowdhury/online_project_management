package com.opm.database;

public class UserTask {
	
	private String username;
	private int taskId;
	private int projectId;
	
	public UserTask() {
		super();
		// TODO Auto-generated constructor stub
	}

	public UserTask(String username, int taskId, int projectId) {
		super();
		this.username = username;
		this.taskId = taskId;
		this.projectId = projectId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public int getTaskId() {
		return taskId;
	}

	public void setTaskId(int taskId) {
		this.taskId = taskId;
	}

	public int getProjectId() {
		return projectId;
	}

	public void setProjectId(int projectId) {
		this.projectId = projectId;
	}
	
	
	
	
}
