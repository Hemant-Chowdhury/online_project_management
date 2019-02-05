package com.opm.loginDatabase;

import java.util.List;
import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

public class LoginDataDAOJDBCImpl implements LoginDataDAO {

  private DataSource dataSource;
  private JdbcTemplate jdbcTemplate;
  
  @Override
  public void setDataSource(DataSource ds) {
    dataSource = ds;
    jdbcTemplate = new JdbcTemplate(dataSource);
  }
  
  @Override
  public void create(String username, String password) {
    String sql = "insert into logindata (username, password) values (?, ?)";
    jdbcTemplate.update(sql, username, password);
  }
  
  @Override
  public boolean validateUser(String username, String password) {
	 try {
    String sql = "select * from logindata where username = ?";
    LoginData user =jdbcTemplate.queryForObject(sql, new Object[]{username}, new LoginMapper());
    System.out.println("user : "+user.getUsername()+" "+user.getPassword()+" "+password);
    if(password.equals(user.getPassword()))
    return true;
    return false;
	 }
	 catch(Exception e)
	 {
		 return false;
	 }
  }
  
  @Override
  public List<LoginData> listUsers() {
    String sql = "select * from logindata";
    List<LoginData> users = jdbcTemplate.query(sql, new LoginMapper());
    return users;
  }
  
  @Override
  public String updatePassword(String username, String oldPassword, String newPassword){
    if(validateUser(username,oldPassword))
    {
    	String sql = "update Logindata set password = ? where username = ?";
        jdbcTemplate.update(sql, username, newPassword);
    	return "Password updated";
    }
    return "Password updation failed";
  }
  


  @Override
  public void delete(String username) {
	  String sql = "delete from Logindata where username = ?";
	  jdbcTemplate.update(sql, username);
	  System.out.println("Deleted Record with username = " + username );
  }
}