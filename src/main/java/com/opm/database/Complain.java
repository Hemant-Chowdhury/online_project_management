package com.opm.database;

public class Complain {
	
	private String username;
	private String complain;
	private String status;
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getComplain() {
		return complain;
	}
	public void setComplain(String complain) {
		this.complain = complain;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Complain(String username, String complain, String status) {
		super();
		this.username = username;
		this.complain = complain;
		this.status = status;
	}
	public Complain() {
		super();
		// TODO Auto-generated constructor stub
	}
	

}
