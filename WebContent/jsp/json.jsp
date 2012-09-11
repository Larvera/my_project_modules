<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ include file="/jsp/include.jsp" %>

<script type="text/javascript">
<!--

	$(document).ready(function() {

		// json vo data
		$.getJSON("${pageContext.request.contextPath}/json?cmd=list", function(json) {
			$.each(json.list, function(entryIndex, entry) {
				var html = "<div>" + entry['imp'] + "</div>";
				html += "<div>" + entry['click'] + "</div>";
				html += "<div>" + entry['adsName'] + "</div>";
				$("#content").append(html);
			});
		});

	});

	function jsonTest() {
		var adsId = 1212;
		var cmd = "info";

		$.ajax({
			type : "GET",
			url : "${pageContext.request.contextPath}/json",
			dataType : "json",
			data : "adsId=" + adsId + "&cmd=" + cmd,
			success : function(json) {
				if (json.isSuccess) {
					alert(json.msg);
				}

				alert(json.info.adsName);
				alert(json.info.imp);
				alert(json.info.click);
			},
			error : function(e) {
				alert("처리중 장애가 발생하였습니다.");
			}
		});
	}
//-->
</script>

<a href="javascript:jsonTest();">
	test
</a>

<div id="content" />

