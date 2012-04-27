package com.kyu.process.test;

import java.io.OutputStream;

/**
 * @FileName : PingTest.java
 * @Project : sample_project
 * @Date : 2012. 4. 27.
 * @작성자 : 이남규
 * @프로그램설명 :
 */
public class PingTest {
	public static void main(String[] args) {
		try {
			Process p = Runtime.getRuntime().exec("ping yahoo.co.kr");
			byte[] msg = new byte[128];
			int len;

			while ((len = p.getInputStream().read(msg)) > 0) {
				System.out.print(new String(msg, 0, len));
			}

			byte[] rb = new byte[] { (byte) '\n' }; // rs.getBytes();
			OutputStream os = p.getOutputStream();
			os.write(rb);
			os.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
