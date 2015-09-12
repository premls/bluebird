package com.bluebird.exception;

import com.bluebird.util.StatusAndError;

public abstract class BaseException extends Exception {

	private static final long serialVersionUID = 1L;

	private StatusAndError error;
	
	public BaseException(StatusAndError error) {
		this.error = error;
	}

	public StatusAndError getError() {
		return error;
	}

	public void setError(StatusAndError error) {
		this.error = error;
	}
	
	public String getErrorMessage() {
		return error != null ? error.getMessage() : null; 
	}
	
	public int getErrorCode() {
		return error != null ? error.getCode() : null; 
	}
}
