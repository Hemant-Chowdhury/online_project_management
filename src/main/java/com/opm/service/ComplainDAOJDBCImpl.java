package com.opm.service;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

import com.opm.database.Complain;
import com.opm.mapper.ComplainMapper;

public class ComplainDAOJDBCImpl implements ComplainDAO{

	private DataSource dataSource;
	private JdbcTemplate jdbcTemplate;
	@Override
	public void setDataSource(DataSource ds) {
		dataSource = ds;
		jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public void addComplain(Complain complain) {
		String sql = "insert into complain(username,complain) value(?, ?)";
		jdbcTemplate.update(sql,complain.getUsername(),complain.getComplain());
	}

	@Override
	public List<Complain> getComplains(String username) {
		String sql = "select * from complain where username =?";
		List<Complain> complain = jdbcTemplate.query(sql, new Object[] {username}, new ComplainMapper());
		return complain;
	}

	@Override
	public List<Complain> getAllComplains() {
		String sql = "select * from complain";
		List<Complain> complain = jdbcTemplate.query(sql, new ComplainMapper());
		return complain;
	}

	@Override
	public void changeStatus(Complain complain) {
		String sql ="update complain set status = ? where username =? and complain = ?";
		jdbcTemplate.update(sql, complain.getStatus(),complain.getUsername(),complain.getComplain());
	}

}
