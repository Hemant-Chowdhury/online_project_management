package com.opm.database;

import java.sql.Timestamp;

public class TaskFeed {
	private int taskId;
	private Timestamp timestamp;
	private String comment;
	public TaskFeed() {
		super();
		// TODO Auto-generated constructor stub
	}
	public TaskFeed(int taskId, Timestamp timestamp, String comment) {
		super();
		this.taskId = taskId;
		this.timestamp = timestamp;
		this.comment = comment;
	}
	public int getTaskId() {
		return taskId;
	}
	public void setTaskId(int taskId) {
		this.taskId = taskId;
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
