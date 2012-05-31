package com.kyu.log;

/**
 * @FileName : LogHandler.java
 * @Project : sample_project
 * @Date : 2012. 5. 31.
 * @작성자 : 이남규
 * @프로그램설명 :
 */
public class LogHandler {

	/**
	 * <pre>
	 * job
	 * 큐에 로그 제공
	 * <pre>
	 * @param requestLogData
	 */
	public static void job(RequestLogData requestLogData) {
		RequestLogDataQueue requestQueue = RequestLogDataQueue.getInstance();
		requestQueue.putRequestLogData(requestLogData);
	}
}
