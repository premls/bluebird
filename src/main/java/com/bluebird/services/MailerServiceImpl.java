package com.bluebird.services;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.bluebird.dto.RegisterDTO;
import com.bluebird.exception.MailSendingException;
import com.bluebird.util.EmailClient;
import com.bluebird.util.StatusAndError;
import com.bluebird.util.TemplateUtils;


@Service("mailService")
public class MailerServiceImpl implements EmailService {

	private static final Logger logger = LoggerFactory.getLogger(MailerServiceImpl.class);
	private String EMAIL_VERIFICATION_SUBJECT = "email_verification"; 
	private String CUSTOMER_EMAIL_VERIFICATION_TEMPLATE = "customer_email_verification";
   
    /**
     * This method will send compose and send the message
     * @throws MailSendingException 
     * */
    @Override
    public void sendVerificationMail(RegisterDTO registerDTO) throws MailSendingException {

		try {
			EmailClient emailclient = EmailClient.getDefaultMailClient();
			emailclient.addTo(registerDTO.getEmail());
			Map<String, String> dataMap = new HashMap<String, String>();
			dataMap.put("firstname", registerDTO.getFirstName());
			
			String subject = TemplateUtils.getInstance().processSubject(EMAIL_VERIFICATION_SUBJECT, dataMap);
			// TODO generate one time password or link
			String content = TemplateUtils.getInstance().processContent(CUSTOMER_EMAIL_VERIFICATION_TEMPLATE, dataMap);
			emailclient.sendHtmlEmail(subject, content);
    	
		} catch (Exception e) {
			logger.error("",e);
			throw new MailSendingException(StatusAndError.EMAIL_SENDING_FAILED);
		}
    }
 
}