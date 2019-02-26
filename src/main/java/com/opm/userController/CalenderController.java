package com.opm.userController;

import java.security.Principal;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.opm.database.Task;
import com.opm.service.HomeDAOJDBCImpl;
import com.opm.service.TaskDAOJDBCImpl;

@Controller
public class CalenderController {
	
	@Autowired
	private HomeDAOJDBCImpl homeJDBC;
	
	@RequestMapping("/calender")
	private String calenderPage(ModelMap model, Principal principal) {
		List<Task> task = homeJDBC.getTasks(principal.getName());
		Random rand = new Random();
		String data = "";
		for(Task t: task) {
			data+="{";
			data+="title : '"+t.getTaskName()+"',";
			data+="start : '"+t.getStartDate().toString()+"',";
			data+="end : '"+t.getEndDate().toString()+"',";
			data+="color : 'rgb("+(rand.nextInt(250)+2)+","+(rand.nextInt(240)+9)+","+(rand.nextInt(230)+25)+")'";
			data+="},";
		}
		model.addAttribute("data", data);
		return "calender";
	}
}
