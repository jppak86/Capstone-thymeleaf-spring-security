package com.capstone.springboot.thymeleafdemo.web;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.capstone.springboot.thymeleafdemo.entity.User;
import com.capstone.springboot.thymeleafdemo.repository.UserRepository;





@Controller
public class MainController {
	
	UserRepository userRepository;
	
	
	
	
	@RequestMapping("/login")
	public String login() {
		
		return "/login";
	}
	
	@GetMapping("/userId")
	public String currentUserId(@ModelAttribute("product") User theUser) {
		
		String reUrl = "http://localhost:8080/Shop/login/home/" + theUser.getId();
		return "redirect:" + reUrl;
	}

}
