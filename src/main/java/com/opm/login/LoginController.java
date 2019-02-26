package com.opm.login;

import java.lang.reflect.Method;
import java.security.Principal;
import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
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
import com.opm.service.UserDAOJDBCImpl;


@Controller
public class LoginController {

	@Autowired
	private LoginDAOJDBCImpl userJDBC;

	@RequestMapping(value="/login",method=RequestMethod.GET)
	public String loginPage(ModelMap model)
	{
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();

		if (!(auth instanceof AnonymousAuthenticationToken)) {

		    /* The user is logged in :) */
		    return "redirect:/home";
		}
		return "login";
	}

	@RequestMapping(value="/login",params="error")
	public String error(ModelMap model)
	{
		model.addAttribute("message", Methods.errorMessage("Invalid Credentials"));
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
		return "login";
	}
	
	@RequestMapping("/guest/login")
	private String guestLogin() {
		return "redirect:/guest/home";
	}
	
	@RequestMapping(value="/login",params="logout")
    public String logout(ModelMap model,HttpSession session)
    {
        Authentication authentication = SecurityContextHolder.getContext()
                .getAuthentication();
        authentication.setAuthenticated(false);
        session.invalidate();
        model.addAttribute("message",Methods.successMessage( "You have been logged out"));
        return "login";
    }
}
