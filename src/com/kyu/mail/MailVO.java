package com.kyu.mail;

import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/**
 * @FileName : MailVO.java
 * @Project : sample_project
 * @Date : 2012. 4. 3.
 * @작성자 : 이남규
 * @프로그램설명 :
 */
public class MailVO {

	/** 제목 */
	private String subject;
	/** 보낸사람 */
	private String from;
	/** 수신자 */
	private String recipient;
	/** 메일 내용 */
	private String htmlText;
	/** 메일 내용 파일 path */
	private URL htmlUrl;
	/** 첨부 파일 */
	private final List<File> attachedFiles = new ArrayList<File>();;

	/**
	 * @return the htmlUrl
	 */
	public URL getHtmlUrl() {
		return htmlUrl;
	}

	/**
	 * @param htmlUrl the htmlUrl to set
	 */
	public void setHtmlUrl(URL htmlUrl) {
		this.htmlUrl = htmlUrl;
	}

	/**
	 * @return the attachedFiles
	 */
	public List<File> getAttachedFiles() {
		return attachedFiles;
	}

	/**
	 * @param attachedFiles the attachedFiles to set
	 */
	public void setAttachedFiles(File file) {
		this.attachedFiles.add(file);
	}

	/**
	 * @return the subject
	 */
	public String getSubject() {
		return subject;
	}

	/**
	 * @param subject
	 *            the subject to set
	 */
	public void setSubject(String subject) {
		this.subject = subject;
	}

	/**
	 * @return the from
	 */
	public String getFrom() {
		return from;
	}

	/**
	 * @param from
	 *            the from to set
	 */
	public void setFrom(String from) {
		this.from = from;
	}

	/**
	 * @return the recipient
	 */
	public String getRecipient() {
		return recipient;
	}

	/**
	 * @param recipient
	 *            the recipient to set
	 */
	public void setRecipient(String recipient) {
		this.recipient = recipient;
	}

	/**
	 * @return the htmlText
	 */
	public String getHtmlText() {
		return htmlText;
	}

	/**
	 * @param htmlText
	 *            the htmlText to set
	 */
	public void setHtmlText(String htmlText) {
		this.htmlText = htmlText;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "MailVO [subject=" + subject + ", from=" + from + ", recipient=" + recipient + ", htmlText=" + htmlText
				+ ", htmlUrl=" + htmlUrl + ", attachedFiles=" + attachedFiles + "]";
	}
}
