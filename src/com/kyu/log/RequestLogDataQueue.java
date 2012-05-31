package com.kyu.log;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @FileName : RequestLogDataQueue.java
 * @Project : sample_project
 * @Date : 2012. 5. 31.
 * @작성자 : 이남규
 * @프로그램설명 :
 */
public class RequestLogDataQueue {

	/** log 저장 queue instance */
	private final Queue<RequestLogData> queue = new LinkedList<RequestLogData>();

	/** singleton instance */
	private static final RequestLogDataQueue requestLogDataQueue = new RequestLogDataQueue();

	/**
	 * 객체 생성 차단
	 */
	private RequestLogDataQueue() {
	}

	/**
	 * <pre>
	 * getInstance
	 * 싱글톤 객체 return
	 * <pre>
	 * @return
	 */
	public static RequestLogDataQueue getInstance() {
		return requestLogDataQueue;
	}

	/**
	 * <pre>
	 * getRequestLogData
	 * 로그 데이터 get
	 * <pre>
	 * @return
	 */
	public synchronized RequestLogData getRequestLogData() {
		while (queue.peek() == null) {
			try {
				wait(); // queue에 데이터가 없으면 thread wait
			} catch (InterruptedException e) {
				System.out.println("##getRequest## thread wait failed");
				e.printStackTrace();
			}
		}
		// queue에 있는 데이터 return 후 삭제
		return queue.remove();
	}

	/**
	 * <pre>
	 * putRequestLogData
	 * 로그 데이터 put
	 * <pre>
	 * @param requestLogData
	 */
	public synchronized void putRequestLogData(RequestLogData requestLogData) {
		queue.offer(requestLogData);
		notifyAll();
	}
}
