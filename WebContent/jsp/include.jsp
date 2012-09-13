<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<script type="text/javascript" src="http://code.jquery.com/jquery-1.8.1.min.js"></script>

<%
	response.setHeader("Cache-Control", "no-store"); // HTTP 1.0
	response.setHeader("Pragma", "no-cache");
	response.setDateHeader("Expires", 0);
	if (request.getProtocol().equals("HTTP/1.1"))
		response.setHeader("Cache-Control", "no-cache"); // HTTP 1.1
%>

