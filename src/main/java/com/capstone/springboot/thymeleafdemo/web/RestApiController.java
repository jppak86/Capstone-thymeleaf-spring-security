package com.capstone.springboot.thymeleafdemo.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capstone.springboot.thymeleafdemo.entity.TopProduct;
import com.capstone.springboot.thymeleafdemo.entity.User;
import com.capstone.springboot.thymeleafdemo.service.ProductService;
import com.capstone.springboot.thymeleafdemo.service.UserService;


@RestController
@RequestMapping("/api")
@CrossOrigin(origins =  "http://localhost:3000")
public class RestApiController {
	
	private ProductService pds;
	private UserService uss;
	
	@Autowired
	public RestApiController(ProductService pds, UserService uss) {
		this.pds = pds;
		this.uss = uss;
	}
	
	@GetMapping("/users")
	public List<User> findAllUsers(){
		return uss.findAllUsers();
	}
	
	@GetMapping("/users/{userId}")
	public User getUser(@PathVariable long userId) {
		User theUser = uss.findUserById(userId);
		
		if (theUser == null) {
			throw new RuntimeException("User id not found: " + userId);
		}
		return theUser;
	}
	
	@PostMapping("/users")
	public String addUser(@RequestBody User newUser) {
//		theUser.setId((long) 0);
		uss.saveUser(newUser);
		
		return "New User is added";
	}
	
	@PutMapping("/users")
	public User updaUser(@RequestBody User theUser) {
		uss.saveUser(theUser);
		
		return theUser;
	}
	
	@DeleteMapping("/users/{userId}")
	public String deleteUser(@PathVariable long userId) {
		User theUser = uss.findUserById(userId);
		
		
		
		if (theUser == null) {
			throw new RuntimeException("User id not found - " + userId);
		}
		
		uss.deleteUserById(userId);
		
		return "Deleted user id - " + userId;
	}
	
	@GetMapping("/products")
	public List<TopProduct> findAllProducts() {
		return pds.findAllProducts();
	}
	
	@GetMapping("/products/{productId}")
	public TopProduct getProduct(@PathVariable int productId) {
		TopProduct theProduct = pds.findProductById(productId);
		
		if (theProduct == null) {
			throw new RuntimeException("Product is not found: " + productId);
		}
		
		return theProduct;
	}
	
	@PostMapping("/products")
	public TopProduct addProduct(@RequestBody TopProduct theProduct) {
		theProduct.setId(1);
		pds.saveProduct(theProduct);
		
		return theProduct;
	}
	
	@PutMapping("/products")
	public TopProduct updateProduct(@RequestBody TopProduct thProduct) {
		
		pds.saveProduct(thProduct);
		
		return thProduct;
	}
	
	@DeleteMapping("/proucts/{productId}")
	public String deleteProduct(@PathVariable int productId) {
		TopProduct theProduct = pds.findProductById(productId);
		
		if(theProduct == null) {
			throw new RuntimeException("Product id not found: " + productId);
		}
		
		pds.deleteProductById(productId);
		
		return "Product id: " + productId + "is deleted.";
	}
		
	
	
	

}
