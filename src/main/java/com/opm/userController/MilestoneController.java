package com.opm.userController;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;

import com.opm.database.Milestone;
import com.opm.database.Task;
import com.opm.html.Methods;
import com.opm.service.MilestoneDAOJDBCImpl;

@Controller
public class MilestoneController {
	
	@Autowired
	private MilestoneDAOJDBCImpl milestoneJDBC;
	
	@InitBinder
    public void initBinder(WebDataBinder binder) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
    }
	
	private int getSessionProjectId()
	{
		int projectId=(int)RequestContextHolder.currentRequestAttributes().getAttribute("projectId", RequestAttributes.SCOPE_SESSION);
		return projectId;
	}
	
	private String getMilestoneView(List<Milestone> milestone) {
		String view="";
		for(Milestone mile : milestone) {
			List<Task> task = milestoneJDBC.getTasks(mile.getMilestoneId());
			view+=Methods.getMilestone(mile, task);
		}
		return view;
	}
	
	@RequestMapping(value="/milestone")
	private String milestonePage(ModelMap model) {
		List<Milestone> listMilestone = milestoneJDBC.getMilestones(getSessionProjectId());
		String view = getMilestoneView(listMilestone);
		model.addAttribute("view", view);
		return "milestone";
	}
	
	@RequestMapping(value="/milestone/task",params="taskId")
	private String redirectingToTaskPage(ModelMap model,@RequestParam(value="taskId") int taskId,HttpSession session) {
		session.setAttribute("taskId", taskId);
		return "redirect:/task";
	}
	
	@RequestMapping(value="/milestone/addMilestone")
	private String addMilestone(ModelMap model,@RequestParam(value="milestoneName") String milestoneName) {
		Milestone milestone = new Milestone();
		milestone.setMilestoneName(milestoneName);
		milestone.setProjectId(getSessionProjectId());
		milestoneJDBC.addMilestone(milestone);
		return "redirect:/milestone";
	}
	
	@RequestMapping(value="milestone/addTask")
	private String addTask(ModelMap model,@RequestParam int milestoneId,@RequestParam String taskName, @RequestParam Date startDate, @RequestParam Date endDate, @RequestParam String description) {
		Task task =new Task();
		task.setTaskName(taskName);
		task.setStartDate(startDate);
		task.setEndDate(endDate);
		task.setDescription(description);
		task.setMilestoneId(milestoneId);
		milestoneJDBC.addTask(task);
		return "redirect:/milestone";
	}
	@RequestMapping(value="milestone/deleteTask")
	private String deleteTask(ModelMap model,@RequestParam(value="taskId") int taskId) {
		milestoneJDBC.removeTask(taskId);
		return "redirect:/milestone";
	}
	
	@RequestMapping(value="milestone/deleteMilestone")
	private String deleteMilestone(ModelMap model,@RequestParam(value="milestoneId") int milestoneId) {
		milestoneJDBC.removeMilestone(milestoneId);
		return "redirect:/milestone";
	}
	
}
