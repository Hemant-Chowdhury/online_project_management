package com.opm.service;
import com.opm.database.*;
import java.util.List;
import javax.sql.DataSource;

public interface ProjectDAO {


	  
	  // set database connection
	  public void setDataSource(DataSource ds);
	  
	  //get project complete
	  public Project getProject(int projectId);
	  
	  // list participants
	  public List<User> getParticipants(int projectId);
	  
	  // get chat of project
	  public List<ProjectChat> getChat(int projectId);
	  
	  // send message
	  public void sendMessage(ProjectChat pc);
	  
	  //add participant
	  public void addParticipant(UserProject up);
	  
	  // remove participant
	  public void removeParticipant(String username,int projectId);
	  
	  
}
