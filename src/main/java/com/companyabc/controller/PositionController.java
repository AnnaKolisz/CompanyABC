package com.companyabc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.companyabc.repository.PositionRepository;
import com.companyabc.repository.UserRepository;

@Controller
@RequestMapping("/companyabc")
public class PositionController {
	
	@Autowired
	PositionRepository positionRepo;
	
	@Autowired
	UserRepository userRepo;
	
	@GetMapping("/positions")
	public String showStatistic(Model model) {
		model.addAttribute("numberOfPosition", positionRepo.count());
		model.addAttribute("numbers", userRepo.countByPosition(positionRepo.findByName("Prezes")));
		return "PositionView/statistic";
		
	}

}
