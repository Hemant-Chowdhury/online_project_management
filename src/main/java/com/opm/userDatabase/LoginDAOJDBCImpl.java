package com.opm.userDatabase;

import java.util.List;
import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

public class LoginDAOJDBCImpl implements LoginDAO {

  private DataSource dataSource;
  private JdbcTemplate jdbcTemplate;
  
  @Override
  public void setDataSource(DataSource ds) {
    dataSource = ds;
    jdbcTemplate = new JdbcTemplate(dataSource);
  }
  
  @Override
  public void create(String username, String password, String name,String email, String company) {
    String sql = "insert into user (username, password,name,email,company) values (?, ?, ?, ?, ?)";
    jdbcTemplate.update(sql, username, password, name, email, company);
  }
  
  @Override
  public boolean validateUser(String username, String password) {
	 try {
    String sql = "select * from user where username = ?";
    User user =jdbcTemplate.queryForObject(sql, new Object[]{username}, new UserMapper());
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
  
}