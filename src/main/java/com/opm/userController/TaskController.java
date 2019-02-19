package com.opm.userController;


import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;

import com.opm.CustomSort.SortByTimeForTask;
import com.opm.database.File;
import com.opm.database.Milestone;
import com.opm.database.Task;
import com.opm.database.TaskChat;
import com.opm.database.User;
import com.opm.html.Methods;
import com.opm.service.MilestoneDAOJDBCImpl;
import com.opm.service.TaskDAOJDBCImpl;
import com.opm.service.UserDAOJDBCImpl;

@Controller
public class TaskController {
	
	@Autowired
	private TaskDAOJDBCImpl taskJDBC;
	@Autowired
	private MilestoneDAOJDBCImpl milestoneJDBC;
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
	
	private int getSessionTaskId()
	{
		int taskId = (int)RequestContextHolder.currentRequestAttributes().getAttribute("taskId", RequestAttributes.SCOPE_SESSION);
		return taskId;
	}
	
	
	private String getChatList(List<TaskChat> chat)
	{
		String view="";
		for(TaskChat tc:chat) {
			if(tc.getUsername().contains(getLoggedInUserName()))
				view+=Methods.getTaskChat(tc, userJDBC.getUser(tc.getUsername()), 0);
			else
				view+=Methods.getTaskChat(tc, userJDBC.getUser(tc.getUsername()), 1);
		}
		return view;
	}
	
	@RequestMapping(value="/changeTask")
	private String changeTask(ModelMap model, @RequestParam(value="taskId") int taskId,HttpSession session) {
		session.setAttribute("taskId", taskId);
		return "redirect:task";
	}
	
	@RequestMapping(value="/task")
	private String taskPage(ModelMap model) {
		
		//Listing tasks in a particular project
		List<Milestone> listMile = milestoneJDBC.getMilestones(getSessionProjectId());
		List<Task> tasks = new ArrayList<Task>();
		for(Milestone mile : listMile) {
			List<Task> tempTask = milestoneJDBC.getTasks(mile.getMilestoneId());
			tasks.addAll(tempTask);
		}
		model.addAttribute("tasks", tasks);
		
		//Getting already added participants
		List<User> participants = taskJDBC.getParticipants(getSessionTaskId());
		model.addAttribute("participants",participants);
		
		//Adding new participants
		List<User> newParticipants = taskJDBC.getNewParticipants(getSessionProjectId(),getSessionTaskId());
		model.addAttribute("newParticipants", newParticipants);
		
		//Putting current task and milestone object in the model for future use
		Task task =taskJDBC.getTask(getSessionTaskId());
		Milestone milestone = milestoneJDBC.getMilestone(task.getMilestoneId());
		model.addAttribute("task",task);
		model.addAttribute("milestone",milestone);
		if(task.getStatus().contains("completed")) {
			
		}
		//Calculating days left
		model.addAttribute("daysLeft",(task.getEndDate().getTime()-(new Date()).getTime()+86399999)/86400000);
		
		//getting files list of the task
		List<File> files = taskJDBC.getFiles(getSessionTaskId());
		model.addAttribute("files", files);
		
		//getting already added dependencies
		List<Task> dependencies = taskJDBC.getDependencies(getSessionTaskId());
		model.addAttribute("dependencies", dependencies);
		
		//Adding new dependencies
		List<Task> newDependencies = taskJDBC.getNewDependencies(getSessionProjectId(), getSessionTaskId());
		model.addAttribute("newDependencies", newDependencies);
		return "task";
		
	}
	
	@RequestMapping(value="/task/changeStatus")
	private String changeStatus(ModelMap model) {
		Task task = taskJDBC.getTask(getSessionTaskId());
		if(task.getStatus().contains("completed"))
			taskJDBC.changeStatus(getSessionTaskId(), "open");
		else
			taskJDBC.changeStatus(getSessionTaskId(), "completed");
		return "redirect:/task";
	}
	
	@RequestMapping(value="/task/addParticipant")
	private String addParticipant(ModelMap model, @RequestParam(value="username") String username) {
		
		taskJDBC.addParticipant(username, getSessionTaskId(), getSessionProjectId());
		return "redirect:/task";
	}
	
	@RequestMapping(value="/task/removeParticipant")
	private String removeParticipant(ModelMap model,@RequestParam(value="username") String username) {
		taskJDBC.removeParticipant(username, getSessionTaskId());
		return "redirect:/task";
	}
	
	@RequestMapping(value="task/uploadFile")
	private String uploadFile(ModelMap model,@RequestParam("filename") String filename)
	{
        System.out.println(filename);
        taskJDBC.addFile(filename, getSessionTaskId());
		return "redirect:/task";
	}
	
	
	@RequestMapping(value="/task/sendMessage")
	private String sendMessage(ModelMap model,@RequestParam(value="message") String message) {
		try
		{
		TaskChat tc = new TaskChat();
		tc.setTaskId(getSessionTaskId());
		tc.setUsername(getLoggedInUserName());
		tc.setMessage(message);
		taskJDBC.sendMessage(tc);
		
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return "redirect:/task";
	}
	
	@ResponseBody
	@RequestMapping(value="/task/getChat")
	private String getChat(ModelMap model) {
		List<TaskChat> taskChat = taskJDBC.getChat(getSessionTaskId());
		taskChat.sort(new SortByTimeForTask());
		String chat = getChatList(taskChat);
		return chat;
	}
	
	@RequestMapping("/task/addDependency")
	private String addDependency(ModelMap model, @RequestParam("taskId") int parentTask) {
		taskJDBC.addDependency(parentTask, getSessionTaskId());
		return "redirect:/task";
	}
	
	@RequestMapping("/task/removeDependency")
	private String removeDependency(ModelMap model,@RequestParam("taskId") int parentTask) {
		taskJDBC.removeDependency(parentTask, getSessionTaskId());
		return "redirect:/task";
	}
	
	@RequestMapping(value="/task/file", method=RequestMethod.GET)
	private String showFile(ModelMap model,@RequestParam(value="filename") String filename) throws IOException {
		String fileName = "C:\\Users\\HEMANT\\Documents\\OnlineProjectManagement\\src\\main\\webapp\\resources\\files\\"+getSessionTaskId()+"\\"+filename;
	    java.io.File file = new java.io.File(fileName);
	    FileReader fr = new FileReader(file); 
	      char [] a = new char[200];
	      fr.read(a);   // reads the content to the array
	      fr.close();
	      String content = String.valueOf(a);
	      System.out.println(content);
	      model.addAttribute("filename",filename);
	      model.addAttribute("content",content);
		return "file";
	}
	
	@RequestMapping(value="/task/file", method=RequestMethod.POST)
	private String editFile(ModelMap model,@RequestParam(value="filename") String filename, @RequestParam(value="content") String content) throws IOException {
		String fileName = "C:\\Users\\HEMANT\\Documents\\OnlineProjectManagement\\src\\main\\webapp\\resources\\files\\"+getSessionTaskId()+"\\"+filename;
	    java.io.File file = new java.io.File(fileName);
	    FileWriter fw = new FileWriter(file); 
	    fw.write(content);
		return "redirect:/task";
	}
	
	
	

}
