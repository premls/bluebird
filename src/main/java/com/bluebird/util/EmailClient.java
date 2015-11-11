package com.bluebird.util;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Properties;
import java.util.concurrent.Future;

import javax.activation.DataSource;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.EmailAttachment;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.HtmlEmail;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;


/**
 * The Class EmailClient.
 */
public class EmailClient {
	
	private static final Logger logger = LoggerFactory.getLogger(EmailClient.class);
	private static Properties emailProps = null;
	private HtmlEmail email;
	static {
		try {
			emailProps = new Properties();
			emailProps.load(EmailClient.class.getResourceAsStream("/email.properties"));
		} catch (Exception e) {
			throw new RuntimeException("Invalid properties file, could not initialize email client");
		}
	}

	private EmailClient() {
	}

	public static EmailClient getDefaultMailClient() throws Exception {
		return new EmailClient(emailProps);
	}

	public static EmailClient getCustomMailClient(Properties emailProps) throws EmailException {
		EmailClient emailer = new EmailClient(emailProps);
		return emailer;
	}

	private EmailClient(Properties emailProps) throws EmailException {
		email = new HtmlEmail();
		email.setHostName(emailProps.getProperty("host"));
		email.setSmtpPort(Integer.parseInt(emailProps.getProperty("port")));
		email.setAuthenticator(new DefaultAuthenticator(emailProps.getProperty("email"), emailProps.getProperty("password")));
		email.setSSLOnConnect(Boolean.valueOf(emailProps.getProperty("sslOnConnect")));
		email.setStartTLSEnabled(Boolean.valueOf(emailProps.getProperty("startTLSEnabled")));
		email.setFrom(emailProps.getProperty("email"), emailProps.getProperty("name"));
		email.setDebug(Boolean.valueOf(emailProps.getProperty("debug")));
		email.setBounceAddress(emailProps.getProperty("bounceAddress"));
	}


	public void addTo(String emailAddress, String name) throws EmailException {
		if (StringUtils.isBlank(emailAddress) || StringUtils.isBlank(name)) {
			throw new EmailException("Invalid email address");
		}
		email.addTo(emailAddress, name);
	}

	public void addTo(String...emailAddress) throws EmailException {
		if (emailAddress == null || emailAddress.length < 1 ) {
			throw new EmailException("Invalid email address");
		}
		email.addTo(emailAddress);
	}
	
	public void addCc(String emailAddress, String name) throws EmailException {
		if (StringUtils.isBlank(emailAddress) || StringUtils.isBlank(name)) {
			throw new EmailException("Invalid email address");
		}
		email.addCc(emailAddress, name);
	}

	public void addBcc(String emailAddress, String name) throws EmailException {
		if (StringUtils.isBlank(emailAddress) || StringUtils.isBlank(name)) {
			throw new EmailException("Invalid email address");
		}
		email.addBcc(emailAddress, name);
	}

	public void addTo(Map<String, String> map) throws EmailException {
		if (map == null) {
			throw new EmailException("Invalid Map");
		}
		for (Entry<String, String> entry : map.entrySet()) {
			if (StringUtils.isNotBlank(entry.getKey()) && StringUtils.isNotBlank(entry.getKey())) {
				addTo(entry.getKey(), entry.getValue());
			}
		}

	}

	public void addCc(Map<String, String> map) throws EmailException {
		if (map == null) {
			throw new EmailException("Invalid Map");
		}
		for (Entry<String, String> entry : map.entrySet()) {
			if (StringUtils.isNotBlank(entry.getKey()) && StringUtils.isNotBlank(entry.getKey())) {
				addCc(entry.getKey(), entry.getValue());
			}
		}
	}

	public void addBcc(Map<String, String> map) throws EmailException {
		if (map == null) {
			throw new EmailException("Invalid Map");
		}
		for (Entry<String, String> entry : map.entrySet()) {
			if (StringUtils.isNotBlank(entry.getKey()) && StringUtils.isNotBlank(entry.getKey())) {
				addBcc(entry.getKey(), entry.getValue());
			}
		}

	}

	public void addAttachment(String url) throws EmailException, MalformedURLException {
		EmailAttachment attachment = new EmailAttachment();
		attachment.setURL(new URL(url));
		email.attach(attachment);
	}

	public void addAttachment(File file) throws EmailException {
		EmailAttachment attachment = new EmailAttachment();
		attachment.setPath(file.getAbsolutePath());
		email.attach(attachment);
	}

	public void addAttachment(DataSource ds,String name,String description) throws EmailException {
		email.attach(ds, name, description);
	}
	
	public String sendHtmlEmail(String subject, String content) throws EmailException {
		email.setSubject(subject);
		email.setHtmlMsg(content);
		email.setTextMsg("Your email client does not support html content");
		return send();
	}

	public String setTextEmail(String subject, String content) throws EmailException {
		email.setSubject(subject);
		email.setTextMsg(content);
		return send();
	}

	public String sendEmail(String subject, String htmlContent, String textContent) throws EmailException {
		email.setSubject(subject);
		email.setHtmlMsg(htmlContent);
		email.setTextMsg(textContent);
		return send();
	}

	/**
	 * @throws EmailException
	 */
	private String send() throws EmailException {
		String sentId = email.send();
		if (StringUtils.isNotBlank(sentId)) {
			logger.debug("Email sent successfully-"+sentId);
		}
		return sentId;
	}

	@Async
	public Future<Boolean> sendAsyncHtmlEmail(String subject, String content) throws EmailException {
		String id = sendHtmlEmail(subject, content);
		return new AsyncResult<Boolean>(StringUtils.isNotBlank(id));
	}
	
	public void sendHtmlMail(String template,Object bodyContentData)throws Exception{
			String subject = TemplateUtils.getInstance().processSubject(template);

			String body = TemplateUtils.getInstance().processContent(template, bodyContentData);
			
			sendAsyncHtmlEmail(subject, body);
	}
	
	public void sendHtmlMail(String template,Object bodyContentData,Map<String, String> subjectData)throws Exception{
		String subject = TemplateUtils.getInstance().processSubject(template,subjectData);

		String body = TemplateUtils.getInstance().processContent(template, bodyContentData);
		
		sendAsyncHtmlEmail(subject, body);
		
	}

}
