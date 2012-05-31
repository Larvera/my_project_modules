package com.kyu.log.test;

import java.io.IOException;

import com.kyu.common.Conf;
import com.kyu.log.LogFileWriter;
import com.kyu.log.LogWriterThread;

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
		new LogProviderThread("LogMakerThread").start();
		new LogWriterThread("LogWriterThread").start();
	}
}
