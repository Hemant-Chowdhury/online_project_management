package com.opm.database;

public class TaskInterdependency {
	private int parentTask;
	private int childTask;
	public int getParentTask() {
		return parentTask;
	}
	public TaskInterdependency() {
		super();
		// TODO Auto-generated constructor stub
	}
	public TaskInterdependency(int parentTask, int childTask) {
		super();
		this.parentTask = parentTask;
		this.childTask = childTask;
	}
	public void setParentTask(int parentTask) {
		this.parentTask = parentTask;
	}
	public int getChildTask() {
		return childTask;
	}
	public void setChildTask(int childTask) {
		this.childTask = childTask;
	}
}
