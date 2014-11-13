package com.sprhib.service;

import org.springframework.web.multipart.commons.CommonsMultipartFile;

public interface EmailService {
	public void sendMailService(String recipient, String subject, String body, CommonsMultipartFile attachedFile);
}
