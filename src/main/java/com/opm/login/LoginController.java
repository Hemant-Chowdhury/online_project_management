package com.opm.login;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.opm.html.Methods;
import com.opm.userDatabase.User;
import com.opm.userDatabase.LoginDAOJDBCImpl;


@Controller
@SessionAttributes("username")
public class LoginController {
	
	@Autowired
	private LoginDAOJDBCImpl userJDBC;
	
	@RequestMapping(value="/",method=RequestMethod.GET)
	public String roottPage(ModelMap model,SessionStatus session) {
		if(session.isComplete())
		{
			return "home";
		}
		return "login";
	}
	
	@RequestMapping(value="/{type}",method=RequestMethod.GET)
	public String defaultPage(ModelMap model,SessionStatus session,@PathVariable String type) {
		if(session.isComplete())
		{
			return type;
		}
		return "login";	
	}
	
	@RequestMapping(value="/login",method=RequestMethod.GET)
	public String loginPage(ModelMap model)
	{
		model.addAttribute("title","Login");
		return "login";
	}
	
	@RequestMapping(value="/login",method=RequestMethod.POST)
	public String loginPage(@RequestParam String username,@RequestParam String password,ModelMap model)
	{
		if(userJDBC.validateUser(username,password))
		{
			System.out.println("User validated");
			model.addAttribute("username", username);
			model.addAttribute("title", "Home");
			return "home";
		}
		model.addAttribute("message",Methods.errorMessage("Invalid Credentials"));
		
		return loginPage(model);
	}
	
	@RequestMapping(value="/register",method=RequestMethod.GET)
	public String registerPage(ModelMap model)
	{
		model.addAttribute("title","Register");
		model.addAttribute("user",new User());
		return "register";
	}
	
	@RequestMapping(value="/register",method=RequestMethod.POST)
	public String registerPage(ModelMap model,@Valid User user,BindingResult result)
	{
		if(result.hasErrors())
		{
			return "register";
		}
		try {
			userJDBC.create(user.getUsername(), user.getPassword(),user.getName(),user.getEmail(),user.getCompany());
		}
		catch(Exception e)
		{
			model.addAttribute("message", Methods.errorMessage("Username already exists!"));
			return registerPage(model);
		}
		model.addAttribute("message",Methods.successMessage("Registration Completed"));
		return loginPage(model);
	}
}
