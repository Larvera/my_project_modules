package com.kyu.component.test.json;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

/**
 * @FileName : JsonSender.java
 * @Project : sample_project
 * @Date : 2012. 9. 11.
 * @작성자 : 이남규
 * @프로그램설명 :
 */
public class JsonSender {

	/**
	 * <pre>
	 * sendJsonResult
	 * response json
	 * <pre>
	 * @param response
	 * @param jsonVO
	 * @throws IOException
	 */
	public static void responseJsonResult(HttpServletResponse response, JsonResultVO jsonVO) throws IOException {
		response.setContentType("text/html;charset=UTF-8");
        response.getWriter().print(jsonVO.toJsonString());
        response.flushBuffer();
	}
}
