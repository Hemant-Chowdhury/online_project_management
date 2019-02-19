package com.opm.service;

import java.util.List;

import javax.sql.DataSource;

import com.opm.database.Project;
import com.opm.database.Task;

public interface HomeDAO {
	// set database connection
		  public void setDataSource(DataSource ds);
	//get project list
		  public List<Project> getProjects(String username);
	//get tasks list
		  public List<Task> getTasks(String username);
}
