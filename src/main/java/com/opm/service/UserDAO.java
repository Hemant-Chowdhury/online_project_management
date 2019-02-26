package com.opm.service;
import java.sql.Timestamp;
import java.util.List;
import javax.sql.DataSource;

import com.opm.database.User;

public interface UserDAO {


	  
	  // set database connection
	  public void setDataSource(DataSource ds);
	  
	  // create a new user record in the users table
	  public void updateProfile(String username, String name, String email, String company);
	  
	  // get user
	  public User getUser(String username);
	  
	  // get all the users from the users table
	  public List<User> listUsers();
	  
	  // validate user
	  public boolean validateUser(String username,String password);
	  
	  // update a user's email given given the user's id
	  public String updatePassword(String username,String oldPassword,String newPassword);
	  
	  // delete a user record from the users table given the user's id
	  public void delete(String username);
	 
	  //Updating image source
	  public void updateImage(String username,String image);
	  
	  //get lastChecked
	  public Timestamp getLastChecked(String username);
	  
	  //set LastChecked
	  public void setLastChecked(String username, Timestamp lastChecked);

}
