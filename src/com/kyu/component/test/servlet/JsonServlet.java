package com.kyu.component.test.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kyu.component.test.json.JsonResultVO;
import com.kyu.component.test.json.JsonSender;
import com.kyu.component.test.servlet.vo.ServletDataVO;

/**
 * @FileName : JsonServlet.java
 * @Project : sample_project
 * @Date : 2012. 9. 11.
 * @작성자 : 이남규
 * @프로그램설명 :
 */
@WebServlet("/json.do")
public class JsonServlet extends HttpServlet {

	/**  */
	private static final long serialVersionUID = -3983308125432896928L;

	/* (non-Javadoc)
	 * @see javax.servlet.http.HttpServlet#service(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String command = req.getParameter("cmd");
		String adsId = req.getParameter("adsId");
		System.out.println("##service## adsId=" + adsId + ", cmd=" + command);

		if ("info".equals(command)) {
			JsonResultVO jsonVO = info();
			JsonSender.responseJsonResult(res, jsonVO);
		}
		else if ("list".equals(command)) {
			JsonResultVO jsonVO = list();
			JsonSender.responseJsonResult(res, jsonVO);
		}
		else {
			RequestDispatcher dispatcher = req.getRequestDispatcher("/jsp/json.jsp");
			dispatcher.forward(req, res);
		}
	}

	/**
	 * <pre>
	 * info
	 *
	 * <pre>
	 * @param req
	 * @param res
	 * @throws IOException
	 */
	private JsonResultVO info() {
		ServletDataVO dataVO = new ServletDataVO();
		dataVO.setAdsName("adsInfo");
		dataVO.setImp(1000);
		dataVO.setClick(10);

		// set json data
		JsonResultVO jsonVO = new JsonResultVO();
		jsonVO.setSuccess(true);
		jsonVO.setMsg("jsonTest");
		jsonVO.setInfo(dataVO);

		return jsonVO;
	}

	/**
	 * <pre>
	 * list
	 *
	 * <pre>
	 * @return
	 */
	private JsonResultVO list() {
		List<ServletDataVO> dataList = new ArrayList<ServletDataVO>();

		// test data
		for (int i = 1; i < 4; i++) {
			ServletDataVO dataVO = new ServletDataVO();
			dataVO.setAdsName("advertisement");
			dataVO.setImp(1000);
			dataVO.setClick(i);

			dataList.add(dataVO);
		}

		// set json data
		JsonResultVO jsonVO = new JsonResultVO();
		jsonVO.setList(dataList);
		return jsonVO;
	}
}