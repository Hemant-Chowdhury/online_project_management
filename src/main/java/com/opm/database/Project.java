package com.opm.database;

import java.sql.Timestamp;

public class Project {
	private int projectId;
	private String projectName;
	private String owner;
	private String description;
	private Timestamp timestamp;
	public Project() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public Project(int projectId, String projectName, String owner, String description, Timestamp timestamp) {
		super();
		this.projectId = projectId;
		this.projectName = projectName;
		this.owner = owner;
		this.description = description;
		this.timestamp = timestamp;
	}


	public Timestamp getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Timestamp timestamp) {
		this.timestamp = timestamp;
	}

	public int getProjectId() {
		return projectId;
	}
	public void setProjectId(int projectId) {
		this.projectId = projectId;
	}
	public String getProjectName() {
		return projectName;
	}
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}
	public String getOwner() {
		return owner;
	}
	public void setOwner(String owner) {
		this.owner = owner;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	
}
