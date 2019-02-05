package com.opm.login;

import java.util.List;

import javax.validation.Valid;
import javax.xml.ws.BindingType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.opm.html.Methods;
import com.opm.loginDatabase.LoginData;
import com.opm.loginDatabase.LoginDataDAOJDBCImpl;

@Controller
public class LoginController {
	
	@Autowired
	private LoginDataDAOJDBCImpl LoginDataJDBC;

	@RequestMapping(value="/login",method=RequestMethod.GET)
	public String loginPage(ModelMap model)
	{
		model.addAttribute("title","Login");
		return "login";
	}
	
	@RequestMapping(value="/login",method=RequestMethod.POST)
	public String loginPage(@RequestParam String username,@RequestParam String password,ModelMap model)
	{
		if(LoginDataJDBC.validateUser(username,password))
		{
			System.out.println("User validated");
			model.addAttribute("title", "Home");
			return homePage(model);
		}
		model.addAttribute("message",Methods.errorMessage("Invalid Credentials"));
		
		return loginPage(model);
	}
	
	@RequestMapping(value="/home")
	public String homePage(ModelMap model)
	{
		model.addAttribute("title","Home");
		return "home";
	}
	
	@RequestMapping(value="/register",method=RequestMethod.GET)
	public String registerPage(ModelMap model)
	{
		model.addAttribute("title","Register");
		model.addAttribute("user",new LoginData());
		return "register";
	}
	
	@RequestMapping(value="/register",method=RequestMethod.POST)
	public String registerPage(ModelMap model,@Valid LoginData user,BindingResult result)
	{
		if(result.hasErrors())
		{
			return "register";
		}
		LoginDataJDBC.create(user.getUsername(), user.getPassword());
		model.addAttribute("message",Methods.successMessage("Registration Completed"));
		return loginPage(model);
	}
}
