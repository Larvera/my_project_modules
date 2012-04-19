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

	/**
	 * <pre>
	 * job
	 *
	 * <pre>
	 * @param ftpvo
	 * @return
	 */
	public boolean job(FTPVO ftpvo) {
		boolean isSuccess = false;
		try {
			FTPUtil ftp = new FTPUtil();

			// FTP 연결
			ftp.connect(Conf.getValue("ftp.remote.ip"), Conf.getIntValue("ftp.remote.port"));

			// FTP 로그인
			ftp.login(Conf.getValue("ftp.remote.user"), Conf.getValue("ftp.remote.password"));

			FTPType type = ftpvo.getType();
			if (FTPType.GET == type) {

			} else if(FTPType.PUT == type) {

			} else if(FTPType.BOTH == type) {

			} else {
				System.out.println("##job invalid type## type=" + type);
				isSuccess = false;
			}

			// FTP remote 디렉토리 이동
			ftp.cd(ftpvo.getRemoteDirectory());

			ftp.logout();
			ftp.disconnect();

		} catch (Exception ex) {
			System.out.println("##job exception## ftpvo=" + ftpvo);
			ex.printStackTrace();
			isSuccess = false;
		}

		return isSuccess;
	}

	public boolean uploadProcess() {
		return false;
	}

	public boolean downloadProcess() {
		return false;
	}
}
