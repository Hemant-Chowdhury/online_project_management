package com.opm.service;
import com.opm.database.*;
import java.util.List;
import javax.sql.DataSource;

public interface TaskDAO {


	  
	  // set database connection
	  public void setDataSource(DataSource ds);
	  
	  //get task complete
	  public Task getTask(int taskId);
	  
	  // list tasks
	  public List<Task> getTasks(int milestoneId);
	  
	  //list Participants
	  public List<User> getParticipants(int taskId);
	  
	  //list addable participants
	  public List<User> getNewParticipants(int projectId, int taskId);
	  
	  //Change Status
	  public void changeStatus(int taskId, String status);
	  
	  // get chat
	  public List<TaskChat> getChats(int taskId);
	  
	  //add Participants
	  public void addParticipant(String username, int taskId, int projectId);
	  
	  //remove Participants
	  public void removeParticipant(String username, int taskId);
	  
	  //add file
	  public void addFile(String filename, int taskId);
	  
	  //fetch files
	  public List<File> getFiles(int taskId);
	  
	  //get Chat
	  public List<TaskChat> getChat(int taskId);
	  
	  //send message
	  public void sendMessage(TaskChat tc);
	  
	  //list Dependencies
	  public List<Task> getDependencies(int taskId);
	  
	  //list addable Dependencies
	  public List<Task> getNewDependencies(int projectId, int taskId);
	  
	  //add Dependency
	  public void addDependency(int parentTaskId, int childTaskId);
	  
	  //remove Dependency
	  public void removeDependency(int parentTaskId, int childTaskId);
	  
}
