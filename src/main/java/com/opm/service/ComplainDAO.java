package com.opm.service;
import com.opm.database.*;
import java.util.List;
import javax.sql.DataSource;

public interface ComplainDAO {


	  
	  // set database connection
	  public void setDataSource(DataSource ds);
	  
	  // add complain
	  public void addComplain(Complain complain);
	  
	  // get complains
	  public List<Complain> getComplains(String username);
	  
	  //get all complains
	  public List<Complain> getAllComplains();
	  
	  // change status
	  public void changeStatus(Complain complain);
}
