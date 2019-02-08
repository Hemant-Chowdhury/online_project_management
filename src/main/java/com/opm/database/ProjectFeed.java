package com.opm.database;

import java.sql.Timestamp;

public class ProjectFeed {
	private int projectId;
	private Timestamp timestamp;
	private String comment;
	public ProjectFeed() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ProjectFeed(int projectId, Timestamp timestamp, String comment) {
		super();
		this.projectId = projectId;
		this.timestamp = timestamp;
		this.comment = comment;
	}
	public int getProjectId() {
		return projectId;
	}
	public void setProjectId(int projectId) {
		this.projectId = projectId;
	}
	public Timestamp getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(Timestamp datetime) {
		this.timestamp = datetime;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	
}
