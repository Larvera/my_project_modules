<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
index

<br/>
<a href="/download">
download
</a>

<br/>
<br/>
<form action="/upload" enctype="multipart/form-data" method="POST">
	name: <input type="text" name="nameStr"><br/>
	uploadFile1: <input type="file" name="content"><br/>
	uploadFile2: <input type="file" name="content"><br/>
	<input type="submit" value="Submit"><br/>
</form>