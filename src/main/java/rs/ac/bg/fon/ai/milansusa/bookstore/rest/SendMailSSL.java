package rs.ac.bg.fon.ai.milansusa.bookstore.rest;

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
import rs.ac.bg.fon.ai.milansusa.bookstore.model.User;

public class SendMailSSL {

	private static final Logger logger = LogManager.getLogger(SendMailSSL.class);

	public static void sendMail(User user) {
		logger.info("Sending user registration mail...");
		final String username = Settings.getInstance().config.getEmail().getEmail();
		final String password = Settings.getInstance().config.getEmail().getPassword();
		Properties props = new Properties();
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.socketFactory.port", "465");
		props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.port", "465");
		Session session = Session.getDefaultInstance(props, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username, password);
			}
		});
		try {
			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress(username));
			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(user.getEmail()));
			message.setSubject("Bookstore registration");
			String content = readContentFromFile(
					"src" + File.separator + "main" + File.separator + "webapp" + File.separator + "email.html");
			message.setContent(content, "text/html; charset=utf-8");
			Transport.send(message);
			logger.info("User registration mail sent.");
		} catch (MessagingException e) {
			logger.error("A problem occured while sending user registration email to [" + user.getEmail() + "] :",
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
			ex.printStackTrace();
		}
		return contents.toString();
	}

}
