package com.opm.logout;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.context.request.WebRequest;

@Controller
public class LogoutController {
	
	@RequestMapping(value="/logout",method=RequestMethod.GET)
	public String logoutPage(WebRequest request,SessionStatus status) {
		/**
	     * store User ...
	     */
	    status.setComplete();
	    request.removeAttribute("username", WebRequest.SCOPE_SESSION);
	    System.out.println("Session complete");
	    return "redirect:/login";
	}
}
