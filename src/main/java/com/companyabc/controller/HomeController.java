package com.companyabc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/companyabc")
public class HomeController {
	
	@RequestMapping("/")
	public String startApp() {
		return "start";
	}

	
}
