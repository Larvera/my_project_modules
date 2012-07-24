package com.kyu.http.core;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

/**
 * @FileName : BaseSender.java
 * @Project : sample_project
 * @Date : 2012. 7. 24.
 * @작성자 : 이남규
 * @프로그램설명 :
 */
public class BaseSender {

	/** http 상태 코드(성공) */
	protected int HTTP_STATUS_SC_OK = 200;
	/** request timeout */
	protected int HTTP_STATUS_SC_REQUEST_TIMEOUT = 408;
	/** 서버 내부 오류 */
	protected int HTTP_STATUS_SC_INTERNAL_SERVER_ERROR = 500;

	/**
	 * <pre>
	 * close
	 *
	 * <pre>
	 * @param out
	 */
	protected void close(DataOutputStream out) {
		if (out != null) {
			try {
				out.close();
			} catch (IOException ex) {
			}
		}
	}

	/**
	 * <pre>
	 * close
	 *
	 * <pre>
	 * @param reader
	 */
	protected void close(BufferedReader reader) {
		if (reader != null) {
			try {
				reader.close();
			} catch (IOException ex) {
			}
		}
	}

	/**
	 * <pre>
	 * makeDecode
	 *
	 * <pre>
	 * @param buffer
	 * @return
	 * @throws UnsupportedEncodingException
	 */
	protected String makeDecode(StringBuffer buffer) throws UnsupportedEncodingException {
		String content = URLDecoder.decode(buffer.toString(), "utf-8");
		return content;
	}
}
