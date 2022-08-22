package com.capstone.springboot.thymeleafdemo.service;

import java.util.List;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.capstone.springboot.thymeleafdemo.entity.User;
import com.capstone.springboot.thymeleafdemo.web.dto.UserRegistrationDto;


public interface UserService extends UserDetailsService {
	
	User save(UserRegistrationDto registrationDto);
	public List<User> findAllUsers();
	public User findUserById(long theId);
	public void deleteUserById(long theId);
	public void saveUser(User theUser);
}
