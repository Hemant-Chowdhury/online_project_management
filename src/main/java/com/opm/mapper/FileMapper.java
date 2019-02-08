package com.opm.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.opm.database.File;

public class FileMapper implements RowMapper<File> {

@Override
public File mapRow(ResultSet rs, int rowNum) throws SQLException {
	File file =new File();
	file.setTaskId(rs.getInt("taskid"));
	file.setFileName(rs.getString("filename"));
	return file;
}
}