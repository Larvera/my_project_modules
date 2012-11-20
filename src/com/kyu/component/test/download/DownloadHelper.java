package com.kyu.component.test.download;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @FileName : DownloadHelper.java
 * @Project : sample_project
 * @Date : 2012. 9. 13.
 * @작성자 : 이남규
 * @프로그램설명 : 파일 다운로드 helper
 */
public class DownloadHelper {

	/** 캐릭터 셋 */
	private final String CHARSET = "UTF-8";

	/**
	 * <pre>
	 * downloadFile
	 *
	 * <pre>
	 * @param request
	 * @param response
	 * @param filePath
	 * @throws Exception
	 */
	public void downloadFile(HttpServletRequest request, HttpServletResponse response, String filePath) {
		FileInputStream fileInputStream = null;
		BufferedInputStream bufferedInputStream = null;
		BufferedOutputStream bufferedOutputStream = null;
		try {
			// download file path
			File file = new File(filePath);

			// response header setting
			setResponseHeader(request, response, file);

			// connection buffer
			fileInputStream = new FileInputStream(file);
			bufferedInputStream = new BufferedInputStream(fileInputStream);
			bufferedOutputStream = new BufferedOutputStream(response.getOutputStream());

			// data output
			int read = 0;
			byte[] buffer = new byte[8192]; // 8k
			while ((read = bufferedInputStream.read(buffer)) != -1) {
				bufferedOutputStream.write(buffer, 0, read);
			}

		} catch (IOException ex) {
			ex.printStackTrace();
			throw new RuntimeException(ex);
		} finally {
			close(bufferedInputStream);
			close(bufferedOutputStream);
		}
	}

	/**
	 * <pre>
	 * setResponseHeader
	 * response header set
	 * <pre>
	 * @param response
	 * @param file
	 * @throws UnsupportedEncodingException
	 */
	private void setResponseHeader(HttpServletRequest request, HttpServletResponse response, File file) {
		int fileLength = (int) file.length();
		String fileName = file.getName();
		String mimeType = getMimeType(request, file);

		response.setContentType(mimeType + "; charset=" + CHARSET);
		response.setHeader("Content-Disposition", "attachment; fileName=\"" + encodeFileName(fileName) + "\";");
		response.setHeader("Content-Transfer-Encoding", "binary");

		if (fileLength > 0) {
			response.setContentLength(fileLength);
		}

	}

	/**
	 * <pre>
	 * getMimeType
	 * mimetype 추출
	 * <pre>
	 * @param request
	 * @param file
	 */
	private String getMimeType(HttpServletRequest request, File file) {
		String mimeType = request.getSession().getServletContext().getMimeType(file.getName());
		if (mimeType == null || mimeType.length() == 0) {
			mimeType = "application/octet-stream";
		}
		return mimeType;
	}

	/**
	 * <pre>
	 * encodeFileName
	 *
	 * <pre>
	 * @param filename
	 * @return
	 * @throws UnsupportedEncodingException
	 */
	private String encodeFileName(String filename) {
		try {
			return URLEncoder.encode(filename, CHARSET);
		} catch (UnsupportedEncodingException ex) {
			ex.printStackTrace();
			throw new RuntimeException(ex);
		}
	}

	/**
	 * <pre>
	 * close
	 *
	 * <pre>
	 * @param out
	 */
	private void close(BufferedOutputStream out) {
		if (out != null) {
			try {
				out.close();
			} catch (IOException ex) {
			}
		}
	}

	/**
	 * <pre>
	 * close
	 *
	 * <pre>
	 * @param input
	 */
	private void close(BufferedInputStream input) {
		if (input != null) {
			try {
				input.close();
			} catch (IOException ex) {
			}
		}
	}
}
