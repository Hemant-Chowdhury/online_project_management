package com.opm.user;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.opm.database.User;
import com.opm.html.Methods;
import com.opm.service.UserDAOJDBCImpl;

@Controller
@RequestMapping("/profile")
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
	
	
	@RequestMapping(value="")
	public String profilePage(ModelMap model,@RequestParam(required=false) String message)
	{
		String username = getLoggedInUserName();
		System.out.println(username);
		User user = userJDBC.gerUser(username);
		model.addAttribute("user", user);
		model.addAttribute("title","Profile");
		return "profile";
	}
	
	@RequestMapping(value="/uploadImage")
	public String uploadImage(ModelMap model,HttpServletRequest request, HttpServletResponse response) 
	{
		String message=(String) request.getAttribute("message");
		String username = getLoggedInUserName();
		System.out.println(message);
		if(message.contains("success"))
		{
			userJDBC.updateImage(username,"/resources/images/"+username+".png");
		}
		else
		{
			userJDBC.updateImage(username,"/resources/images/default.png");
		}
		return "redirect:/profile";
	}
	
	
	@RequestMapping(value="/updateProfile")
	public String updateProfile(ModelMap model,@Valid User user,BindingResult result){
		if(result.hasErrors())
		{
			return "redirect:/profile";
		}
		userJDBC.updateProfile(getLoggedInUserName(), user.getName(), user.getEmail(), user.getCompany());
		model.addAttribute("successMessage","Profile Details updated");
		return "redirect:/profile";
	}
	
	
	@RequestMapping(value="/updatePassword")
	public String updatePassword(ModelMap model,@RequestParam String newPassword,@RequestParam String oldPassword) {
		String message = userJDBC.updatePassword(getLoggedInUserName(), oldPassword, newPassword);
		if(message.contains("failed"))
			model.addAttribute("errorMessage",message);
		else
			model.addAttribute("successMessage",message);
		return "redirect:/profile";
	}
}
