package com.springservices.restfulwebservices.basicauth;

public class BasicAuthBean {
	
	private String message;

	public BasicAuthBean(String message) {
		super();
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return "BasicAuthBean [message=" + message + "]";
	}

}
