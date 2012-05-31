package com.kyu.log.test;

import com.kyu.log.RequestLogData;
import com.kyu.log.RequestLogDataQueue;

/**
 * @FileName : LogMakerThread.java
 * @Project : sample_project
 * @Date : 2012. 5. 31.
 * @작성자 : 이남규
 * @프로그램설명 :
 */
public class LogProviderThread extends Thread {

	private final RequestLogDataQueue requestLogDataQueue;

	/** log 생성 idx */
	private int logIdx;

	/**
	 * @param requestLogDataQueue
	 */
	public LogProviderThread(String threadName) {
		super(threadName);
		this.requestLogDataQueue = RequestLogDataQueue.getInstance();
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see java.lang.Thread#run()
	 */
	@Override
	public void run() {

		while (true) {
			RequestLogData requestLogData = makeLogMessage();
			requestLogDataQueue.putRequestLogData(requestLogData);

			++logIdx; // log 생성 count 증가
			System.out.println("##LogMakerThread## (run) logIdx=" + logIdx + ", Thread name=" + Thread.currentThread().getName() + ", requestLogData=" + requestLogData);

			try {
				Thread.sleep(100);
			} catch (InterruptedException ex) {
				System.out.println("##LogMakerThread## (exception)");
				ex.printStackTrace();
			}
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
		request.setLogWriteIdx(logIdx);
		return request;
	}
}
