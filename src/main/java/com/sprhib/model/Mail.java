package com.sprhib.model;

import java.io.IOException;
import java.io.InputStream;

import javax.mail.internet.MimeMessage;

import org.springframework.core.io.InputStreamSource;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

public class Mail implements MimeMessagePreparator {

	private String emailTo;
	private String subject;
	private String message;
	private String from;
	private CommonsMultipartFile attachedFile;

	public String getEmailTo() {
		return emailTo;
	}

	public void setEmailTo(String emailTo) {
		this.emailTo = emailTo;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public CommonsMultipartFile getAttachedFile() {
		return attachedFile;
	}

	public void setAttachedFile(CommonsMultipartFile attachedFile) {
		this.attachedFile = attachedFile;
	}

	@Override
	public void prepare(MimeMessage mimeMessage) throws Exception {
		MimeMessageHelper messageHelper = new MimeMessageHelper(mimeMessage,
				true, "UTF-8");
		from ="hsinjhen@gmail.com";
		messageHelper.setTo(emailTo);
		messageHelper.setSubject(subject);
		messageHelper.setText(message);
		messageHelper.setFrom(from, "Your Friend");

		String attachedName = attachedFile.getOriginalFilename();
		if (!attachedFile.equals("")) {
			messageHelper.addAttachment(attachedName, new InputStreamSource() {

				@Override
				public InputStream getInputStream() throws IOException {
					return attachedFile.getInputStream();
				}
			});
		}

	}

}
