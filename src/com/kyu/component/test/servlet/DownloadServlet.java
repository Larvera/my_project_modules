package com.kyu.component.test.servlet;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kyu.component.test.download.DownloadHelper;

/**
 * @FileName : DownloadServlet.java
 * @Project : sample_project
 * @Date : 2012. 9. 13.
 * @작성자 : 이남규
 * @프로그램설명 :
 */
@WebServlet("/download.do")
public class DownloadServlet extends HttpServlet {

	/**  */
	private static final long serialVersionUID = -2852621483949203650L;

	/**
	 * <pre>
	 * service
	 *
	 * <pre>
	 * @param request
	 * @param response
	 */
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) {
		String filePath = "E:\\test\\download\\한글.jpg";
		DownloadHelper downloadHelper = new DownloadHelper();
		downloadHelper.downloadFile(request, response, filePath);
	}
}
