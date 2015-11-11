package com.bluebird.exception;

import com.bluebird.util.StatusAndError;

public class InvalidRequestException extends BaseException {

	private static final long serialVersionUID = 1L;

	public InvalidRequestException(StatusAndError error) {
		super(error);
	}

}
