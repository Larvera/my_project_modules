package com.kyu.mail;

import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import com.kyu.common.Conf;

public class SimpleMailTest {

	public static void main(String[] args) throws Exception {

		Conf.init();

		System.out.println("Sending mail...");
		Properties props = new Properties();
		props.setProperty("mail.transport.protocol", "smtp");
		props.setProperty("mail.smtp.starttls.enable", "true");
		props.setProperty("mail.smtp.auth", Conf.getValue("mail.smtp.auth"));
		props.setProperty("mail.host", Conf.getValue("mail.host"));
		// props.setProperty("mail.port", "587");

		SMTPAuthenticator smtpAuthenticator = new SMTPAuthenticator(Conf.getValue("mail.smtp.user"), Conf.getValue("mail.smtp.password"));

		Session mailSession = Session.getDefaultInstance(props, null);
		mailSession.setDebug(true);
		Transport transport = mailSession.getTransport();
		MimeMessage message = new MimeMessage(mailSession);
		message.setSubject("HTML  mail with images");
		message.setFrom(new InternetAddress("lng1982@naver.com"));
		message.addRecipient(Message.RecipientType.TO, new InternetAddress("lng1982@incross.com"));

		//
		// This HTML mail have to 2 part, the BODY and the embedded image
		//
		MimeMultipart multipart = new MimeMultipart("related");

		// first part (the html)
		BodyPart messageBodyPart = new MimeBodyPart();
		String htmlText = "<H1>Hello</H1><img src=\"cid:image\">";
		messageBodyPart.setContent(htmlText, "text/html");

		// add it
		multipart.addBodyPart(messageBodyPart);

		// second part (the image)
		messageBodyPart = new MimeBodyPart();
		DataSource fds = new FileDataSource("E:\\test\\mail\\allpopup.jpg");
		messageBodyPart.setDataHandler(new DataHandler(fds));
		messageBodyPart.setHeader("Content-ID", "<image>");
		messageBodyPart.setFileName(fds.getName());

		// add it
		multipart.addBodyPart(messageBodyPart);

		// put everything together
		message.setContent(multipart);
		transport.connect();
		transport.sendMessage(message, message.getRecipients(Message.RecipientType.TO));
		transport.close();
	}
}
