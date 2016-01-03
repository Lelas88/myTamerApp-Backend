package com.mastalerek.mytamer.service;

import java.util.Properties;

import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Service;

import com.mastalerek.mytamer.webmodel.StudentCredentials;

@Service
public class MailService {

	private JavaMailSenderImpl configureMailClient() {

		JavaMailSenderImpl sender = new JavaMailSenderImpl();
		sender.setProtocol("smtp");
		sender.setHost("smtp.gmail.com");
		sender.setPort(587);
		sender.setUsername("mytamerapp");
		sender.setPassword("mytamerapp2015");

		Properties mailProps = new Properties();
		mailProps.put("mail.smtps.auth", "true");
		mailProps.put("mail.smtp.starttls.enable", "true");
		mailProps.put("mail.smtp.debug", "true");

		sender.setJavaMailProperties(mailProps);

		return sender;
	}

	public void sendEmailForNewStudent(StudentCredentials credentials) {
		JavaMailSenderImpl mailSenderImpl = configureMailClient();
		SimpleMailMessage message = new SimpleMailMessage();
		message.setTo(credentials.getEmail());
		message.setSubject("myTamer registration");
		message.setText(
				"Dear student, your coach has created a new account for you in myTamer application. Your login and password are shown below:"
						+ "Login: " + credentials.getLogin() + " Password: " + credentials.getPassword());
		try {
			mailSenderImpl.send(message);
		} catch (MailException e) {
			System.out.println(e.getMessage());
		}
	}

}
