package com.sprhib.dao;

import org.springframework.web.multipart.commons.CommonsMultipartFile;

public interface EmailDAO {
	public void sendMailService(String recipient, String subject, String body, CommonsMultipartFile attachedFile);
}
