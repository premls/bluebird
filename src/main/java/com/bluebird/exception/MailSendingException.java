package com.bluebird.exception;

import com.bluebird.util.StatusAndError;

public class MailSendingException extends BaseException {

	private static final long serialVersionUID = 1L;

	public MailSendingException(StatusAndError error) {
		super(error);
	}

}
