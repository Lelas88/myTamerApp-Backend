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
		message.setSubject("myTamer reminder");
//		message.setText(
//				"Dear student, your coach has created a new account for you in myTamer application. Your login and password are shown below:"
//						+ "Login: " + credentials.getLogin() + " Password: " + credentials.getPassword());
//		message.setText(
//		"<p>Dear student,</p><br /><p>your coach has created a new account for you in myTamer application.</p>"
//		+ "<p>Your login and password are shown below:</p><p>"
//				+ "Login: " + credentials.getLogin() + "</p><p>Password: " + credentials.getPassword() + "</p><br /><p>Your Tamer!</p>");
		message.setText(
		"Dear coach, You have created a new account."
		+ "Your login and password are:"
				+ "Login: " + credentials.getLogin() + " Password: " + credentials.getPassword() + ". Your Tamer!");
//		message.setText(
		message.setText(
		"Dear user, You requested to remind you about your login credentials."
		+ "Your login and password are:"
				+ "Login: " + credentials.getLogin() + " Password: " + credentials.getPassword() + ". Your Tamer!");
		try {
			mailSenderImpl.send(message);
		} catch (MailException e) {
			System.out.println(e.getMessage());
		}
	}

}
