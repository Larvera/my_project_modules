package com.kyu.http.test;

import java.io.IOException;

import com.kyu.http.WebProtocolHandler;
import com.kyu.http.core.SendType;
import com.kyu.http.core.WebProtocolData;

/**
 * @FileName : SimpleHttpSendTest.java
 * @Project : sample_project
 * @Date : 2012. 7. 24.
 * @작성자 : 이남규
 * @프로그램설명 :
 */
public class WebProtocolSendTest {

	/**
	 * <pre>
	 * main
	 *
	 * <pre>
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws Exception {
		WebProtocolSendTest sendTest = new WebProtocolSendTest();
		sendTest.job();
	}

	/**
	 * <pre>
	 * job
	 *
	 * <pre>
	 * @throws Exception
	 */
	public void job() throws Exception {
		WebProtocolData data = makeData();
		WebProtocolHandler handler = new WebProtocolHandler();
		data = handler.process(data);

		System.out.println("##job## data=" + data);
	}

	/**
	 * <pre>
	 * makeData
	 *
	 * <pre>
	 * @return
	 */
	private WebProtocolData makeData() {
		WebProtocolData data = new WebProtocolData();

//		String url = "http://220.103.245.206:8001";
		String url = "https://220.103.245.206:8443";

		data.setRequestUrl(url);
		data.setRequestContentType("application/xml");
		data.setRequestEncoding("utf-8");
		data.setRequestContent("http trsnsper test!!!!!!");
		data.setSendType(SendType.SSL);
		return data;
	}
}
