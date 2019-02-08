package com.opm.database;

import java.sql.Timestamp;

public class ProjectChat {
	private int projectId;
	private String username;
	private Timestamp timestamp;
	private String message;
	public ProjectChat() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getProjectId() {
		return projectId;
	}
	public void setProjectId(int projectId) {
		this.projectId = projectId;
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
	public ProjectChat(int projectId, String username, Timestamp timestamp, String message) {
		super();
		this.projectId = projectId;
		this.username = username;
		this.timestamp = timestamp;
		this.message = message;
	}
}
