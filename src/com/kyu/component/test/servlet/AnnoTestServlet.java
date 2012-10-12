package com.kyu.component.test.servlet;

import java.io.IOException;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

/**
 * @FileName : AnnoTestController.java
 * @Project : sample_project
 * @Date : 2012. 9. 3.
 * @작성자 : 이남규
 * @프로그램설명 : annotation test servlet 3.0
 */
@WebServlet(asyncSupported=false, name="HelloServlet", urlPatterns = {"/hello.do", "/test.do"})
public class AnnoTestServlet extends GenericServlet {

	/**  */
	private static final long serialVersionUID = 8775905956207020422L;

	/* (non-Javadoc)
	 * @see javax.servlet.GenericServlet#service(javax.servlet.ServletRequest, javax.servlet.ServletResponse)
	 */
	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		res.getWriter().println("test!!");
	}
}
