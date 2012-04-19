package com.kyu.ftp;

/**
 * @FileName : FTPVO.java
 * @Project : sample_project
 * @Date : 2012. 4. 16.
 * @작성자 : 이남규
 * @프로그램설명 :
 */
public class FTPVO {

	/** 외부 아이피 */
	private String remoteIp;
	private String remoteDirectory;
	private String userId;
	private String password;
	private String localFilePath;
	private String remoteFileName;
	private String uploadLocalFilePath;
	private String uploadFileName;
	private int port;
	private FTPType type;

	public FTPType getType() {
		return type;
	}

	public void setType(FTPType type) {
		this.type = type;
	}

	public String getRemoteIp() {
		return remoteIp;
	}

	public void setRemoteIp(String remoteIp) {
		this.remoteIp = remoteIp;
	}

	public String getRemoteDirectory() {
		return remoteDirectory;
	}

	public void setRemoteDirectory(String remoteDirectory) {
		this.remoteDirectory = remoteDirectory;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getLocalFilePath() {
		return localFilePath;
	}

	public void setLocalFilePath(String localFilePath) {
		this.localFilePath = localFilePath;
	}

	public String getRemoteFileName() {
		return remoteFileName;
	}

	public void setRemoteFileName(String remoteFileName) {
		this.remoteFileName = remoteFileName;
	}

	public String getUploadLocalFilePath() {
		return uploadLocalFilePath;
	}

	public void setUploadLocalFilePath(String uploadLocalFilePath) {
		this.uploadLocalFilePath = uploadLocalFilePath;
	}

	public String getUploadFileName() {
		return uploadFileName;
	}

	public void setUploadFileName(String uploadFileName) {
		this.uploadFileName = uploadFileName;
	}

	public int getPort() {
		return port;
	}

	public void setPort(int port) {
		this.port = port;
	}

	@Override
	public String toString() {
		return "FTPVO [remoteIp=" + remoteIp + ", remoteDirectory=" + remoteDirectory + ", userId=" + userId
				+ ", password=" + password + ", localFilePath=" + localFilePath + ", remoteFileName=" + remoteFileName
				+ ", uploadLocalFilePath=" + uploadLocalFilePath + ", uploadFileName=" + uploadFileName + ", port="
				+ port + "]";
	}
}
