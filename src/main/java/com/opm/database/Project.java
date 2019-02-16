package com.opm.database;

import java.sql.Timestamp;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonView;
import com.opm.jasonView.Views;

public class Project {
	private int projectId;
	private String projectName;
	private String owner;
	private String description;
	private Timestamp timestamp;
	
	
	public Project() {
	}
	
	
	public Project(int projectId, String projectName, String owner, String description) {
		super();
		this.projectId = projectId;
		this.projectName = projectName;
		this.owner = owner;
		this.description = description;
		this.timestamp.setTime(this.timestamp.getTime());
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
