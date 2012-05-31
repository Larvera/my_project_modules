package com.kyu.log;

import java.io.IOException;

import com.kyu.common.Conf;


/**
 * @FileName : Main.java
 * @Project : sample_project
 * @Date : 2012. 5. 31.
 * @작성자 : 이남규
 * @프로그램설명 :
 */
public class Main {

	/**
	 * <pre>
	 * main
	 *
	 * <pre>
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		Conf.init();
		LogFileWriter.init();
		new LogWriterThread("LogWriterThread").start(); // server 로그 기록 쓰레드 활성

		Main main = new Main();
		main.job();
	}

	/**
	 * <pre>
	 * job
	 *
	 * <pre>
	 */
	private void job() {
		for (int i = 0; i < 10000; i++) {
			LogHandler.job(makeLogMessage());
		}
	}

	/**
	 * <pre>
	 * makeLogMessage
	 * test 메시지 생성
	 *
	 * <pre>
	 * @return
	 */
	private RequestLogData makeLogMessage() {
		RequestLogData request = new RequestLogData();
		request.setDate(System.currentTimeMillis());
		request.setExecutionTime(303);
		request.setResult("success");
		request.setResultCode("0");
		request.setServiceCode("A0001");
		request.setTransactionId("201102010102020");
		return request;
	}
}
