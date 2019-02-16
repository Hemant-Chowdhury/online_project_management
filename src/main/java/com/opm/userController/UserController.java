package com.opm.userController;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.opm.database.User;
import com.opm.html.Methods;
import com.opm.service.UserDAOJDBCImpl;


@Controller
@RequestMapping(value="/user")
public class UserController {
	
	@Autowired
	private UserDAOJDBCImpl userJDBC;
	
	private String getLoggedInUserName() {
		Object principal = SecurityContextHolder.getContext()
				.getAuthentication().getPrincipal();

		if (principal instanceof UserDetails)
			return ((UserDetails) principal).getUsername();

		return principal.toString();
	}
	
	
	@RequestMapping(value="/profile")
	public String profilePage(ModelMap model)
	{
		String username = getLoggedInUserName();
		User user = userJDBC.getUser(username);
		model.addAttribute("user", user);
		return "profile";
	}
	@CacheEvict
	@RequestMapping(value="/profile",params={"update=image"})
	public String uploadImage(ModelMap model,HttpServletRequest request, HttpServletResponse response) 
	{
		String message=(String) request.getAttribute("message");
		String username = getLoggedInUserName();
		if(message.contains("success"))
		{
			userJDBC.updateImage(username,"/resources/images/"+username+".png");
		}
		else
		{
			userJDBC.updateImage(username,"/resources/images/default.png");
		}
		return "redirect:/user/profile";
	}
	
	
	@RequestMapping(value="/profile",params= {"update=profile"})
	public String updateProfile(ModelMap model,@Valid User user,BindingResult result){
		if(result.hasErrors())
		{
			return "redirect:/user/profile";
		}
		userJDBC.updateProfile(getLoggedInUserName(), user.getName(), user.getEmail(), user.getCompany());
		model.addAttribute("message",Methods.jsAlert("\"Profile Updated\""));
		return profilePage(model);
	}
	
	
	@RequestMapping(value="/profile",params= {"update=password"})
	public String updatePassword(ModelMap model,@RequestParam String newPassword,@RequestParam String oldPassword) {
		String message = userJDBC.updatePassword(getLoggedInUserName(), oldPassword, newPassword);
		model.addAttribute("message",Methods.jsAlert("\""+message+"\""));
		return profilePage(model);
	}
}
