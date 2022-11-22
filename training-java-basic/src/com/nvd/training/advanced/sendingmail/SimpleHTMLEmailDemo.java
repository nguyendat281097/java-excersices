package com.nvd.training.advanced.sendingmail;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

public class SimpleHTMLEmailDemo {
	public static void sendEmail(Session session, String toEmail, String subject, String body) {
		try {
			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress("no-reply@gmail.com"));
			message.setRecipients(
			  Message.RecipientType.TO, InternetAddress.parse(toEmail));
			message.setSubject(subject);

			MimeBodyPart mimeBodyPart = new MimeBodyPart();
			mimeBodyPart.setContent(body, "text/html; charset=utf-8");

			Multipart multipart = new MimeMultipart();
			multipart.addBodyPart(mimeBodyPart);

			message.setContent(multipart);

			Transport.send(message);

			System.out.println("EMail Sent Successfully!!");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {

		System.out.println("SimpleEmail Start");

		String smtpHostServer = "smtp.gmail.com";
		String emailID = "louis.nguyenba@hitachivantara.com";
//		String emailID = "nguyendat260298@gmail.com";
		
		final String username = "ttrung260298@gmail.com";
        final String password = "cyjodusdjxtmyulo";

		Properties props = System.getProperties();

		props.put("mail.smtp.host", smtpHostServer);
		props.put("mail.smtp.port", "587");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.auth", "true");

		Session session = Session.getInstance(props,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(username, password);
                    }
                });

		sendEmail(session, emailID, "Hello Louis Nguyen Ba", "<b> Bất ngờ chưa bà zà!!! <b>");
	}
}
