package com.mindgate.main.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("customer")
public class HomePageController {
	@RequestMapping("home")
	public String goHome(HttpSession httpSession)
	{
		
		
		return "/home";
	}
	
	@RequestMapping("closemsg")
	public String closeMgsPopUp(HttpSession httpSession)
	{
		httpSession.setAttribute("displayMsg",false);
		httpSession.setAttribute("popUpMessage","");
		return "redirect:/customer/home";
	}
	
	 @RequestMapping("logout")
	    public String logoutFromBank(HttpSession httpSession)
	    {
	        httpSession.invalidate();

	        return "redirect:/";
	    }
	 
	 @RequestMapping("profile")
	    public String showProfilePage(HttpSession httpSession) {

	        return "profile";
	    }
}
