package com.luv2code.springboot.thymeleafdemo.service;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.luv2code.springboot.thymeleafdemo.entity.User;
import com.luv2code.springboot.thymeleafdemo.web.dto.UserRegistrationDto;


public interface UserService extends UserDetailsService {
	
	User save(UserRegistrationDto registrationDto);

}
