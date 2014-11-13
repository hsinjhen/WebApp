package com.sprhib.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Repository;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.sprhib.model.Mail;

@Repository
public class EmailDAOImpl implements EmailDAO {

	@Autowired
	private JavaMailSender mailSender;
	
	@Override
	public void sendMailService(String recipient, String subject, String body, CommonsMultipartFile attachedFile) {
		Mail mail = new Mail();
		mail.setEmailTo(recipient);
		mail.setSubject(subject);
		mail.setMessage(body);
		mail.setAttachedFile(attachedFile);
		mailSender.send(mail);
	}

}
