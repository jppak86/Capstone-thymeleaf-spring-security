package com.capstone.springboot.thymeleafdemo.entity;


public class Response {

	private String message;
	private boolean success;
	
	
	
	public Response() {
		
	}



	public Response(String message, boolean success) {
		
		this.message = message;
		this.success = success;
	}



	public String getMessage() {
		return message;
	}



	public boolean isSuccess() {
		return success;
	}



	public void setMessage(String message) {
		this.message = message;
	}



	public void setSuccess(boolean success) {
		this.success = success;
	}
	
	
	
	
	
	
}
