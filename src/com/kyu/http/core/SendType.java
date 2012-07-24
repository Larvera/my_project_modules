package com.kyu.http.core;

/**
 * @FileName : SendType.java
 * @Project : sample_project
 * @Date : 2012. 7. 24.
 * @작성자 : 이남규
 * @프로그램설명 :
 */
public enum SendType {
	HTTP("http"), SSL("https");

	/** 프로토콜 */
	private String protocol;

	/**
	 * @param protocol
	 */
	private SendType(String protocol) {
		this.protocol = protocol;
	}

	/**
	 * @return the protocol
	 */
	public String getProtocol() {
		return protocol;
	}



}
