package com.companyabc.controller;

import java.util.List;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.companyabc.entity.Position;
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
	
	@GetMapping("/")
	public String startApp() {
		return "start";
	}
	
	@ModelAttribute("positions")
	public List<Position> findAllPositions() {
		return positionRepo.findAll();
	}
	
	@GetMapping("/addEmployee")
	public String addNewUser(Model model) {
		model.addAttribute("user", new User());
		return "UserView/addUser";
		
	}
	
	@PostMapping("/addEmployee")
	public String addUser(@Valid @ModelAttribute("user")User user, BindingResult result) {
		if(result.hasErrors()) {
			return "UserView/addUser";
		}
		userRepo.save(user);
		return "redirect:addNextEmployee";		
	}
	
	@GetMapping("/addNextEmployee")
	public String addNewnextUser(Model model) {
		model.addAttribute("user", new User());
		return "UserView/addUser";
		
	}
	
	@PostMapping("/addNextEmployee")
	public String addnextUser(@Valid @ModelAttribute("user")User user, BindingResult result) {
		if(result.hasErrors()) {
			return "UserView/addNextUser";
		}
		userRepo.save(user);
		return "redirect:addNextEmployee";		
	}

}
