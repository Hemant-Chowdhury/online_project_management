package com.opm.userController;

import java.security.Principal;
import java.text.DateFormatSymbols;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.opm.database.Milestone;
import com.opm.database.Project;
import com.opm.database.Task;
import com.opm.service.HomeDAOJDBCImpl;
import com.opm.service.MilestoneDAOJDBCImpl;
import com.opm.service.ProjectDAOJDBCImpl;
import com.opm.service.TaskDAOJDBCImpl;

@Controller
public class UserReportController {
	
	@Autowired
	private HomeDAOJDBCImpl homeJDBC;
	@Autowired
	private TaskDAOJDBCImpl taskJDBC;
	@Autowired
	private  MilestoneDAOJDBCImpl milestoneJDBC;
	@Autowired
	private ProjectDAOJDBCImpl projectJDBC;
	
	@RequestMapping("/userReport")
	private String userReportPage(ModelMap model, Principal principal) {
		List<Task> task = homeJDBC.getTasks(principal.getName());
		int tasks[] = new int[12];
		int miles[] = new int[12];
		for(Task t: task) {
			Date sd = new Date(t.getStartDate().getTime());
			Date ed = new Date(t.getEndDate().getTime());
			int s = sd.getMonth();
			int e = ed.getMonth();
			for(int i=s;i<=e;i++)
			{
				tasks[i]++;
			}
		}
		
		List<Project> project = homeJDBC.getProjects(principal.getName());
		for(Project p: project) {
			List<Milestone> mile = milestoneJDBC.getMilestones(p.getProjectId());
			for(Milestone m : mile) {
				List<Task> tsk = taskJDBC.getTasks(m.getMilestoneId());
				int s = 12;
				int e = -1;
				for(Task t: tsk) {
					Date sd = new Date(t.getStartDate().getTime());
					Date ed = new Date(t.getEndDate().getTime());
					s=Math.min(s, sd.getMonth());
					e=Math.max(e, ed.getMonth());
				}
				for(int i=s;i<=e;i++) {
					miles[i]++;
				}
			}
		}
		
		String data = "['Month', 'Tasks', 'Milestones'],";
		String[] months = new DateFormatSymbols().getMonths();
		for(int i=0;i<12;i++) {
			data+="['"+months[i]+"',"+tasks[i]+","+miles[i]+"],";
		}
		model.addAttribute("data", data);
		return "userReport";
	}
}
