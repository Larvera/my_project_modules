package com.kyu.mail;

import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;

/**
 * @FileName : SMTPAuthenticator.java
 * @Project : sample_project
 * @Date : 2012. 4. 3.
 * @작성자 : 이남규
 * @프로그램설명 :
 */
public class SMTPAuthenticator extends Authenticator {

	/** 사용자 아이디 */
	private final String userId;

	/** 사용자 패스워드 */
	private final String password;

	/**
	 * @param usserId
	 * @param password
	 */
	public SMTPAuthenticator(String usserId, String password) {
		this.userId = usserId;
		this.password = password;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see javax.mail.Authenticator#getPasswordAuthentication()
	 */
	@Override
	public PasswordAuthentication getPasswordAuthentication() {
		return new PasswordAuthentication(userId, password);
	}
}
