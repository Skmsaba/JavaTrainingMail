package com.sendemail;

import java.io.InputStream;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class SendMail {

	public static void main(String[] args) throws Exception {

		ReadFile mailDescription = new ReadFile();

		ClassLoader loader = Thread.currentThread().getContextClassLoader();           
		
		InputStream stream = loader.getResourceAsStream("config.properties");
		
		Properties prop=new Properties();
		
		prop.load(stream);
		
		final String username=prop.getProperty("userID");
		final String password=prop.getProperty("passcode");
		final String recipient=prop.getProperty("recipient");
		final String subject=prop.getProperty("subject");
		
		final String[] recipients=recipient.split(",");

		Session session = Session.getInstance(prop, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username, password);
			}
		});

		try {
			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress(username));
			for (String to : recipients) {
				message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
			}
			message.setSubject(subject);
			message.setText(mailDescription.staticsOfFile());
			Transport.send(message);
			System.out.println("Done");

		} catch (MessagingException e) {
			e.printStackTrace();
		}

	}

}