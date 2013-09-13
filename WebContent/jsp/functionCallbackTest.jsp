<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html
PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN"
"http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>callback function test</title>
<script type="text/javascript" src="http://code.jquery.com/jquery-1.8.1.min.js"></script>
<script type="text/javascript">


	/*
		each 함수에서는 arr이라는 배열의 값과 callback이라는 사용자 정의 함수를 전달 받게 된다.
		javascript에서는 함수의 매개 변수에 함수를 던질 수 있는 장점이 있다.
	*/
	var each = function(arr, callback) {
		for (var i = 0; i < arr.length; i++) {
			callback(i, arr[i]);
		}
	};

	onload = function() {
		var test = [{name : 'a'}, {name : 'b'}, {name : 'c'}];
		each(test, function(index, elem) {
			console.log(index + " = " + elem.name);
		});
	};


</script>


</head>
<body>

</body>
</html>