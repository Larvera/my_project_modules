package com.kyu.http;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSession;

/**
 * @FileName : SSLHostnameVerifier.java
 * @Project : sample_project
 * @Date : 2012. 7. 24.
 * @작성자 : 이남규
 * @프로그램설명 :
 */
public class SSLHostnameVerifier implements HostnameVerifier {

	/*
	 * (non-Javadoc)
	 *
	 * @see javax.net.ssl.HostnameVerifier#verify(java.lang.String,
	 * javax.net.ssl.SSLSession)
	 */
	@Override
	public boolean verify(String paramString, SSLSession paramSSLSession) {
		System.out.println("##verify## paramString=" + paramString + ", peerHost=" + paramSSLSession.getPeerHost());
		return true;
	}
}
