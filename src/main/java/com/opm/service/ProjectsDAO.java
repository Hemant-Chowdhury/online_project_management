package com.opm.service;
import com.opm.database.*;
import java.util.List;
import javax.sql.DataSource;

public interface ProjectsDAO {


	  
	  // set database connection
	  public void setDataSource(DataSource ds);
	  
	  // create project
	  public void addProject(Project project);
	  
	  // projects owned by the user
	  public List<Project> getProjectsOwned(String username);
	  
	  // projects managed by the user
	  public List<Project> getProjectsManaged(String username);
	  
	  //projects developed by the user
	  public List<Project> getProjectDeveloped(String username);
	  
	  // delete project
	  public void deleteProject(int projectId);
	  
	  
}
