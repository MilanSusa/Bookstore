package rs.ac.bg.fon.ai.milansusa.bookstore.service;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import rs.ac.bg.fon.ai.milansusa.bookstore.config.Settings;

public class MailSender {

	private static final Logger logger = LogManager.getLogger(MailSender.class);

	public static void sendMail(String userEmail) {
		final String email = Settings.getInstance().config.getEmailConfig().getEmail();
		final String password = Settings.getInstance().config.getEmailConfig().getPassword();
		final String host = Settings.getInstance().config.getEmailConfig().getHost();
		final String port = String.valueOf(Settings.getInstance().config.getEmailConfig().getPort());
		final String clazz = Settings.getInstance().config.getEmailConfig().getClazz();
		final String auth = String.valueOf(Settings.getInstance().config.getEmailConfig().isAuth());

		System.out.println(email + password + host + port + clazz + auth);
		Properties props = new Properties();
		props.put("mail.smtp.host", host);
		props.put("mail.smtp.socketFactory.port", port);
		props.put("mail.smtp.socketFactory.class", clazz);
		props.put("mail.smtp.auth", auth);
		props.put("mail.smtp.port", port);

		Session session = Session.getDefaultInstance(props, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(email, password);
			}
		});

		try {
			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress(email));
			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(userEmail));
			message.setSubject("Bookstore registration");
			String content = readContentFromFile(
					"src" + File.separator + "main" + File.separator + "webapp" + File.separator + "email.html");
			message.setContent(content, "text/html; charset=utf-8");
			logger.info("Sending user registration mail...");
			Transport.send(message);
			logger.info("User registration mail sent.");
		} catch (MessagingException e) {
			logger.error("A problem occured while sending user registration email to [" + userEmail + "] :",
					e.getMessage());
			throw new RuntimeException(e);
		}
	}

	private static String readContentFromFile(String fileName) {
		StringBuffer contents = new StringBuffer();
		try {
			BufferedReader reader = new BufferedReader(new FileReader(fileName));
			try {
				String line = null;
				while ((line = reader.readLine()) != null) {
					contents.append(line);
					contents.append(System.getProperty("line.separator"));
				}
			} finally {
				reader.close();
			}
		} catch (IOException ex) {
			logger.error("A problem occured while reading file: " + ex.getMessage());
			ex.printStackTrace();
		}
		return contents.toString();
	}

}
