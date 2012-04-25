package com.kyu.ftp;

import java.util.ArrayList;
import java.util.List;

/**
 * @FileName : FTPVO.java
 * @Project : sample_project
 * @Date : 2012. 4. 16.
 * @작성자 : 이남규
 * @프로그램설명 :
 */
public class FTPVO {

	/** 유저 아이디 */
	private String userId;
	/** 패스워드 */
	private String password;
	/** FTP IP */
	private String remoteIp;
	/** GET, PUT, BOTH 구분 */
	private FTPType type;
	/** FTP port  */
	private int port;

	/** 다운로드 받을 원격지 디렉토리 */
	private String downloadRemoteDirectory;
	/** 원격지에서 다운로드 받는 파일의 로컬 저장 디렉토리 */
	private String downloadLocalFileDirectory;
	/** 다운로드 파일 패턴 */
	private String downloadFilePattern;
	/** 다운로드 받을 원격지 파일 리스트 */
	private final List<String> downloadRemoteFileNameList = new ArrayList<String>();

	/** 업로드 할 로컬 저장 디렉토리 */
	private String uploadLocalDirectory;
	/** 업로드 할 파일들의 원격 저장 디렉토리 */
	private String uploadRemoteDirectory;
	/** 업로드 파일 패턴 */
	private String uploadFilePattern;
	/** 업로드 할 파일 리스트 */
	private final List<String> uploadLocalFileNameList = new ArrayList<String>();

	public String getDownloadFilePattern() {
		return downloadFilePattern;
	}

	public void setDownloadFilePattern(String downloadFilePattern) {
		this.downloadFilePattern = downloadFilePattern;
	}

	public String getUploadFilePattern() {
		return uploadFilePattern;
	}

	public void setUploadFilePattern(String uploadFilePattern) {
		this.uploadFilePattern = uploadFilePattern;
	}

	public String getDownloadRemoteDirectory() {
		return downloadRemoteDirectory;
	}

	public void setDownloadRemoteDirectory(String downloadRemoteDirectory) {
		this.downloadRemoteDirectory = downloadRemoteDirectory;
	}

	public String getDownloadLocalFileDirectory() {
		return downloadLocalFileDirectory;
	}

	public void setDownloadLocalFileDirectory(String downloadLocalFileDirectory) {
		this.downloadLocalFileDirectory = downloadLocalFileDirectory;
	}

	public List<String> getDownloadRemoteFileNameList() {
		return downloadRemoteFileNameList;
	}

	public void setDownloadRemoteFileNameList(String downloadFileName) {
		this.downloadRemoteFileNameList.add(downloadFileName);
	}

	public List<String> getUploadLocalFileNameList() {
		return uploadLocalFileNameList;
	}

	public String getUploadRemoteDirectory() {
		return uploadRemoteDirectory;
	}

	public void setUploadRemoteDirectory(String uploadRemoteDirectory) {
		this.uploadRemoteDirectory = uploadRemoteDirectory;
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

	public String getRemoteIp() {
		return remoteIp;
	}

	public void setRemoteIp(String remoteIp) {
		this.remoteIp = remoteIp;
	}

	public FTPType getType() {
		return type;
	}

	public void setType(FTPType type) {
		this.type = type;
	}

	public int getPort() {
		return port;
	}

	public void setPort(int port) {
		this.port = port;
	}

	public String getUploadLocalDirectory() {
		return uploadLocalDirectory;
	}

	public void setUploadLocalDirectory(String uploadLocalDirectory) {
		this.uploadLocalDirectory = uploadLocalDirectory;
	}

	public List<String> getUploadFileNameList() {
		return uploadLocalFileNameList;
	}

	public void setUploadFileNameList(String uploadFileName) {
		this.uploadLocalFileNameList.add(uploadFileName);
	}

	@Override
	public String toString() {
		return "FTPVO [userId=" + userId + ", password=" + password + ", remoteIp=" + remoteIp + ", type=" + type
				+ ", port=" + port + ", downloadRemoteDirectory=" + downloadRemoteDirectory
				+ ", downloadLocalFileDirectory=" + downloadLocalFileDirectory + ", downloadFilePattern="
				+ downloadFilePattern + ", downloadRemoteFileNameList=" + downloadRemoteFileNameList
				+ ", uploadLocalDirectory=" + uploadLocalDirectory + ", uploadRemoteDirectory=" + uploadRemoteDirectory
				+ ", uploadFilePattern=" + uploadFilePattern + ", uploadLocalFileNameList=" + uploadLocalFileNameList
				+ "]";
	}

	public static void main(String[] args) {
		FTPVO ftpvo = new FTPVO();
		System.out.println(ftpvo);
	}
}
