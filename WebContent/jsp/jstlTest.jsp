<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ include file="/jsp/include.jsp" %>

<jsp:useBean id="date" class="java.util.Date" />

<%-- ############################# --%>
<%-- ## catch --%>
<%-- ############################# --%>
<c:catch var="err">
	<%=100 / 0%>
</c:catch>
오류 ${err}
<br/><br/>

<%-- ############################# --%>
<%-- ## param, session --%>
<%-- ############################# --%>
<%
	session.setAttribute("name", "namkyu");
%>
${sessionScope.name}
${param.test}
<br/><br/>

<%-- ############################# --%>
<%-- ## if --%>
<%-- ############################# --%>
<c:if test="${1 + 1 == 2}">
	1 + 1 = 2와 같다.
</c:if>
<br/><br/>

<c:choose>
	<c:when test="${5 + 1 == 6}">
		5 + 1 = 6이다.
	</c:when>
	<c:otherwise>
		5 + 1 = 6이 아니다.
	</c:otherwise>
</c:choose>
<br/><br/>

<%-- ############################# --%>
<%-- ## for --%>
<%-- ############################# --%>
<c:forEach begin="1" end="5" step="1">
	<c:forEach begin="1" end="10" step="2">
		*
	</c:forEach>
	<br/>
</c:forEach>
<br/><br/>

<c:set var="value" value="a,b,c,d,e" />
<c:forTokens var="alphabat" items="${value}" delims=",">
	${alphabat}<br/>
</c:forTokens>

<%-- ############################# --%>
<%-- ## fmt:formatNumber --%>
<%-- ############################# --%>
<fmt:formatNumber type="currency">500000</fmt:formatNumber><br/>
<fmt:formatNumber type="percent">100</fmt:formatNumber><br/>
<fmt:formatNumber pattern="####,####,####">111122223333</fmt:formatNumber><br/>

<fmt:formatNumber>10000000</fmt:formatNumber><br/>
<fmt:formatNumber groupingUsed="true">10000000</fmt:formatNumber><br/>

<br/><br/>

<%-- ############################# --%>
<%-- ## fmt:formatDate --%>
<%-- ############################# --%>
<fmt:formatDate value="${date}" type="date" /><br/>
<fmt:formatDate value="${date}" type="time" /><br/>
<fmt:formatDate value="${date}" pattern="yyyy.MM.dd" /><br/>
<fmt:formatDate value="${date}" type="both" /><br/><br/>

<fmt:formatDate value="${date}" type="both" dateStyle="short" timeStyle="short" /><br/>
<fmt:formatDate value="${date}" type="both" dateStyle="long" timeStyle="long" /><br/>

<br/><br/><br/>

<%-- ############################# --%>
<%-- ## others --%>
<%-- ############################# --%>
contextPath : ${pageContext.request.contextPath} <br/>
cookieValue : ${cookie.test.value} <br/>
requestURL : ${pageContext.request.requestURL} <br/>

JSTL function : http://docs.oracle.com/javaee/5/jstl/1.1/docs/tlddocs/fn/tld-summary.html <br/>
