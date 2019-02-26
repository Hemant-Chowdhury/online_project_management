package com.opm.service;

import java.sql.Timestamp;
import java.util.List;

import javax.sql.DataSource;

import com.opm.database.ProjectFeed;
import com.opm.database.TaskFeed;

public interface TaskFeedDAO {
	// set database connection
	  public void setDataSource(DataSource ds);
	  
	  //Feed for Participant added
	  public void addParticipantFeed(int taskId,String added_Participant);
	  
	  //Feed for removing participant
	  public void removeParticipantFeed(int taskId,String removed_Participant);
	  
	  //Feed for chat
	  public void chatFeed(int taskId);
	  
	  //Feed for file adding
	  public void addFileFeed(int taskId, String filename);
	  
	  //Feed to remove file
	  public void removeFileFeed(int taskId, String filename);
	  
	  //Feed for chat
	  public void changeStatusFeed(int taskId, String status);
	  
	  //Feed for chat
	  public void changeDependencyFeed(int taskId, String status);
	  
	  //Get feeds
	  public List<TaskFeed> getTaskFeeds(int taskId);
	  
	  //get notified Feed
	  public List<TaskFeed> getNotifiedFeeds(int taskId, Timestamp timestamp);
}
