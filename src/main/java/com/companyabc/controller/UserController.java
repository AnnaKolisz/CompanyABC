package com.companyabc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.companyabc.entity.User;
import com.companyabc.repository.PositionRepository;
import com.companyabc.repository.UserRepository;

@Controller
@RequestMapping("/companyabc")
public class UserController {
	
	@Autowired
	UserRepository userRepo;
	
	@Autowired
	PositionRepository positionRepo;
	
	@RequestMapping("/addEmployee")
	public String addNewUser(Model model) {
		model.addAttribute("user", new User());
		model.addAttribute("positions", positionRepo.findAll());
		return "UserView/addUser";
		
	}
	
	@PostMapping("/addUser")
	public String addUser(User user, BindingResult result) {
		if(result.hasErrors()) {
			return "UserView/addUser";
		}
		userRepo.save(user);
		return "listOfUsers";
		
	}

}
