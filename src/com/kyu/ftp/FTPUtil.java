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
            	System.out.println("##connect failed## remoteIp=" + remoteIp + ", port=" + port);
            }

		} catch (IOException ex) {
			if(client.isConnected()) {
                try {
                	client.disconnect();
                } catch(IOException f) {}
            }

			System.out.println("##connect exception## remoteIp=" + remoteIp + ", port=" + port);
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
	 * @throws IOException
	 */
	public void cd(String path) throws IOException {
		client.changeWorkingDirectory(path);
	}

	/**
	 * <pre>
	 * login
	 * 로그인
	 * <pre>
	 * @param userId
	 * @param password
	 * @return
	 * @throws IOException
	 */
	public boolean login(String userId, String password) throws IOException {
		boolean isFtpLogin = client.login(userId, password);
		client.enterLocalPassiveMode();
		client.setFileType(BINARY_FILE_TYPE);
		return isFtpLogin;
	}

	/**
	 * <pre>
	 * logOut
	 * 로그 아웃
	 * <pre>
	 * @throws IOException
	 */
	public void logout() throws IOException  {
		client.logout();
	}

	/**
	 * <pre>
	 * disconnect
	 * 접속 끓기
	 * <pre>
	 * @throws IOException
	 */
	public void disconnect() throws IOException {
		client.disconnect();
	}

	/**
	 * <pre>
	 * deleteFile
	 * 파일 삭제
	 * <pre>
	 * @param file
	 * @return
	 */
	public boolean deleteFile(File file) {
		boolean fileDelFlag = false;
		if (file.exists()) {
			fileDelFlag = file.delete();
		}
		return fileDelFlag;
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
				boolean isDelete = deleteFile(file); // 파일 다운로드 실패 시 로컬에 생성한 파일 삭제
				System.out.println("##getRetrieveFile failed## remoteFileName=" + remoteFileName + ", localFilePath=" + remoteFileName + ", isDelete=" + isDelete);
			}

		} catch (Exception ex) {
			System.out.println("##getRetrieveFile exception## remoteFileName=" + remoteFileName + ", localFilePath=" + remoteFileName);
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
				System.out.println("##uploadFile success## uploadLocalFilePath=" + uploadLocalFilePath + ", uploadFileName=" + uploadFileName);
			} else {
				System.out.println("##uploadFile failed## uploadLocalFilePath=" + uploadLocalFilePath + ", uploadFileName=" + uploadFileName);
			}

		} catch (Exception ex) {
			System.out.println("##uploadFile exception## uploadLocalFilePath=" + uploadLocalFilePath + ", uploadFileName=" + uploadFileName);
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
}