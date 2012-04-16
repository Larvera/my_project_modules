package com.kyu.ftp;

import com.kyu.common.Conf;

/**
 * @FileName : FTPHandler.java
 * @Project : sample_project
 * @Date : 2012. 4. 16.
 * @작성자 : 이남규
 * @프로그램설명 :
 */
public class FTPHandler {

	/** FTP 아이피 */
	private final String IP;
	/** FTP 포트 */
	private final int PORT;
	/** FTP 접속 아이디 */
	private final String USER;
	/** FTP 접속 패스워드 */
	private final String PASSWORD;

	/**
	 * 초기화
	 */
	public FTPHandler() {
		IP = Conf.getValue("ftp.remote.ip");
		PORT = Conf.getIntValue("ftp.remote.port");
		USER = Conf.getValue("ftp.remote.user");
		PASSWORD = Conf.getValue("ftp.remote.password");
	}

	public boolean job(FTPVO ftpvo) {
		boolean isSuccess = false;
		FTPUtil ftp = null;
		try {
			ftp = new FTPUtil();

			// FTP 연결
			ftp.connect(IP, PORT);

			// FTP 로그인
			ftp.login(USER, PASSWORD);

			// FTP remote 디렉토리 이동
			ftp.cd(ftpvo.getRemoteDirectory());

			ftp.logout();
			ftp.disconnect();

		} catch (Exception ex) {
			ex.printStackTrace();
			isSuccess = false;
		}

		return isSuccess;
	}
}
