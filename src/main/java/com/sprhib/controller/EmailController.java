package com.sprhib.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.sprhib.service.EmailService;

@Controller
@RequestMapping(value = "/email")
public class EmailController {

	@Autowired
	private EmailService emailService;

	@RequestMapping(value = "/sendEmail", method = RequestMethod.GET)
	public ModelAndView sendEmailPage(@ModelAttribute("message") String message) {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("email-form");
		modelAndView.addObject("message", message);
		return modelAndView;
	}

	@RequestMapping(value = "/sendEmail", method = RequestMethod.POST)
	public ModelAndView sendEmail(@RequestParam("recipient") String recipient,
			@RequestParam("subject") String subject,
			@RequestParam("body") String body,
			@RequestParam CommonsMultipartFile attachedFile) {
		ModelAndView modelAndView = new ModelAndView();
		String message = "";
		try {
			message = "Thank you, your email has been sent.";
			emailService.sendMailService(recipient, subject, body, attachedFile);
		} catch (Exception e) {
			message = "Cannot Send Email: " + e;
			return sendEmailPage(message);
		}
		modelAndView.setViewName("email-form");
		modelAndView.addObject("message", message);
		return modelAndView;
	}
}
