package com.capefox.common;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;

@Component
public class EmailSender {

	@Autowired
	private JavaMailSender mailSender;

	public void sendEmail(String otp, String toEmail, String nameAndAddress) {
		MimeMessage message = mailSender.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(message);
		try {
			helper.setTo(toEmail);
			helper.setSubject("Your One Time Password (OTP)");
			helper.setText("Hello " + nameAndAddress + ",\n\nYour OTP is: " + otp);
		} catch (MessagingException e) {
			e.printStackTrace();
		}
		mailSender.send(message);
	}
}