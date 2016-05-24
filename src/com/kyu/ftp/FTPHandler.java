package com.kyu.ftp;

import java.io.File;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
//			ftp.connect(Conf.getValue("ftp.remote.ip"), Conf.getIntValue("ftp.remote.port"));
//			ftp.login(Conf.getValue("ftp.remote.user"), Conf.getValue("ftp.remote.password"));
			ftp.connect("172.20.53.155", 21);
			ftp.login("administrator", "ncsoft2186!");

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
				downloadProcess(ftpvo);
				uploadProcess(ftpvo);
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
		if (ftpvo.getUploadFilePattern() != null) {
			setUploadFileList(ftpvo);
		}

		ftp.uploadFile(ftpvo.getUploadLocalDirectory()
				, ftpvo.getUploadFileNameList()
				, ftpvo.getUploadRemoteDirectory());
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
		ftp.getRetrieveFile(ftpvo.getDownloadLocalFileDirectory()
				, ftpvo.getDownloadRemoteFileNameList()
				, ftpvo.getDownloadRemoteDirectory()
				, ftpvo.getDownloadFilePattern());
	}

	/**
	 * <pre>
	 * getUploadFileList
	 * 업로드 디렉토리에서 패턴에 일치하는 파일 리스트 추출
	 * <pre>
	 * @param ftpvo
	 * @return
	 */
	public void setUploadFileList(FTPVO ftpvo) {
		String uploadLocalDirectory = ftpvo.getUploadLocalDirectory();
		File directory = new File(uploadLocalDirectory);
		File[] files = directory.listFiles();

		Pattern pattern = Pattern.compile(ftpvo.getUploadFilePattern());
		for (File file : files) {
			String fileName = file.getName();
			Matcher matcher = pattern.matcher(fileName);
			boolean matched = matcher.matches();

			if (matched) { // 패턴 일치
				ftpvo.setUploadFileNameList(fileName);
			}
		}
	}

	/**
	 * <pre>
	 * getFileName
	 * 파일 이름 추출
	 * <pre>
	 * @param filePath
	 * @return
	 */
	@Deprecated
	public String getFileName(String filePath) {
		int lastIdx = filePath.lastIndexOf("\\");
		String result = filePath.substring(lastIdx + 1);
		return result;
	}
}
