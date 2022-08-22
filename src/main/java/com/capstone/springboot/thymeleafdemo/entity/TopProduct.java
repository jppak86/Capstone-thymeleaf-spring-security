package com.capstone.springboot.thymeleafdemo.entity;




import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.Table;



@Entity
@Table(name="TopProduct")
public class TopProduct {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Column(name="category")
	private String productCategory;
	
	@Column(name="product_name")
	private String productName;
	
	@Column(name="price")
	private double price;
	
	@Column(name="img")
	private String img;
	
	@Column(name="description")
	private String description;
	 

	public TopProduct() {
		
	}
	
	


	public TopProduct( String productCategory, String productName, double price, String img,
			String description) {
		
		this.productCategory = productCategory;
		this.productName = productName;
		this.price = price;
		this.img = img;
		this.description = description;
	}




	public String getDescription() {
		return description;
	}




	public void setDescription(String description) {
		this.description = description;
	}





	public String getProductCategory() {
		return productCategory;
	}




	public void setProductCategory(String productCategory) {
		this.productCategory = productCategory;
	}


	public int getId() {
		return id;
	}
	
	


	public void setId(int id) {
		this.id = id;
	}




	public String getProductName() {
		return productName;
	}


	public double getPrice() {
		return price;
	}


	public String getImg() {
		return img;
	}



	public void setProductName(String productName) {
		this.productName = productName;
	}


	public void setPrice(double price) {
		this.price = price;
	}


	public void setImg(String img) {
		this.img = img;
	}




	@Override
	public String toString() {
		return "TopProduct [id=" + id + ", productCategory=" + productCategory + ", productName=" + productName
				+ ", price=" + price + ", img=" + img + ", description=" + description + "]";
	}


	
		
}





