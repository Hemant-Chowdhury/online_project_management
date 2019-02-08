package com.opm.database;

public class UserProject {
	
	private String username;
	private int projectId;
	private String type;
	public UserProject() {
		super();
		// TODO Auto-generated constructor stub
	}
	public UserProject(String username, int projectId, String type) {
		super();
		this.username = username;
		this.projectId = projectId;
		this.type = type;
	}
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public int getProjectId() {
		return projectId;
	}
	public void setProjectId(int projectId) {
		this.projectId = projectId;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
	

}
