package com.capstone.springboot.thymeleafdemo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capstone.springboot.thymeleafdemo.entity.TopProduct;
import com.capstone.springboot.thymeleafdemo.repository.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService {
	
	private ProductRepository pr;

	@Autowired
	public ProductServiceImpl(ProductRepository pr) {
		this.pr = pr;
	}
	
	@Override
	public List<TopProduct> findAllProducts(){
		return pr.findAllByOrderByIdAsc();
	}
	
	@Override
	public TopProduct findProductById(int theId) {
		Optional<TopProduct> result = pr.findById(theId);
		
		TopProduct theProduct = null;
		
		if(result.isPresent()) {
			theProduct = result.get();
		}
		else{
			 throw new RuntimeException("Did not find product id: " + theId);
		}
		return theProduct;
	}
	
	@Override
	public void saveProduct(TopProduct theProduct) {
		pr.save(theProduct);
	}
	
	@Override
	public void deleteProductById(int theId) {
		pr.deleteById(theId);
	}
	
	

}
