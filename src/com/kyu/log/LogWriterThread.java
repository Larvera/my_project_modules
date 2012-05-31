package com.kyu.log;


/**
 * @FileName : LogWriterThread.java
 * @Project : sample_project
 * @Date : 2012. 5. 31.
 * @작성자 : 이남규
 * @프로그램설명 :
 */
public class LogWriterThread extends Thread {

	/** queue 저장 객체 */
	private final RequestLogDataQueue requestQueue;

	/**
	 * @param requestQueue
	 */
	public LogWriterThread(String threadName) {
		super(threadName);
		this.requestQueue = RequestLogDataQueue.getInstance();
	}

	/* (non-Javadoc)
	 * @see java.lang.Thread#run()
	 */
	@Override
	public void run() {

		while (true) {
			RequestLogData requestLogData = requestQueue.getRequestLogData();
			System.out.println("##LogWriterThread## (run) logIdx=" + requestLogData.getLogWriteIdx() + ", Thread name=" + Thread.currentThread().getName() + ", requestLogData=" + requestLogData);

			try {
				LogFileWriter.logWrite(requestLogData);

			} catch (Exception ex) {
				System.out.println("##LogWriterThread## (exception) requestLogData=" + requestLogData);
				ex.printStackTrace();
			}
		}
	}
}
