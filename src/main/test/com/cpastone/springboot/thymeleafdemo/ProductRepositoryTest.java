package com.cpastone.springboot.thymeleafdemo;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import com.capstone.springboot.thymeleafdemo.ThymeleafdemoApplication;
import com.capstone.springboot.thymeleafdemo.entity.TopProduct;
import com.capstone.springboot.thymeleafdemo.repository.ProductRepository;

@Transactional
@Rollback
@SpringBootTest(classes = ThymeleafdemoApplication.class)
public class ProductRepositoryTest {
	
	@Autowired
	ProductRepository pr;
	
	@Test
	void testProductRespositoryIsNotNull(){
		Assertions.assertNotNull(pr);
	}
	
	@Test
	void testAllByOrderByIdAsc() {
		List<TopProduct> listProducts = pr.findAllByOrderByIdAsc();
		Assertions.assertNotNull(listProducts);
		
	}
	
	@Test
	void testSavefindProductById() {
		TopProduct product = new TopProduct();
		product.setProductName("Nike shorts");
		product.setProductCategory("bottome");
		product.setDescription("It is shorts");
		product.setImg("img");
		product.setPrice(20.00);
		pr.save(product);
		TopProduct checkProduct = pr.findById(product.getId()).get();
		Assertions.assertNotNull(checkProduct);
		Assertions.assertEquals("Nike shorts", checkProduct.getProductName());
	}
	
	@Test
	void testDeleteProductById() {
		TopProduct product = new TopProduct();
		product.setProductName("Nike t-shirts");
		product.setProductCategory("top");
		product.setDescription("It is top");
		product.setImg("img2");
		product.setPrice(20.00);
		pr.save(product);
		int theId = product.getId();
		pr.deleteById(theId);
		Assertions.assertFalse(pr.findById(theId).isPresent());
		
	}
}
