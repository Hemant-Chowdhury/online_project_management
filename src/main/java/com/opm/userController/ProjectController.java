package com.opm.userController;

import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;

import com.opm.CustomSort.SortByTime;
import com.opm.database.Project;
import com.opm.database.ProjectChat;
import com.opm.database.User;
import com.opm.database.UserProject;
import com.opm.html.Methods;
import com.opm.service.ProjectDAOJDBCImpl;
import com.opm.service.UserDAOJDBCImpl;

@Controller
public class ProjectController {
	
	
	@Autowired
	private ProjectDAOJDBCImpl projectJDBC;
	@Autowired
	private UserDAOJDBCImpl userJDBC;
	
	private String getLoggedInUserName() {
		Object principal = SecurityContextHolder.getContext()
				.getAuthentication().getPrincipal();

		if (principal instanceof UserDetails)
			return ((UserDetails) principal).getUsername();

		return principal.toString();
	}
	
	private int getSessionProjectId()
	{
		int projectId=(int)RequestContextHolder.currentRequestAttributes().getAttribute("projectId", RequestAttributes.SCOPE_SESSION);
		return projectId;
	}
	
	private String getChatList(List<ProjectChat> chat)
	{
		String view="";
		for(ProjectChat pc:chat) {
			if(pc.getUsername().contains(getLoggedInUserName()))
				view+=Methods.getChat(pc, userJDBC.getUser(pc.getUsername()), 0);
			else
				view+=Methods.getChat(pc, userJDBC.getUser(pc.getUsername()), 1);
		}
		return view;
	}
	
	@RequestMapping(value="/project")
	private String projectPage(ModelMap model)
	{
		List<User> participants = projectJDBC.getParticipants(getSessionProjectId());
		model.addAttribute("participants",participants);
		Project project = projectJDBC.getProject(getSessionProjectId());
		model.addAttribute("project",project);
		
		List<ProjectChat> projectChat = projectJDBC.getChat(getSessionProjectId());
		projectChat.sort(new SortByTime());
		String chat = getChatList(projectChat);
		model.addAttribute("listChat", chat);
		return "project";
	}
	
	@RequestMapping(value="/project/addParticipant")
	private String addParticipant(ModelMap model,HttpSession session,@RequestParam(value="username") String username, @RequestParam(value="type") String type ) {
		userJDBC.getUser(username);
		UserProject up = new UserProject(username,(int)session.getAttribute("projectId"),type);
		projectJDBC.addParticipant(up);
		return "redirect:/project?projectId="+session.getAttribute("projectId");
	}
	
	@RequestMapping(value="/project/removeParticipant")
	private String removeParticipant(ModelMap model,@RequestParam(value="username") String username) {
		projectJDBC.removeParticipant(username, getSessionProjectId());
		return "redirect:/project";
	}
	
	@RequestMapping(value="/project/sendMessage")
	private String sendMessage(ModelMap model,@RequestParam(value="message") String message) {
		ProjectChat pc = new ProjectChat(getSessionProjectId(),getLoggedInUserName(),message);
		System.out.println("okk okk");
		projectJDBC.sendMessage(pc);
		return "redirect:/project";
	}
	
	@ResponseBody
	@RequestMapping(value="/project/getChat")
	private String getChat(ModelMap model) {
		List<ProjectChat> projectChat = projectJDBC.getChat(getSessionProjectId());
		projectChat.sort(new SortByTime());
		String chat = getChatList(projectChat);
		return chat;
	}
	
}
