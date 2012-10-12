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

		// node expand all
		$("#open_node").click(function() {
			$("#inven_tree").jstree("open_node");
		});

		// checkbox disabled
		$("#disable").click(function() {
			$("li").each(function() {
				$(this).find("ins[class=jstree-checkbox]").hide();
			});
		});

		// checkbox enable
		$("#enable").click(function() {
			$(".jstree-checkbox").each(function() {
				$(this).show();
			});
		});

		// invenName area checkbox disabled
		$("#icon").click(function() {
			$("a[id=invenNameArea]").each(function() {
				$(this).find(".jstree-icon").hide();
			});
		});

		// param transper data setting
		$("#mapping_value").click(function() {
			var checked_ids = [];
			$("#inven_tree").jstree("get_checked", null, true).each(function() {
				$(this).children("a[id=invenNameArea]").each(function() {
					var id = $(this).parent().attr("id");
					checked_ids.push(id);
				});
			});

			//$("#jsfields").value(checked_ids.join(","));
			$("#selectedInven").text(checked_ids.join(","));
		});

	});

	// tree load
	$(function () {
		$("#inven_tree").jstree({
			"plugins" : [ "themes", "html_data", "checkbox", "sort", "ui" ]
		})
		.bind("check_node.jstree", function(event, data) {
			addResult(data);
		})
		.bind("uncheck_node.jstree", function(event, data) {
			removeResult(data);
		})
		.bind("load_node.jstree", function (event, data) {
			// tree expand all
			$("#open_node").trigger("click");
      	})
		.bind("open_node.jstree close_node.jstree", function(event, data) {
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
			var invenId = $(this).parent().attr("id");
			$("#result").find("p[id=" + invenId + "]").remove();
		});
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
					<li id="toggle">
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

	<br/><br/>

	<input type="button" class="button" value="mappingValue" id="mapping_value" style="clear:both;" onclick="setHiddenValue();" />
	<input type="button" class="button" value="open_node" id="open_node" style="clear:both;" />
	<input type="button" class="button" value="disable" id="disable" style="clear:both;" />
	<input type="button" class="button" value="enable" id="enable" style="clear:both;" />
	<input type="button" class="button" value="icon" id="icon" style="clear:both;" />

	<br/><br/>
	click inventory : <span id="result"></span>
	<br/>
	mapping value : <span id="selectedInven"></span>
	<br/>

	<input type="text" id="userId" value="1"></input>

</body>
</html>