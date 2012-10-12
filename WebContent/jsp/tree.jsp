<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ include file="/jsp/include.jsp" %>

<!DOCTYPE html
PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN"
"http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>jsTree</title>
<script type="text/javascript" src="http://code.jquery.com/jquery-1.8.1.min.js"></script>
<script type="text/javascript" src="/js/jquery.jstree.js"></script>
<script type="text/javascript">

	$(document).ready(function() {

// 		$(".jstree-checked").each(function() {
// 			var rawCheckedId = $(this).attr("id");
// 			alert(rawCheckedId);
// 		});

// 		$(".jstree-checked").each(function() {
// 			$(this).click(function() {
// 				var invenName = $(this).find("a").text();
// 				alert(invenName);
// 				$("#result").append(invenName + "<br/>");
// 			});
// 		});

// 		$(".jstree-undetermined").each(function() {
// 			$(this).click(function() {
// 				var invenName = $(this).find("a").text();
// 				alert(invenName);
// 			});
// 		});

	});

	// tree load
	$(function () {
		$("#inven_tree")
		.jstree({
			"plugins" : [ "themes", "html_data", "checkbox", "sort", "ui" ]
		})
		.bind("check_node.jstree", function(event, data) {
			addResult(data);
		})
		.bind("uncheck_node.jstree", function(event, data) {
			removeResult(data);
		})
		.bind("check_all.jstree", function(event, data) {
			alert("check_all");
		})
		.bind("uncheck_all.jstree", function(event, data) {
			alert("uncheck_all");
		})
		.bind("is_checked.jstree", function(event, data) {
			alert("is_checked");
		})
		.bind("show_checkboxes.jstree", function(event, data) {
			alert("show_checkboxes");
		})
		.bind("hide_checkboxes.jstree", function(event, data) {
			alert("hide_checkboxes");
		});
	});

	// 체크된 inventory view
	function addResult(data) {
		$(data.rslt.obj).find("a[id=invenNameArea]").each(function() {
			var invenName = $(this).text();
			var invenId = $(this).parent().attr("id");
			var newTag = $("<p></p>").text(invenName).attr("id", invenId);
			$("#result").append(newTag);
		});
	}

	// 체크 해제된 inventory remove
	function removeResult(data) {
		$(data.rslt.obj).find("a[id=invenNameArea]").each(function() {
			console.log($(this).parent());
			var invenId = $(this).parent().attr("id");
			$("#result").find("p[id=" + invenId + "]").remove();
		});
	}

	// 전송 파라미터 데이터 set
	function setHiddenValue() {
	    var checked_ids = [];
		$("#inven_tree").jstree("get_checked", null, true).each(function() {
			$(this).children("a[id=invenNameArea]").each(function() {
				var id = $(this).parent().attr("id");
				checked_ids.push(id);
			});
		});

		//$("#jsfields").value(checked_ids.join(","));
		$("#selectedInven").text(checked_ids.join(","));
	}

</script>


</head>
<body>
	<form name="treeForm">
		<input type="hidden" name="jsfields" id="jsfields" value="" />
	</form>

	<div id="inven_tree" class="tree">
		<ul>
			<li>
				<a href="#">전체</a>
				<ul>
					<li>
						<a href="#">매체그룹</a>
						<ul>
							<c:forEach items="${groupList}" var="group">
							<li>
								<a href="#">${group.groupName}</a>
								<ul>
									<c:forEach items="${group.siteList}" var="site">
									<li>
										<a href="#">${site.siteName}</a>
										<ul>
											<c:forEach items="${site.inventoryList}" var="inven">
											<li class="jstree-checked" id="${inven.invenId}">
												<a href="#" id="invenNameArea">${inven.invenName} (${inven.invenSize})</a>
											</li>
											</c:forEach>
										</ul>
									</li>
									</c:forEach>
								</ul>
							</li>
							</c:forEach>
						</ul>
					</li>
				</ul>
			</li>
		</ul>
	</div>

	<br/>
	<br/>
	<div id="btn">
		<a href="javascript:setHiddenValue();">mapping value</a>
	</div>

	<br/>
	<br/>
	<div id="result"></div>

	<br/>
	<br/>
	<div id="selectedInven"></div>

</body>
</html>