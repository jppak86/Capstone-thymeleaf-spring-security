package com.capstone.springboot.thymeleafdemo.service;

import java.util.List;

import com.capstone.springboot.thymeleafdemo.entity.TopProduct;

public interface ProductService {

	public TopProduct findProductById(int theId);
	public List<TopProduct> findAllProducts();
	public void saveProduct(TopProduct theProduct);
	public void deleteProductById(int theId);
}
