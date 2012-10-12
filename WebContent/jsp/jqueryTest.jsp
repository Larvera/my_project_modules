<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html
PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN"
"http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>jquery</title>
<script type="text/javascript" src="http://code.jquery.com/jquery-1.8.1.min.js"></script>
<script type="text/javascript">

	$(document).ready(function() {

		alert($("#a").html("<p>test</p>"));
	});

</script>


</head>
<body>

	<div>
		<div>
			<input type="text" id="userId" name="userId" value="111" />
		</div>
		<div>
			<input type="text" id="userId" name="userId" value="111" />
		</div>
	</div>

</body>
</html>