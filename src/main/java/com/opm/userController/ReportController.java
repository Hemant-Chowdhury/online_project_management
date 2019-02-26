package com.opm.userController;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;

import com.opm.database.Milestone;
import com.opm.database.Task;
import com.opm.html.Methods;
import com.opm.service.MilestoneDAOJDBCImpl;
import com.opm.service.TaskDAOJDBCImpl;

@Controller
public class ReportController {

	@Autowired
	private TaskDAOJDBCImpl taskJDBC;
	@Autowired
	private MilestoneDAOJDBCImpl milestoneJDBC;
	
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
	
	@RequestMapping(value="/report")
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
		System.out.println("printing view");
		Methods meth = new Methods();
		String view = meth.DisplayReport(task);
		model.addAttribute("view", view);
		return "report";
	}
}

