package com.opm.database;

import java.sql.Timestamp;

public class TaskChat {
	
	private int taskId;
	private String username;
	private Timestamp timestamp;
	private String message;
	public TaskChat() {
		super();
		// TODO Auto-generated constructor stub
	}
	public TaskChat(int taskId, String username, Timestamp timestamp, String message) {
		super();
		this.taskId = taskId;
		this.username = username;
		this.timestamp = timestamp;
		this.message = message;
	}
	public int getTaskId() {
		return taskId;
	}
	public void setTaskId(int taskId) {
		this.taskId = taskId;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public Timestamp getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(Timestamp datetime) {
		this.timestamp = datetime;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
}
