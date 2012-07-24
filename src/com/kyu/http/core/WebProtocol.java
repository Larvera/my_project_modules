package com.kyu.http.core;

/**
 * @FileName : HttpProtocol.java
 * @Project : sample_project
 * @Date : 2012. 7. 24.
 * @작성자 : 이남규
 * @프로그램설명 :
 */
public interface WebProtocol {

	/**
	 * <pre>
	 * send
	 *
	 * <pre>
	 * @param httpData
	 * @return
	 */
	public WebProtocolData send(WebProtocolData httpData);
}
