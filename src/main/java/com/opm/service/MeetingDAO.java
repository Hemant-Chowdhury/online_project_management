package com.opm.service;
import com.opm.database.*;
import java.util.List;
import javax.sql.DataSource;

public interface MeetingDAO {


	  
	  // set database connection
	  public void setDataSource(DataSource ds);
	  
	  // create project
	  public void addMeeting(Meeting meeting);
	  
	  // projects owned by the user
	  public List<Meeting> getMeetings(int projectId);
	  
	  // delete project
	  public void deleteMeeting(Meeting meeting);
}
