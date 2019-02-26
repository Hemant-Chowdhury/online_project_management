package com.opm.userController;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.opm.CustomSort.SortByDateForMeeting;
import com.opm.CustomSort.SortByTime;
import com.opm.CustomSort.SortByTimeForTask;
import com.opm.database.File;
import com.opm.database.Meeting;
import com.opm.database.Milestone;
import com.opm.database.Project;
import com.opm.database.ProjectChat;
import com.opm.database.Task;
import com.opm.database.TaskChat;
import com.opm.database.User;
import com.opm.database.UserProject;
import com.opm.html.Methods;
import com.opm.service.MeetingDAOJDBCImpl;
import com.opm.service.MilestoneDAOJDBCImpl;
import com.opm.service.ProjectDAOJDBCImpl;
import com.opm.service.ProjectsDAOJDBCImpl;
import com.opm.service.TaskDAOJDBCImpl;
import com.opm.service.UserDAOJDBCImpl;

@Controller
public class GuestController {
	
	@Autowired
	private UserDAOJDBCImpl userJDBC;
	@Autowired
	private TaskDAOJDBCImpl taskJDBC;
	@Autowired
	private  MilestoneDAOJDBCImpl milestoneJDBC;
	@Autowired
	private ProjectsDAOJDBCImpl projectsJDBC;
	@Autowired
	private ProjectDAOJDBCImpl projectJDBC;
	@Autowired
	private MeetingDAOJDBCImpl meetingJDBC;
	
	private int ProjectId,TaskId;
	private String path="C:\\Users\\HEMANT\\Documents\\OnlineProjectManagement\\src\\main\\webapp\\resources\\files\\";
	
	private int getSessionProjectId() {
		return ProjectId;
	}
	private int getSessionTaskId() {
		return TaskId;
	}
	
	private String getChatList(List<ProjectChat> chat)
	{
		String view="";
		for(ProjectChat pc:chat) {
			view+=Methods.getChat(pc, userJDBC.getUser(pc.getUsername()), 1);
		}
		return view;
	}
	private String getChatListTask(List<TaskChat> chat)
	{
		String view="";
		for(TaskChat tc:chat) {
				view+=Methods.getTaskChat(tc, userJDBC.getUser(tc.getUsername()), 1);
		}
		return view;
	}
	
	private String getMilestoneView(List<Milestone> milestone) {
		String view="";
		for(Milestone mile : milestone) {
			List<Task> task = milestoneJDBC.getTasks(mile.getMilestoneId());
			view+=Methods.getGuestMilestone(mile, task);
		}
		return view;
	}
	
	@RequestMapping("/guest/home")
	private String homePage(ModelMap model) {
		
		List<Project> project = projectsJDBC.getAllProjects();
		List<Task> task = taskJDBC.getAllTasks();
		
		List<Task> completedTask = new ArrayList<Task>();
		List<Task> presentTask = new ArrayList<Task>();  
		List<Task> pastTask = new ArrayList<Task>();
		List<Task> futureTask = new ArrayList<Task>();
		Date date = new Date();
		for(Task t: task) {
			if(t.getStatus().contains("completed")) {
				completedTask.add(t);
			}
			else if(t.getStartDate().getTime()>date.getTime()) {
				futureTask.add(t);
			}
			else if(t.getEndDate().getTime()<date.getTime()) {
				pastTask.add(t);
			}
			else {
				presentTask.add(t);
			}
		}
		model.addAttribute("project",project);
		model.addAttribute("presentTask", presentTask);
		model.addAttribute("pastTask", pastTask);
		model.addAttribute("futureTask", futureTask);
		model.addAttribute("completedTask",completedTask);
		return "guestHome";
	}
	
	@RequestMapping(value="/guest/home/project")
	private String gotoProject(ModelMap model, @RequestParam(value="projectId") int projectId) {
		ProjectId = projectId;
		return "redirect:/guest/project";
	}
	
	@RequestMapping(value="/guest/home/task")
	private String gotoTask(ModelMap model,HttpSession session, @RequestParam(value="taskId") int taskId) {
		
		Task task = taskJDBC.getTask(taskId);
		Milestone mile = milestoneJDBC.getMilestone(task.getMilestoneId());
		Project project = projectJDBC.getProject(mile.getProjectId());
		ProjectId = project.getProjectId();
		TaskId = taskId;
		return "redirect:/guest/task";
	}
	
	@RequestMapping("/guest/projects")
	private String projectsPage(ModelMap model) {
		List<Project> projects = projectsJDBC.getAllProjects();
		model.addAttribute("projects",projects);
		return "guestProjects";
	}
	
	@RequestMapping("/guest/project")
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
		return "guestProject";
	}
	
	@ResponseBody
	@RequestMapping(value="/guest/project/getChat")
	private String getChat(ModelMap model) {
		List<ProjectChat> projectChat = projectJDBC.getChat(getSessionProjectId());
		projectChat.sort(new SortByTime());
		String chat = getChatList(projectChat);
		return chat;
	}
	
	@RequestMapping(value="/guest/milestone")
	private String milestonePage(ModelMap model) {
		List<Milestone> listMilestone = milestoneJDBC.getMilestones(getSessionProjectId());
		String view = getMilestoneView(listMilestone);
		model.addAttribute("view", view);
		return "guestMilestone";
	}
	
	@RequestMapping(value="/guest/milestone/task",params="taskId")
	private String redirectingToTaskPage(ModelMap model,@RequestParam(value="taskId") int taskId,HttpSession session) {
		TaskId = taskId;
		return "redirect:/guest/task";
	}
	
	@RequestMapping(value="/guest/changeTask")
	private String changeTask(ModelMap model, @RequestParam(value="taskId") int taskId,HttpSession session) {
		TaskId = taskId;
		return "redirect:/guest/task";
	}
	
	@RequestMapping(value="/guest/task")
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
		
		
		//Putting current task and milestone object in the model for future use
		Task task =taskJDBC.getTask(getSessionTaskId());
		Milestone milestone = milestoneJDBC.getMilestone(task.getMilestoneId());
		model.addAttribute("task",task);
		model.addAttribute("milestone",milestone);
		
		//Calculating days left
		model.addAttribute("daysLeft",(task.getEndDate().getTime()-(new Date()).getTime()+86399999)/86400000);
		
		//getting files list of the task
		List<File> files = taskJDBC.getFiles(getSessionTaskId());
		model.addAttribute("files", files);
		
		//getting already added dependencies
		List<Task> dependencies = taskJDBC.getDependencies(getSessionTaskId());
		model.addAttribute("dependencies", dependencies);
		
		return "guestTask";
		
	}
	
	@ResponseBody
	@RequestMapping(value="/guest/task/getChat")
	private String getTaskChat(ModelMap model) {
		List<TaskChat> taskChat = taskJDBC.getChat(getSessionTaskId());
		taskChat.sort(new SortByTimeForTask());
		String chat = getChatListTask(taskChat);
		return chat;
	}

	@RequestMapping(value="/guest/task/file", method=RequestMethod.GET)
	private String showFile(ModelMap model,@RequestParam(value="filename") String filename) throws IOException {
		String fileName = path+getSessionTaskId()+"\\"+filename;
	    java.io.File file = new java.io.File(fileName);
	    FileReader fr = new FileReader(file); 
	      char [] a = new char[100000];
	      fr.read(a);   // reads the content to the array
	      fr.close();
	      String content = String.valueOf(a);
	      model.addAttribute("filename",filename);
	      model.addAttribute("content",content);
		return "guestFile";
	}
	
	@RequestMapping(value="/guest/report")
	private String mainPage(ModelMap model) {
		
		List<Milestone> mile = milestoneJDBC.getMilestones(getSessionProjectId());
		List<Task> task  = new ArrayList<Task>();
		for(Milestone m : mile) {
			List<Task> temp = milestoneJDBC.getTasks(m.getMilestoneId());
			for(Task t: temp) {
				
				List<Task> d=taskJDBC.getDependencies(t.getTaskId());
				if(d.isEmpty())
					t.setDescription("null");
				else
				{
					String dep = "";
					for(Task dt: d) {
						dep+=","+dt.getTaskId();
					}
					t.setDescription("'"+dep.substring(1, dep.length())+"'");
				}
				task.add(t);
				System.out.println(t.getTaskName() + " " + t.getStartDate() + " " +t.getEndDate()+" "+t.getDescription());
			}
		}
		Methods meth = new Methods();
		String view = meth.DisplayReport(task);
		model.addAttribute("view", view);
		return "guestReport";
	}
	
	
	@RequestMapping("/guest/meeting")
	private String getMeetings(ModelMap model) {
		List<Meeting> meeting = meetingJDBC.getMeetings(getSessionProjectId());
		meeting.sort(new SortByDateForMeeting());
		String data="";
		for(Meeting m : meeting) {
			data+="[";
			data+="'"+m.getDate().toString()+"','"+m.getTopic()+"','"+m.getConclusion()+"'";
			data+="],";
		}
		model.addAttribute("data",data);
		return "guestMeeting";
	}
	
}
