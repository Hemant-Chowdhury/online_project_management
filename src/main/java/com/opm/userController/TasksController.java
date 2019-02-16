package com.opm.userController;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TasksController {
	
	@RequestMapping(value="tasks/addTask")
	private String addTask(ModelMap model) {
		return null;
		
	}
	
}
