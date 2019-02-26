package com.opm.service;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import com.opm.database.Project;
import com.opm.database.ProjectChat;
import com.opm.database.User;
import com.opm.database.UserProject;
import com.opm.mapper.ProjectChatMapper;
import com.opm.mapper.ProjectMapper;
import com.opm.mapper.UserMapper;
import com.opm.mapper.UserProjectMapper;


public class ProjectDAOJDBCImpl implements ProjectDAO {

	@Autowired
	private UserDAOJDBCImpl userJDBC;
	@Autowired
	private ProjectFeedDAOJDBCImpl projectFeedJDBC;
	private DataSource dataSource;
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public void setDataSource(DataSource ds) {
		dataSource = ds;
		jdbcTemplate = new JdbcTemplate(dataSource);

	}
	@Override
	public Project getProject(int projectId) {
		String sql = "select * from project where projectid = ?";
		Project project = jdbcTemplate.queryForObject(sql, new Object[] {projectId}, new ProjectMapper());
		return project;
	}
	@Override
	public List<User> getParticipants(int projectId) {
		String sql="select * from userproject where projectId = ?";
		List<UserProject> userProject= jdbcTemplate.query(sql,new Object[] {projectId},new UserProjectMapper());
		List<User> user = new ArrayList<User>();
		for(UserProject up: userProject)
		{
			User u = userJDBC.getUser(up.getUsername());
			u.setCompany(up.getType()); 	//Temporary setter call to specify type (Bad Practice!!)
			user.add(u);	
		}
		return user;
	}
	
	@Override
	public List<ProjectChat> getChat(int projectId) {
		String sql= "select * from projectchat where projectid = ?";
		List<ProjectChat> projectChat = jdbcTemplate.query(sql, new Object[] {projectId}, new ProjectChatMapper());
		return projectChat;
	}
	@Override
	public void sendMessage(ProjectChat pc) {
		String sql="insert into projectchat (projectid,username,message) value (?,?,?)";
		jdbcTemplate.update(sql,pc.getProjectId(),pc.getUsername(),pc.getMessage());
		projectFeedJDBC.chatFeed(pc.getProjectId());
	}
	@Override
	public void addParticipant(UserProject up) {
		String sql = "insert into userproject (username,projectid,type) value (?,?,?)";
		jdbcTemplate.update(sql, up.getUsername(),up.getProjectId(),up.getType());
		projectFeedJDBC.addParticipantFeed(up.getProjectId(), up.getUsername());
	}
	@Override
	public void removeParticipant(String username, int projectId) {
		projectFeedJDBC.removeParticipantFeed(projectId, username);
		String sql = "delete from userproject where username = ? and projectid = ?";
		jdbcTemplate.update(sql,username,projectId);
	}
}

