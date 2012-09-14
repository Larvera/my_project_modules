package com.kyu.component.test.servlet;

import java.io.IOException;
import java.util.Collection;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

/**
 * @FileName : UploadServlet.java
 * @Project : sample_project
 * @Date : 2012. 9. 3.
 * @작성자 : 이남규
 * @프로그램설명 :
 */
@WebServlet("/upload")
@MultipartConfig(location="E:\\test\\upload")
public class UploadServlet extends HttpServlet {

	/**  */
	private static final long serialVersionUID = 899353714057132370L;

	/* (non-Javadoc)
	 * @see javax.servlet.http.HttpServlet#service(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		Collection<Part> parts = req.getParts();
		System.out.println("parts size=" + parts.size());
		System.out.println();

		for (Part part : parts) {
			String name = part.getName();
			String fileName = null;
			if ("content".equals(name)) {
				System.out.println("name=" + name);
				System.out.println("header=");
				for (String headerName : part.getHeaderNames()) {
					String headerValue = part.getHeader(headerName);
					System.out.println(headerName + ":" + headerValue);

					if ("content-disposition".equals(headerName)) {
						fileName = getFileName(headerValue); // file name 추출
					}
				}
				System.out.println("size=" + part.getSize());
				System.out.println();

				part.write(fileName);
			}
		}

		String nameStr = req.getParameter("nameStr");
		System.out.println(nameStr);
	}

	/**
	 * <pre>
	 * getFileName
	 *
	 * <pre>
	 * @param fileName
	 * @param headerValue
	 * @return
	 */
	private String getFileName(String headerValue) {
		String fileName = null;
		String[] valueArr = headerValue.split("\\s");
		for (String value : valueArr) {
			String[] data = value.split("=");
			if ("filename".equals(data[0])) {
				fileName = data[1].replaceAll("\"", "");
			}
		}
		return fileName;
	}
}
