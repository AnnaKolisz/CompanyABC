package com.companyabc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AdminController {
	

	@GetMapping("/login")
	public String getLoginPage() {
		return "login";
	}
	
	@GetMapping("")
	public String navigate() {
		return "redirect:/companyabc";
	}

}
