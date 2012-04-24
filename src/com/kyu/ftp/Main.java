package com.kyu.ftp;

import com.kyu.common.Conf;

/**
 * @FileName : Main.java
 * @Project : sample_project
 * @Date : 2012. 4. 16.
 * @작성자 : 이남규
 * @프로그램설명 :
 */
public class Main {

	/**  */
	private FTPHandler handler;

	/**
	 * <pre>
	 * main
	 *
	 * <pre>
	 * @param args
	 * @throws Exception
	 */
	public static void main(String[] args) throws Exception {
		Main main = new Main();
		main.start();
	}

	/**
	 * <pre>
	 * start
	 *
	 * <pre>
	 * @throws Exception
	 */
	public void start() throws Exception {
		Conf.init();
		handler = new FTPHandler();

		String test = "D";

		if ("D".equals(test)) { // 다운로드
			download();
		} else if ("U".equals(test)) { // 업로드
			upload();
		} else if ("UD".equals(test)) { // 업, 다운로드

		}
	}

	/**
	 * <pre>
	 * download
	 *
	 * <pre>
	 */
	public void download() {
		FTPVO ftpvo = new FTPVO();
		ftpvo.setRemoteDirectory("/svc/tad");
		ftpvo.setRemoteFileName("sh.tar.gz");
		ftpvo.setLocalFilePath("E:\\test\\ftp\\sh.tar.gz");
		ftpvo.setType(FTPType.GET);
		handler.job(ftpvo);
	}

	/**
	 * <pre>
	 * upload
	 *
	 * <pre>
	 */
	public void upload() {
		FTPVO ftpvo = new FTPVO();
		ftpvo.setRemoteDirectory("/svc/tad/ftp");
		ftpvo.setUploadFileName("upload111.txt");
		ftpvo.setUploadLocalFilePath("E:\\test\\ftp\\upload.txt");
		ftpvo.setType(FTPType.PUT);
		handler.job(ftpvo);
	}
}
