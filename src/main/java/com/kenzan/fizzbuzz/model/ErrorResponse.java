package com.kenzan.fizzbuzz.model;

public class ErrorResponse {

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public ErrorResponse(String message) {
		super();
		this.message = message;
	}

	private String message;
}