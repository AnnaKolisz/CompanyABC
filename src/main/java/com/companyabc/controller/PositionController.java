package com.companyabc.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import java.util.Set;
import java.util.TreeMap;
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
		Map<String, String> countUsers = new HashMap<String, String>();
		List<Position> positions = positionRepo.findAll();
		for (Position position : positions) {
			countUsers.put(position.getName(), positionRepo.countUsersGroupByPosition(position.getId()).toString());
		}
		Map<String, String> listOfPositions = new TreeMap<String, String>(countUsers);
		model.addAttribute("Users", listOfPositions);
		return "PositionView/statistic";
		
	}
	


}
