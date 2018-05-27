package com.companyabc.controller;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.companyabc.entity.Position;
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
		model.addAttribute("numberOfUsers", userRepo.count());
		HashMap<String, Long> countUsers = new HashMap<String, Long>();
		List<Position> positions = positionRepo.findAllByOrderByIdAsc();
		
		for (Position position : positions) {
			countUsers.put(position.getName(), positionRepo.countUsersGroupByPosition(position.getId()));			
		}
		model.addAttribute("Users", countUsers);
		return "PositionView/statistic";
		
	}

}
