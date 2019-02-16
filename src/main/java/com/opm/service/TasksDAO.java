package com.opm.service;
import com.opm.database.*;
import java.util.List;
import javax.sql.DataSource;

public interface TasksDAO {


	  
	  // set database connection
	  public void setDataSource(DataSource ds);
	  
	  //get task complete
	  public Task getTask(int taskId);
	  
	  // list tasks
	  public List<Task> getTasks(int milestoneId);
	  
	  //add task
	  public void addTask(Task task);
	  
	  // remove task
	  public void removeTask(int taskId);
	  
	  
}
