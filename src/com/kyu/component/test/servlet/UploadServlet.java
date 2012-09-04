package com.kyu.component.test.servlet;

import java.io.IOException;
import java.util.Collection;

import javax.servlet.ServletException;
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
public class UploadServlet extends HttpServlet {

	/**  */
	private static final long serialVersionUID = 899353714057132370L;

	/* (non-Javadoc)
	 * @see javax.servlet.http.HttpServlet#service(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		Collection<Part> parts = req.getParts();
		for (Part part : parts) {
			System.out.println("name=" + part.getName());
			System.out.println("Header=");
			for (String headerName : part.getHeaderNames()) {
				System.out.println(headerName);
				System.out.println(part.getHeader(headerName));
			}
			System.out.println("Size=");
			System.out.println(part.getSize());
			part.write(part.getName() + "-down");
		}
	}
}
