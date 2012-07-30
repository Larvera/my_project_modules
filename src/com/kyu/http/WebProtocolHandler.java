package com.kyu.http;

import com.kyu.http.core.SendType;
import com.kyu.http.core.WebProtocol;
import com.kyu.http.core.WebProtocolData;

/**
 * @FileName : HttpHandler.java
 * @Project : sample_project
 * @Date : 2012. 7. 24.
 * @작성자 : 이남규
 * @프로그램설명 :
 */
public class WebProtocolHandler {

	/**
	 * <pre>
	 * process
	 *
	 * <pre>
	 * @param httpData
	 * @throws Exception
	 */
	public WebProtocolData process(WebProtocolData httpData) throws Exception {
		SendType sendType = httpData.getSendType();
		String url = httpData.getRequestUrl();

		// protocol에 따른 URL 체크
		boolean isValid = urlValid(url, sendType);
		if (isValid == false) {
			System.out.println("##process## isValid=" + isValid + ", sendType=" + sendType + ", url=" + url);
			return null;
		}

		// sendType에 따른 객체 생성
		WebProtocol webProtocol = null;
		if (sendType == SendType.SSL) {
			webProtocol = new SSLSender(url);
		} else if (sendType == SendType.HTTP) {
			webProtocol = new HttpSender(url);
		}

		// send
		httpData = webProtocol.send(httpData);
		return httpData;
	}

	/**
	 * <pre>
	 * urlValid
	 * sendType에 따른 URL protocol 체크
	 * <pre>
	 * @param url
	 * @return
	 */
	private boolean urlValid(String url, SendType sendType) {
		int idx = url.indexOf(":");
		String protocol = url.substring(0, idx);
		if (sendType.getProtocol().equalsIgnoreCase(protocol)) {
			return true;
		}
		return false;
	}
}
