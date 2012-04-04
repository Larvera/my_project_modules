package com.kyu.mail;

import java.io.File;
import java.net.URL;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import com.kyu.common.Conf;

/**
 * @FileName : MailSender.java
 * @Project : sample_project
 * @Date : 2012. 4. 3.
 * @작성자 : 이남규
 * @프로그램설명 :
 */
public class MailSender {

	/** 로그 출력 모드 */
	private final static boolean DEBUG = true;

	/**
	 *  no create instance
	 */
	private MailSender() {
        throw new AssertionError();
    }

	/**
	 * <pre>
	 * send
	 * 메일 전송
	 * <pre>
	 * @param mailVO
	 * @return
	 * @throws Exception
	 */
	public static boolean sendMail(MailVO mailVO) {
		boolean isSuccess = false;
		try {
			System.out.println("#########################################");
			System.out.println("## 메일 전송 START");
			System.out.println("#########################################");
			MimeMessage message = createMimeMessage();

			// 봉투
			configureMessage(mailVO, message);

			// 속봉투
			MimeMultipart mimeMultipart = new MimeMultipart("related"); // html 메시지를 나타내는 부분과 이미지를 나타내는 부분으로 구성되는 multi-part메시지 생성

			// 보낼 메세지 생성
			makeBodyPart(mailVO.getHtmlUrl(), mailVO.getHtmlText(), mimeMultipart);

			// 첨부 파일 셋팅
			if (mailVO.getAttachedFiles().isEmpty() == false) {
				attachFiles(mailVO, mimeMultipart);
			}

			message.setContent(mimeMultipart);
			Transport.send(message);

		} catch (Exception ex) {
			ex.printStackTrace();
			isSuccess = false;
		}

		return isSuccess;
	}

	/**
	 * <pre>
	 * makeBodyPart
	 * 본문 내용 생성
	 * <pre>
	 * @param htmlUrl
	 * @param htmlbody
	 * @param mimeMultipart
	 * @throws Exception
	 */
	private static void makeBodyPart(URL htmlUrl, String htmlbody, MimeMultipart mimeMultipart) throws Exception {
		HashMap<String, String> cidMap = new HashMap<String, String>();
		BodyPart messageBodyPart = new MimeBodyPart();

		Pattern p = Pattern.compile("<img.*?src\\s*=\\s*['\"](.*?)['\"]", Pattern.DOTALL | Pattern.CASE_INSENSITIVE);
		Matcher m = p.matcher(htmlbody);

		StringBuilder copiedHtml = new StringBuilder();
		int curpos = 0;
		int cidCnt = 1;
		while (m.find()) {
			String imgSrc = m.group(1);
			int start = m.start(1);
			int end = m.end(1);

			URL url = new URL(htmlUrl, imgSrc);
			String cid = "identifiler" + String.valueOf(cidCnt++);
			copiedHtml.append(htmlbody.substring(curpos, start));
			copiedHtml.append("cid:").append(cid);
			curpos = end;
			cidMap.put(cid, url.getPath());
		}

		copiedHtml.append(htmlbody.substring(curpos));
		messageBodyPart.setContent(copiedHtml.toString(), "text/html; charset=UTF-8");
		mimeMultipart.addBodyPart(messageBodyPart); // 본문 내용 추가

		Iterator<String> keyIter = cidMap.keySet().iterator();
		while (keyIter.hasNext()) {
			String cid = keyIter.next();
			String path = cidMap.get(cid);

			System.out.println("cid : " + cid);
			System.out.println("path : " + path);

			BodyPart messageBodyAttachPart = new MimeBodyPart();
            DataSource source = new FileDataSource(path);
            messageBodyAttachPart.setDataHandler(new DataHandler(source));
            messageBodyAttachPart.setHeader("Content-ID", cid);

            mimeMultipart.addBodyPart(messageBodyAttachPart); // image data 추가
		}
	}

	/**
     * <pre>
     * attachFiles
     * 첨부 파일 추가
     * <pre>
     * @param mailVO
     * @param multipart
     * @throws MessagingException
     */
    private static void attachFiles(MailVO mailVO, Multipart multipart) throws MessagingException {
        for (File file : mailVO.getAttachedFiles()) {
            BodyPart messageBodyPart = new MimeBodyPart();
            DataSource source = new FileDataSource(file);
            messageBodyPart.setDataHandler(new DataHandler(source));

            multipart.addBodyPart(messageBodyPart);
        }
    }

	/**
	 * <pre>
	 * configureMessage
	 * 제목, 받는 사람, 보낸 사람 셋팅
	 * <pre>
	 * @param mailVO
	 * @param message
	 * @throws MessagingException
	 * @throws AddressException
	 */
	private static void configureMessage(MailVO mailVO, MimeMessage message) throws MessagingException, AddressException {
		message.setSubject(mailVO.getSubject());
		message.setFrom(new InternetAddress(mailVO.getFrom()));
		message.setSentDate(new Date());
		message.addRecipient(Message.RecipientType.TO, new InternetAddress(mailVO.getRecipient()));
		/*
		 * RecipientType
		 * BCC : Blind Carbon Copy (숨은 참조인)
		 * CC : Carbon Copy (참조인)
		 * TO : 받는 사람
		 * */
	}

	/**
	 * <pre>
	 * Message 객체 생성
	 * message
	 * <pre>
	 * @return
	 */
	private static MimeMessage createMimeMessage() {
		Properties props = makeProp();

		String userId = Conf.getValue("mail.smtp.user");
		String password = Conf.getValue("mail.smtp.password");
		SMTPAuthenticator smtpAuthenticator = new SMTPAuthenticator(userId, password); // SMTP 인증 정보 객체

		Session mailSession = Session.getDefaultInstance(props, null); // SMTP 서버의 연결 세션 객체 생성
		mailSession.setDebug(DEBUG);

		MimeMessage message = new MimeMessage(mailSession); // 보낼 메시지 객체 생성
		return message;
	}

	/**
	 * <pre>
	 * makeProp
	 * 메일 설정 셋팅
	 * <pre>
	 * @return
	 */
	private static Properties makeProp() {
		Properties props = new Properties();
		props.setProperty("mail.transport.protocol", "smtp");
        props.setProperty("mail.smtp.starttls.enable", "true");
		props.setProperty("mail.host", Conf.getValue("mail.host"));
        props.setProperty("mail.smtp.auth", Conf.getValue("mail.smtp.auth"));
		return props;
	}
}
