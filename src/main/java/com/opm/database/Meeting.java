package com.opm.database;

import java.sql.Date;

public class Meeting {
	private int projectId;
	private String topic;
	private String conclusion;
	private Date date;
	public Meeting() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Meeting(int projectId, String topic, String conclusion, Date date) {
		super();
		this.projectId = projectId;
		this.topic = topic;
		this.conclusion = conclusion;
		this.date = date;
	}
	public int getProjectId() {
		return projectId;
	}
	public void setProjectId(int projectId) {
		this.projectId = projectId;
	}
	public String getTopic() {
		return topic;
	}
	public void setTopic(String topic) {
		this.topic = topic;
	}
	public String getConclusion() {
		return conclusion;
	}
	public void setConclusion(String conclusion) {
		this.conclusion = conclusion;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	
}
