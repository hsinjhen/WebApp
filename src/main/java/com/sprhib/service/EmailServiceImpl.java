package com.sprhib.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.sprhib.dao.EmailDAO;

@Service
@Transactional
public class EmailServiceImpl implements EmailService {

	@Autowired
	EmailDAO emailDAO;
	
	@Override
	public void sendMailService(String recipient, String subject, String body, CommonsMultipartFile attachedFile) {
		emailDAO.sendMailService(recipient, subject, body, attachedFile);
	}

}
