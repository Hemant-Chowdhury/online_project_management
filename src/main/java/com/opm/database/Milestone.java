package com.opm.database;

import java.sql.Timestamp;

public class Milestone {
	private int milestoneId;
	private String milestoneName;
	private int projectId;
	private Timestamp timestamp;
	public Milestone() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Milestone(int milestoneId, String milestoneName, int projectId,Timestamp timestamp) {
		super();
		this.milestoneId = milestoneId;
		this.milestoneName = milestoneName;
		this.projectId = projectId;
		this.timestamp = timestamp;
	}
	public Timestamp getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(Timestamp timestamp) {
		this.timestamp = timestamp;
	}
	public int getMilestoneId() {
		return milestoneId;
	}
	public void setMilestoneId(int milestoneId) {
		this.milestoneId = milestoneId;
	}
	public String getMilestoneName() {
		return milestoneName;
	}
	public void setMilestoneName(String milestoneName) {
		this.milestoneName = milestoneName;
	}
	public int getProjectId() {
		return projectId;
	}
	public void setProjectId(int projectId) {
		this.projectId = projectId;
	}
	
}
