package com.opm.userController;

import java.security.Principal;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.opm.CustomSort.SortByTimeForProjectFeed;
import com.opm.CustomSort.SortByTimeForTaskFeed;
import com.opm.database.Project;
import com.opm.database.ProjectFeed;
import com.opm.database.Task;
import com.opm.database.TaskFeed;
import com.opm.service.HomeDAOJDBCImpl;
import com.opm.service.ProjectFeedDAOJDBCImpl;
import com.opm.service.TaskFeedDAOJDBCImpl;
import com.opm.service.UserDAOJDBCImpl;


@Controller
public class NotificationController {
	
	@Autowired
	private HomeDAOJDBCImpl homeJDBC;
	@Autowired
	private UserDAOJDBCImpl userJDBC;
	@Autowired
	private ProjectFeedDAOJDBCImpl projectFeedJDBC;
	@Autowired
	private TaskFeedDAOJDBCImpl taskFeedJDBC;
	
	
	@RequestMapping(value="/notifications")
	private String getNotification(ModelMap model,Principal principal) {
		List<Project> project =  homeJDBC.getProjects(principal.getName());
		List<Task> task = homeJDBC.getTasks(principal.getName());
		List<ProjectFeed> projectFeed = new ArrayList<ProjectFeed>();
		List<TaskFeed> taskFeed = new ArrayList<TaskFeed>();
		for(Project p :project) {
			projectFeed.addAll(projectFeedJDBC.getNotifiedFeeds(p.getProjectId(),userJDBC.getLastChecked(principal.getName())));
		}
		for(Task t: task) {
			taskFeed.addAll(taskFeedJDBC.getNotifiedFeeds(t.getTaskId(),userJDBC.getLastChecked(principal.getName())));
		}
		
		projectFeed.sort(new SortByTimeForProjectFeed());
		taskFeed.sort(new SortByTimeForTaskFeed());
		
		System.out.println("entered fix date");
		java.util.Date date = new java.util.Date();
		Timestamp lastChecked = new Timestamp(date.getTime());
		userJDBC.setLastChecked(principal.getName(),lastChecked);
		model.addAttribute("projectFeed",projectFeed);
		model.addAttribute("taskFeed", taskFeed);
		
		return "notification";
	}
}
