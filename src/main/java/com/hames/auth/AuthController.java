package com.hames.auth;

import org.apache.shiro.SecurityUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Handles requests for the application home page.
 */
@Controller
public class AuthController {
	
	@RequestMapping(value = "/")
	public String home(Model model) {
		if(SecurityUtils.getSubject().isAuthenticated()){
			return "redirect:/dashboard";
		}
		return "login";
	}
	
	@RequestMapping(value = "/login")
	public String login(Model model) {
		if(SecurityUtils.getSubject().isAuthenticated()){
			return "redirect:/";
		}
		return "login";
	}
	
	@RequestMapping(value = "/logout")
	public String logout(Model model) {
		if(SecurityUtils.getSubject().isAuthenticated()){
			SecurityUtils.getSubject().logout();
			return "redirect:/";
		}
		return "redirect:/dashboard";
	}
	
	
	@RequestMapping(value="/unauthorized")
	public String unAuthorized(){
		return "error.403";
	}
}
