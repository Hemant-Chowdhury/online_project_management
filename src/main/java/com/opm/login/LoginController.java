package com.opm.login;

import java.security.Principal;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.support.SessionStatus;

import com.opm.database.User;
import com.opm.html.Methods;
import com.opm.service.LoginDAOJDBCImpl;


@Controller
public class LoginController {

	@Autowired
	private LoginDAOJDBCImpl userJDBC;

	@RequestMapping(value="/",method=RequestMethod.GET)
	public String homePage(ModelMap model,SessionStatus session) {
		return "redirect:/home";
	}
	
	@RequestMapping(value="/home")
	public String homePage(ModelMap model,HttpSession session,Principal principal)
	{
		session.setAttribute("username", principal.getName());
		System.out.println("In home page"+ principal.getName());
		return "home";
	}

	@RequestMapping(value="/login",method=RequestMethod.GET)
	public String loginPage(ModelMap model)
	{
		return "login";
	}

	@RequestMapping("/error")
	public String error(ModelMap model)
	{
		model.addAttribute("error", "true");
		return "login";
	}

	@RequestMapping(value="/register",method=RequestMethod.GET)
	public String registerPage(ModelMap model)
	{
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
	
	@RequestMapping(value="/logout")
    public String logout(ModelMap model,HttpSession session)
    {
        Authentication authentication = SecurityContextHolder.getContext()
                .getAuthentication();
        authentication.setAuthenticated(false);
        session.invalidate();
        model.addAttribute("logout", "true");
        return "login";
    }
}
