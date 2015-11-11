package com.bluebird.services;

import com.bluebird.dto.RegisterDTO;
import com.bluebird.exception.MailSendingException;

public interface EmailService {

	void sendVerificationMail(RegisterDTO registerDTO) throws MailSendingException;
}
