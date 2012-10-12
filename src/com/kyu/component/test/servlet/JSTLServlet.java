package com.kyu.component.test.servlet;

import java.io.IOException;

import javax.servlet.GenericServlet;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

/**
 * @FileName : JSTLServlet.java
 * @Project : sample_project
 * @Date : 2012. 9. 3.
 * @작성자 : 이남규
 * @프로그램설명 :
 */
@WebServlet("/jstl.do")
public class JSTLServlet extends GenericServlet {

	/**  */
	private static final long serialVersionUID = -7027980841307374226L;

	/* (non-Javadoc)
	 * @see javax.servlet.GenericServlet#service(javax.servlet.ServletRequest, javax.servlet.ServletResponse)
	 */
	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException,
			IOException {

		RequestDispatcher dispatcher = req.getRequestDispatcher("/jsp/jstlTest.jsp");
		dispatcher.forward(req, res);
	}



}
