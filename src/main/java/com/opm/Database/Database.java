package com.opm.Database;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Database {
	 
  public static Statement establishConnection(String table) throws ClassNotFoundException, SQLException {
        // 1. Register JDBC Driver
        Class.forName("com.mysql.jdbc.Driver");
        
        // 2. Create Connection Object
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost/"+table,"root", "");  
        
        // 3. Create Statement object and Execute a Query
        Statement stmt = con.createStatement(); 
         
        return stmt;
    }

}