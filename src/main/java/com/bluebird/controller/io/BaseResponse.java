package com.bluebird.controller.io;

import com.bluebird.util.StatusAndError;

public class BaseResponse {

	private int responseCode;
	private String responseMessage;
	private boolean status;
	
	public int getResponseCode() {
		return responseCode;
	}
	public void setResponseCode(int responseCode) {
		this.responseCode = responseCode;
	}
	public String getResponseMessage() {
		return responseMessage;
	}
	public void setResponseMessage(String responseMessage) {
		this.responseMessage = responseMessage;
	}
	
	public void setResponseStatus(StatusAndError statusAndError) {
		this.responseCode = statusAndError.getCode();
		this.responseMessage = statusAndError.getMessage();
	}
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
}
