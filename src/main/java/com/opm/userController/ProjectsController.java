package com.opm.userController;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.annotation.JsonView;
import com.opm.ajax.AjaxResponseBody;
import com.opm.database.Project;
import com.opm.database.User;
import com.opm.html.Methods;
import com.opm.jasonView.Views;
import com.opm.service.ProjectFeedDAOJDBCImpl;
import com.opm.service.ProjectsDAOJDBCImpl;
import com.opm.service.UserDAOJDBCImpl;

@Controller
@RequestMapping(value="/projects")
public class ProjectsController {

	@Autowired
	private ProjectsDAOJDBCImpl projectsJDBC;
	

	private String getLoggedInUserName() {
		Object principal = SecurityContextHolder.getContext()
				.getAuthentication().getPrincipal();

		if (principal instanceof UserDetails)
			return ((UserDetails) principal).getUsername();

		return principal.toString();
	}


	//Main user profile page
	@RequestMapping(value="")
	private String projectsPage(ModelMap model) {
		model.addAttribute("project",new Project());
		List<Project> project1 = projectsJDBC.getProjectsOwned(getLoggedInUserName());
		List<Project> project2 = projectsJDBC.getProjectsManaged(getLoggedInUserName());
		List<Project> project3 = projectsJDBC.getProjectsDeveloped(getLoggedInUserName());

		model.addAttribute("owned", project1);
		model.addAttribute("managed",project2);
		model.addAttribute("developed", project3);
		return "projects";
	}

	//"Project","Description",getLoggedInUserName()
	@RequestMapping(value="",params= {"add=true"})
	private String addProject(ModelMap model,@Valid Project project,BindingResult result) {
		if(result.hasErrors())
		{
			return "redirect:/projects";
		}
		project.setOwner(getLoggedInUserName());
		projectsJDBC.addProject(project);
		return "redirect:/projects";
	}

	@RequestMapping(value="/delete")
	private String deleteProject(ModelMap model,@RequestParam(value="projectId") int projectId) {

		System.out.println(projectId+" Project deleted");
		projectsJDBC.deleteProject(projectId);
		return "redirect:/projects";
	}
	
	@RequestMapping(value="/moreInfo")
	private String moreInfo(ModelMap model,HttpSession session,@RequestParam int projectId)
	{
		session.setAttribute("projectId", projectId);
		return "redirect:/project";
	}
	
}

