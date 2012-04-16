package com.kyu.ftp;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import com.oroinc.net.ftp.FTP;
import com.oroinc.net.ftp.FTPClient;
import com.oroinc.net.ftp.FTPReply;

/**
 * @FileName : FtpUtil.java
 * @Project : sample_project
 * @Date : 2012. 4. 16.
 * @작성자 : 이남규
 * @프로그램설명 :
 */
public class FTPUtil {

	/** The client. */
	private FTPClient client = null;

	/** binary file type  */
	private final int BINARY_FILE_TYPE = FTP.BINARY_FILE_TYPE;

	/**
	 *  생성자
	 */
	public FTPUtil() {
		client = new FTPClient();
	}

	/**
	 * <pre>
	 * connect
	 * FTP 접속
	 * <pre>
	 * @param remoteIp
	 * @param port
	 * @return
	 * @throws Exception
	 */
	public boolean connect(String remoteIp, int port) throws Exception {
		boolean isConnected = false;
		try {
			client = new FTPClient();
			client.connect(remoteIp, port);

			// 연결 성공 응답 코드 확인
            int reply = client.getReplyCode();
            isConnected = FTPReply.isPositiveCompletion(reply);
            if (isConnected == false) {
            	client.disconnect();
            	System.out.println("##연결 거부!!");
            }

		} catch (IOException ex) {
			if(client.isConnected()) {
                try {
                	client.disconnect();
                } catch(IOException f) {}
            }

			ex.printStackTrace();
			throw ex;
		}

		return isConnected;
	}

	/**
	 * <pre>
	 * cd
	 * 디렉토리 이동
	 * <pre>
	 * @param path
	 * @throws Exception
	 */
	public void cd(String path) throws Exception {
		client.changeWorkingDirectory(path);
	}

	/**
	 * <pre>
	 * login
	 *
	 * <pre>
	 * @param userId
	 * @param password
	 * @return
	 * @throws IOException
	 */
	public boolean login(String userId, String password) throws IOException {
		boolean isFtpLogin = client.login(userId, password);
//		client.enterLocalPassiveMode();
//		client.setFileType(BINARY_FILE_TYPE);
		return isFtpLogin;
	}

	/**
	 * <pre>
	 * getRetrieveFile
	 * FTP 파일 다운로드
	 * <pre>
	 * @param localFilePath
	 * @param remoteFileName
	 * @return
	 * @throws Exception
	 */
	public boolean getRetrieveFile(String localFilePath, String remoteFileName) throws Exception {
		boolean downFlag = false;
		FileOutputStream fos = null;

		try {
			File file = new File(localFilePath);
			fos = new FileOutputStream(file);
			downFlag = client.retrieveFile(remoteFileName, fos);

			if (downFlag == false) {
				deleteFile(file); // 파일 다운로드 실패 시 로컬에 생성한 파일 삭제
			}

		} catch (Exception ex) {
			ex.printStackTrace();
			throw ex;
		} finally {
			if (fos != null) {
				try {
					fos.close();
				} catch (IOException ex) {}
			}
		}

		return downFlag;
	}

	/**
	 * <pre>
	 * deleteFile
	 * 파일 삭제
	 * <pre>
	 * @param file
	 * @return
	 * @throws Exception
	 */
	public boolean deleteFile(File file) throws Exception {
		boolean fileDelFlag = false;
		if (file.exists()) {
			fileDelFlag = file.delete();
		}
		return fileDelFlag;
	}

	/**
	 * <pre>
	 * fileUpload
	 * 파일 업로드
	 * <pre>
	 * @param uploadLocalFilePath
	 * @param uploadFileName
	 */
	public void uploadFile(String uploadLocalFilePath, String uploadFileName) throws Exception {
		InputStream in = null;
		try {
			in = new FileInputStream(uploadLocalFilePath);
			client.setFileType(BINARY_FILE_TYPE);
			if (client.storeFile(uploadFileName, in) == true) {
				System.out.println("업로드 성공!!");
			} else {
				System.out.println("업로드 실패!!");
			}
		} catch (Exception ex) {
			ex.printStackTrace();
			throw ex;
		} finally {
			if (in != null) {
				try {
					in.close();
				} catch (IOException ex) {}
			}
		}
	}

	/**
	 * <pre>
	 * logOut
	 * 로그 아웃
	 * <pre>
	 */
	public void logout() throws Exception {
		client.logout();
	}

	/**
	 * <pre>
	 * disconnect
	 * 접속 끓기
	 * <pre>
	 */
	public void disconnect() throws Exception {
		client.disconnect();
	}
}