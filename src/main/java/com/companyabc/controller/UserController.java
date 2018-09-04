package com.companyabc.controller;

import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
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
	
	@GetMapping("")
	public String startApp() {
		return "start";
	}
	
	@ModelAttribute("positions")
	public List<Position> findAllPositions() {
		return positionRepo.findAll();
	}
	
	@ModelAttribute("employees")
	public List<User> findAllUsers() {
		return userRepo.findAllByOrderBySurnameAsc();
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
		List<User> employees = userRepo.findAll();
		for (User employee : employees) {
			if(employee.getEmail().equals(user.getEmail())) {
				return "UserView/wrongEmail";
			}
		}
		userRepo.save(user);
		//return "redirect:addNextEmployee";
		return "redirect:addEmployee";
	}

	
	@GetMapping("/listOfEmployees")
	public String showListOfEmployees() {
		return "UserView/listOfUsers";
	}

	@GetMapping("/editEmployee/{id}")
	public String editUser(@PathVariable long id, Model model) {
		model.addAttribute("user", userRepo.findById(id));
		return "UserView/editUser";
	}
	
	@PostMapping("/editEmployee/{id}")
	public String edition(@Valid User user, BindingResult result) {
		if(result.hasErrors()) {
			return "UserView/editUser";
		}
		userRepo.save(user);
		return "redirect:/companyabc/listOfEmployees";		
	}
	
	@GetMapping("/deleteEmployee/{id}")
	public String deleteUser(@PathVariable long id) {
		userRepo.deleteById(id);
		return "redirect:/companyabc/listOfEmployees";	
		
	}
	


}
