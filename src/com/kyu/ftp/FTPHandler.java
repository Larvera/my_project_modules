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

	/** FTP 유틸 */
	private final FTPUtil ftp;

	/**
	 * 생성자
	 */
	public FTPHandler() {
		ftp = new FTPUtil();
	}

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
			// FTP 연결
			ftp.connect(Conf.getValue("ftp.remote.ip"), Conf.getIntValue("ftp.remote.port"));

			// FTP 로그인
			ftp.login(Conf.getValue("ftp.remote.user"), Conf.getValue("ftp.remote.password"));

			FTPType type = ftpvo.getType();

			// 파일 다운로드
			if (FTPType.GET == type) {
				downloadProcess(ftpvo);
			}
			// 파일 업로드
			else if(FTPType.PUT == type) {
				uploadProcess(ftpvo);
			}
			// 파일 다운로드, 업로드
			else if(FTPType.BOTH == type) {
				// 차후 구현
			}
			// type error
			else {
				System.out.println("##job invalid type## type=" + type);
				isSuccess = false;
			}

			ftp.logout();
			ftp.disconnect();

		} catch (Exception ex) {
			System.out.println("##job exception## ftpvo=" + ftpvo);
			ex.printStackTrace();
			isSuccess = false;
		}

		return isSuccess;
	}

	/**
	 * <pre>
	 * uploadProcess
	 * 파일 업로드
	 * <pre>
	 * @param ftpvo
	 * @throws Exception
	 */
	public void uploadProcess(FTPVO ftpvo) throws Exception {
		ftp.uploadFile(ftpvo.getUploadLocalFilePath(), ftpvo.getUploadFileName(), ftpvo.getRemoteDirectory());
	}

	/**
	 * <pre>
	 * downloadProcess
	 * 파일 다운로드
	 * <pre>
	 * @param ftpvo
	 * @throws Exception
	 */
	public void downloadProcess(FTPVO ftpvo) throws Exception {
		ftp.getRetrieveFile(ftpvo.getLocalFilePath(), ftpvo.getRemoteFileName(), ftpvo.getRemoteDirectory());
	}
}
