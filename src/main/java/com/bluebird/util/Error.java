package com.bluebird.util;

public enum Error {

	INVALID_INPUT(100, "Invalid input paramters");
	
	private int code;
	private String message;
	
	private Error(int code, String message) {
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
