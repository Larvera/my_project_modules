<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="/WEB-INF/classes/tld/hello-custom-tag.tld" prefix="hello"%>
<%@ taglib uri="/WEB-INF/classes/tld/function.tld" prefix="fn"%>
<%@ include file="/jsp/include.jsp" %>

<hello:greet username="kyu" />

<br/><br/>

더하기 : ${fn:plus(1,2)} <br/>
빼기 : ${fn:minus(10,3)} <br/>
