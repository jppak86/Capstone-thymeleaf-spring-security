package com.capstone.springboot.thymeleafdemo.service;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.capstone.springboot.thymeleafdemo.entity.User;
import com.capstone.springboot.thymeleafdemo.web.dto.UserRegistrationDto;


public interface UserService extends UserDetailsService {
	
	User save(UserRegistrationDto registrationDto);

}
