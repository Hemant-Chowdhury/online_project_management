package com.opm.database;

public class File {
	private String fileName;
	private int taskId;
	
	public File() {
		super();
		// TODO Auto-generated constructor stub
	}

	public File(String fileName, int taskId) {
		super();
		this.fileName = fileName;
		this.taskId = taskId;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public int getTaskId() {
		return taskId;
	}

	public void setTaskId(int taskId) {
		this.taskId = taskId;
	}

}
