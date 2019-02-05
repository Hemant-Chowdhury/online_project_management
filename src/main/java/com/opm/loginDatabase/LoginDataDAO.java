package com.opm.loginDatabase;
import java.util.List;
import javax.sql.DataSource;

public interface LoginDataDAO {


	  
	  // set database connection
	  public void setDataSource(DataSource ds);
	  
	  // create a new user record in the users table
	  public void create(String username, String password);
	  
	  // get a user with the passed id
	  public boolean validateUser(String username,String password);
	  
	  // get all the users from the users table
	  public List<LoginData> listUsers();
	  
	  // update a user's email given given the user's id
	  public String updatePassword(String username,String oldPassword,String newPassword);
	  
	  // delete a user record from the users table given the user's id
	  public void delete(String username);
}
