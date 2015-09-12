package com.bluebird.exception;

import com.bluebird.util.StatusAndError;

public class ViewException extends BaseException {

	public ViewException(StatusAndError error) {
		super(error);
	}

	private static final long serialVersionUID = 1L;

}
