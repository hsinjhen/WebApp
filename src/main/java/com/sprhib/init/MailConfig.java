package com.sprhib.init;

import java.util.Properties;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

@Configuration
public class MailConfig {

	private static final String MAIL_HOST = "smtp.gmail.com";
	private static final Integer MAIL_PORT = 587;
	private static final String MAIL_USERNAME = "hsinjhen@gmail.com";
	private static final String MAIL_PASSWORD = "fatimahiprenoridel";
	private static final String MAIL_TRANSPORT_PROTOCOL = "mail.transport.protocol";
	private static final String MAIL_SMTP_AUTH = "mail.smtp.auth";
	private static final String MAIL_SMTP_STARTTLS_ENABLE = "mail.smtp.starttls.enable";

	@Bean
	public JavaMailSender mailSender() {
		JavaMailSenderImpl javaMailSender = new JavaMailSenderImpl();
		javaMailSender.setHost(MAIL_HOST);
		javaMailSender.setPort(MAIL_PORT);
		javaMailSender.setUsername(MAIL_USERNAME);
		javaMailSender.setPassword(MAIL_PASSWORD);
		javaMailSender.setJavaMailProperties(javaMailProperties());
		return javaMailSender;
	}

	private Properties javaMailProperties() {
		Properties props = new Properties();
		props.put(MAIL_TRANSPORT_PROTOCOL, "smtp");
		props.put(MAIL_SMTP_AUTH, "true");
		props.put(MAIL_SMTP_STARTTLS_ENABLE, "true");
		return props;
	}
	
	@Bean
	public CommonsMultipartResolver multipartResolver(){
		CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver();
		multipartResolver.setMaxUploadSize(20971520);
		multipartResolver.setMaxInMemorySize(1048576);
		return multipartResolver;
	}
}
