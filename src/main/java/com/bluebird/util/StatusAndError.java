package com.bluebird.util;

public enum StatusAndError {

	//Success response code
	SUCCESS(200, "Success"),
	
	EMAIL_MANDATORY(100, "Email is mandatory"),
	TRADERS_NOT_AVAILABLE(101,"Traders are not available");
	
	private int code;
	private String message;
	
	private StatusAndError(int code, String message) {
		this.code = code;
		this.message = message;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
