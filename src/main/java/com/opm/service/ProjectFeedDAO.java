package com.opm.service;

import java.sql.Timestamp;
import java.util.List;

import javax.sql.DataSource;

import com.opm.database.ProjectFeed;


public interface ProjectFeedDAO {
	// set database connection
		  public void setDataSource(DataSource ds);
		  
		  //Feed for project created
		  public void createProjectFeed(int projectId);
		  
		  //Feed for Participant added
		  public void addParticipantFeed(int projectId,String added_Participant);
		  
		  //Feed for chat
		  public void chatFeed(int projectId);
		  
		  //Feed for added Milestone
		  public void createMilestoneFeed(int milestoneId);
		  
		  //Feed for deleting milestone
		  public void deleteMilestoneFeed(int milestoneId);
		  
		  //Feed for removing participant
		  public void removeParticipantFeed(int projectId,String removed_Participant);

		  //Feed for creating a task
		  public void createTaskFeed(int taskId);
		  
		  //Feed for deleting a Task
		  public void deleteTaskFeed(int taskId);
		  
		  //get Feed
		  public List<ProjectFeed> getProjectFeeds(int projectId);
		  
		  //get notified Feed
		  public List<ProjectFeed> getNotifiedFeeds(int projectId, Timestamp timestamp);
}
