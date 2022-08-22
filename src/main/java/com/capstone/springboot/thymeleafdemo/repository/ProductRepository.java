package com.capstone.springboot.thymeleafdemo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.capstone.springboot.thymeleafdemo.entity.TopProduct;

@Repository
public interface ProductRepository extends JpaRepository<TopProduct, Integer>{

	public List<TopProduct> findAllByOrderByIdAsc();
}
