package com.mindgate.main.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class NetBankingController {
	@RequestMapping("/")
	public String welcome() {
		return "welcome";
	}
	
	@RequestMapping("loginpage")
	public String loginPage() {
		System.err.println("from controller");
		return "loginpage";
	}
	
	@RequestMapping("registerpage")
	public String showRegisterPage()
	{
		return "registerpage";
	}

}
