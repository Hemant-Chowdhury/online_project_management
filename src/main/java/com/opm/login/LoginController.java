package com.opm.login;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class LoginController {
	

	@RequestMapping(value="/login")
	public String loginPage(ModelMap model)
	{
		model.addAttribute("title","Login");
		return "login";
	}
	
	@RequestMapping(value="/home")
	public String homePage(ModelMap model)
	{
		model.addAttribute("title","Home");
		return "home";
	}
}
