package com.capstone.springboot.thymeleafdemo.service;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.capstone.springboot.thymeleafdemo.entity.Role;
import com.capstone.springboot.thymeleafdemo.entity.User;
import com.capstone.springboot.thymeleafdemo.repository.UserRepository;
import com.capstone.springboot.thymeleafdemo.web.dto.UserRegistrationDto;

@Service
public class UserServiceImpl implements UserService {

	
	private UserRepository userRepository;
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	@Autowired
	public UserServiceImpl(UserRepository userRepository) {
		this.userRepository = userRepository;
	}
	
	
	@Override
	public List<User> findAllUsers(){
		return userRepository.findAllByOrderByIdAsc();
	}
	
	@Override
	public User findUserById(long theId) {
		Optional<User> result = userRepository.findById(theId);
		
		User theUser = null;
		
		if (result.isPresent()) {
			theUser = result.get();
		}
		else {
			throw new RuntimeException("Did not find user id: " + theId);
		}
		
		return theUser;
	}
	
	@Override
	public void saveUser(User theUser) {
		userRepository.save(theUser);
	}
	




	@Override
	public User save(UserRegistrationDto registrationDto) {
		
		User user = new User(registrationDto.getFirstName(), 
				registrationDto.getLastName(), registrationDto.getEmail(),
				passwordEncoder.encode(registrationDto.getPassword()), Arrays.asList(new Role("ROLE_ADMIN")));
		
		return userRepository.save(user);
	}
	
	
	@Override
	public void deleteUserById(long theId) {
		userRepository.deleteById(theId);
	}
	
	




	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
	
		User user = userRepository.findByEmail(username);
		if(user == null) {
			throw new UsernameNotFoundException("Invalid username or password.");
		}
		return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(), mapRolesToAuthorities(user.getRoles()));		
	}
	
	private Collection<? extends GrantedAuthority> mapRolesToAuthorities(Collection<Role> roles){
		return roles.stream().map(role -> new SimpleGrantedAuthority(role.getName())).collect(Collectors.toList());
	}

}
