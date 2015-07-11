package com.bluebird.util;

public enum StatusAndError {

	//Success response code
	SUCCESS_RESPONSE(200, "Success"),
	
	TRADERS_NOT_AVAILABLE(100, "No traders available");
	
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
