package com.opm.userController;

import java.security.Principal;
import java.sql.Timestamp;
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
import org.springframework.web.bind.support.SessionStatus;

import com.opm.CustomSort.SortByTimeForProjectFeed;
import com.opm.CustomSort.SortByTimeForTask;
import com.opm.CustomSort.SortByTimeForTaskFeed;
import com.opm.database.Milestone;
import com.opm.database.Project;
import com.opm.database.ProjectFeed;
import com.opm.database.Task;
import com.opm.database.TaskFeed;
import com.opm.html.Methods;
import com.opm.service.HomeDAOJDBCImpl;
import com.opm.service.MilestoneDAOJDBCImpl;
import com.opm.service.ProjectDAOJDBCImpl;
import com.opm.service.ProjectFeedDAOJDBCImpl;
import com.opm.service.TaskDAOJDBCImpl;
import com.opm.service.TaskFeedDAOJDBCImpl;
import com.opm.service.UserDAOJDBCImpl;

@Controller
public class HomeController {

	@Autowired
	private HomeDAOJDBCImpl homeJDBC;
	@Autowired
	private TaskDAOJDBCImpl taskJDBC;
	@Autowired
	private  MilestoneDAOJDBCImpl milestoneJDBC;
	@Autowired
	private ProjectDAOJDBCImpl projectJDBC;
	@Autowired
	private ProjectFeedDAOJDBCImpl projectFeedJDBC;
	@Autowired
	private TaskFeedDAOJDBCImpl taskFeedJDBC;
	
	
	@RequestMapping(value="/",method=RequestMethod.GET)
	public String homePage(ModelMap model) {
		return "redirect:/home";
	}
	
	@RequestMapping(value="/home")
	public String homePage(ModelMap model,HttpSession session,Principal principal)
	{
		session.setAttribute("username", principal.getName());
		System.out.println(principal.getName());
		List<Project> project =  homeJDBC.getProjects(principal.getName());
		List<Task> task = homeJDBC.getTasks(principal.getName());
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
		List<ProjectFeed> projectFeed = new ArrayList<ProjectFeed>();
		List<TaskFeed> taskFeed = new ArrayList<TaskFeed>();
		for(Project p :project) {
			projectFeed.addAll(projectFeedJDBC.getProjectFeeds(p.getProjectId()));
		}
		for(Task t: task) {
			taskFeed.addAll(taskFeedJDBC.getTaskFeeds(t.getTaskId()));
		}
		projectFeed.sort(new SortByTimeForProjectFeed());
		taskFeed.sort(new SortByTimeForTaskFeed());
		model.addAttribute("project",project);
		model.addAttribute("presentTask", presentTask);
		model.addAttribute("pastTask", pastTask);
		model.addAttribute("futureTask", futureTask);
		model.addAttribute("completedTask",completedTask);
		model.addAttribute("projectFeed",projectFeed);
		model.addAttribute("taskFeed", taskFeed);
		return "home";
	}
	
	
	@RequestMapping(value="/home/project")
	private String gotoProject(ModelMap model,HttpSession session, @RequestParam(value="projectId") int projectId) {
		session.setAttribute("projectId", projectId);
		return "redirect:/project";
	}
	
	@RequestMapping(value="/home/task")
	private String gotoTask(ModelMap model,HttpSession session, @RequestParam(value="taskId") int taskId) {
		
		Task task = taskJDBC.getTask(taskId);
		Milestone mile = milestoneJDBC.getMilestone(task.getMilestoneId());
		Project project = projectJDBC.getProject(mile.getProjectId());
		session.setAttribute("projectId", project.getProjectId());
		session.setAttribute("taskId", taskId);
		return "redirect:/task";
	}
	
}
