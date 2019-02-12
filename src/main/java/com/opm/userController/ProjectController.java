package com.opm.userController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.opm.database.Project;
import com.opm.html.Methods;
import com.opm.service.ProjectsDAOJDBCImpl;
import com.opm.service.UserDAOJDBCImpl;

@Controller
@RequestMapping(value="/user/projects")
public class ProjectController {
	
	@Autowired
	private ProjectsDAOJDBCImpl projectsJDBC;
	
	private String getLoggedInUserName() {
		Object principal = SecurityContextHolder.getContext()
				.getAuthentication().getPrincipal();

		if (principal instanceof UserDetails)
			return ((UserDetails) principal).getUsername();

		return principal.toString();
	}
	
	private String projectView(List<Project> project) {
		String view="";
		int i=0;
		for(Project p : project) {
			System.out.println(p.getProjectName()+" "+p.getTimestamp());
			view+=Methods.getProjectPanel(p,i);
			i++;
		}
		return view;
	}
	
	@RequestMapping(value="")
	private String projects(ModelMap model) {
		
		List<Project> project = projectsJDBC.getProjectsOwned(getLoggedInUserName());
		String view = projectView(project);
		model.addAttribute("project",view);
		return "projects";
	}
	
	@RequestMapping(value="/delete")
	private String deleteProject(ModelMap model,@RequestParam() int projectId) {
		
		projectsJDBC.deleteProject(projectId);
		return "redirect:/user/projects";
	}
}
