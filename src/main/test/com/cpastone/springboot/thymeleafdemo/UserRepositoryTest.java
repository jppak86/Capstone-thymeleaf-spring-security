package com.cpastone.springboot.thymeleafdemo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import com.capstone.springboot.thymeleafdemo.ThymeleafdemoApplication;
import com.capstone.springboot.thymeleafdemo.entity.User;
import com.capstone.springboot.thymeleafdemo.repository.UserRepository;

@Transactional
@Rollback
@SpringBootTest(classes = ThymeleafdemoApplication.class)
public class UserRepositoryTest {
	
	@Autowired
	private UserRepository ur;
	
	@Test
	void testUserRepositoryIsNotNull() {
		Assertions.assertNotNull(ur);
	}
	
	@Test
	void findUserById() {
		User user = ur.findById((long) 8).get();
		Assertions.assertNotNull(user);
		Assertions.assertEquals("jae", user.getFirstName());
	}
	
	@Test
	void testSaveUser() {
		User user = new User();
		user.setFirstName("joe");
		user.setLastName("cha");
		user.setEmail("zoe@email.com");
		user.setPassword("1234");
		ur.save(user);
		User user2 = ur.findById(user.getId()).get();
		Assertions.assertEquals(user2, user);
	}
	
	@Test
	void testDeleteUser() {
		ur.deleteById((long) 7);
		Assertions.assertFalse(ur.findById((long) 7).isPresent());
	}
	

}
