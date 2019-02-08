package com.opm.service;
import java.util.List;
import javax.sql.DataSource;

public interface LoginDAO {


	  
	  // set database connection
	  public void setDataSource(DataSource ds);
	  
	  // create a new user record in the users table
	  public void create(String username, String password, String name, String email, String company);
	  
	  // validate user
	  public boolean validateUser(String username,String password);
	  
}
