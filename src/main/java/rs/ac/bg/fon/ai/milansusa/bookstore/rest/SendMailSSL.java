package rs.ac.bg.fon.ai.milansusa.bookstore.rest;

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

import rs.ac.bg.fon.ai.milansusa.bookstore.model.User;

public class SendMailSSL {

	private static final Logger logger = LogManager.getLogger(SendMailSSL.class);

	public static void sendMail(User user) {
		logger.info("Sending user registration mail...");
		final String username = "milansusa28@gmail.com";
		final String password = "t3st3m41ls3nd3r";
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
			message.setFrom(new InternetAddress("milansusa28@gmail.com"));
			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(user.getEmail()));
			message.setSubject("Registration recorded");
			message.setText("Dear " + user.getName() + "," + "\n\nYour registration has been recorded.");
			Transport.send(message);
			logger.info("User registration mail sent.");
		} catch (MessagingException e) {
			logger.error("A problem occured while sending user registration email to [" + user.getEmail() + "] :",
					e.getMessage());
			throw new RuntimeException(e);
		}
	}

}
