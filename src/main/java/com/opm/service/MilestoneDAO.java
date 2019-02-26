package com.opm.service;
import com.opm.database.*;
import java.util.List;
import javax.sql.DataSource;

public interface MilestoneDAO {


	  
	  // set database connection
	  public void setDataSource(DataSource ds);
	  
	  //get milestone complete
	  public Milestone getMilestone(int milestoneId);
	  
	  // list Milestones
	  public List<Milestone> getMilestones(int projectId);
	  
	  // list Tasks
	  public List<Task> getTasks(int milestoneId);
	  
	  // add Milestone
	  public void addMilestone(Milestone milestone);
	  
	  // add Task
	  public void addTask(Task task);
	    
	  // remove Milestone
	  public void removeMilestone(int milestoneId);
	  
	  // remove Task
	  public void removeTask(int taskId);
	  
	  //get ProjectId
	  public int getProjectId(int milestoneId);
}
