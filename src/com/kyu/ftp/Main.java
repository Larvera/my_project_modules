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

		String test = "UD";

		if ("D".equals(test)) { // 다운로드
			download();
		} else if ("U".equals(test)) { // 업로드
			upload();
		} else if ("UD".equals(test)) { // 업, 다운로드
			both();
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
		ftpvo.setDownloadRemoteDirectory("/svc/tad/ftp");
		ftpvo.setDownloadLocalFileDirectory("E:\\test\\ftp\\download");
		ftpvo.setDownloadRemoteFileNameList("upload11.txt");
		ftpvo.setDownloadRemoteFileNameList("upload22.txt");
		ftpvo.setDownloadRemoteFileNameList("upload33.txt");
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
		ftpvo.setUploadRemoteDirectory("/svc/tad/ftp");
		ftpvo.setUploadLocalDirectory("E:\\test\\ftp");
		ftpvo.setUploadFileNameList("upload11.txt");
		ftpvo.setUploadFileNameList("upload22.txt");
		ftpvo.setUploadFileNameList("upload33.txt");
		ftpvo.setType(FTPType.PUT);
		handler.job(ftpvo);
	}

	/**
	 * <pre>
	 * both
	 *
	 * <pre>
	 */
	public void both() {
		FTPVO ftpvo = new FTPVO();
		ftpvo.setDownloadRemoteDirectory("/svc/tad/ftp");
		ftpvo.setDownloadLocalFileDirectory("E:\\test\\ftp\\download");
		ftpvo.setDownloadRemoteFileNameList("upload11.txt");
		ftpvo.setDownloadRemoteFileNameList("upload22.txt");
		ftpvo.setDownloadRemoteFileNameList("upload33.txt");

		ftpvo.setUploadRemoteDirectory("/svc/tad/ftp");
		ftpvo.setUploadLocalDirectory("E:\\test\\ftp");
		ftpvo.setUploadFileNameList("upload11.txt");
		ftpvo.setUploadFileNameList("upload22.txt");
		ftpvo.setUploadFileNameList("upload33.txt");

		ftpvo.setType(FTPType.BOTH);
		handler.job(ftpvo);
	}
}
