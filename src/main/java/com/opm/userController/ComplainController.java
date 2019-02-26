package com.opm.userController;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.opm.database.Complain;
import com.opm.service.ComplainDAOJDBCImpl;

@Controller
public class ComplainController {
	
	@Autowired
	private ComplainDAOJDBCImpl complainJDBC;
	@RequestMapping("/contact")
	private String contactPage(ModelMap model, Principal principal) {
		List<Complain> complain = complainJDBC.getComplains(principal.getName());
		model.addAttribute("complain", complain);
		return "contact";
	}
	
	@RequestMapping("/contact/addComplain")
	private String addComplainPage(ModelMap model, @RequestParam("complain") String content, Principal principal) {
		
		Complain complain = new Complain(principal.getName(),content,"open");
		complainJDBC.addComplain(complain);
		return "redirect:/contact";
	}
	
}
