package com.opm.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.opm.database.Complain;

public class ComplainMapper implements RowMapper<Complain> {

@Override
public Complain mapRow(ResultSet rs, int rowNum) throws SQLException {
	
	Complain complain = new Complain();
	complain.setUsername(rs.getString("username"));
	complain.setComplain(rs.getString("complain"));
	complain.setStatus(rs.getString("status"));
	return complain;
}
}