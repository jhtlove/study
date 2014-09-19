<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import="test.mybean.*" %>
    <%@page import="test.servelet.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Add Student</title>
</head>
<body>
<form action="AddStudent" method="post">
	<table>
		<tr>
			<td>姓名<td> <input type="text" name="name">
		</tr>
		<tr>
			<td><input type="submit" value="确定"></td>
		<tr>
		<!--<tr><td><a href="show.jsp">查看</a></td></tr>-->
	</table>
</form>
</body>
</html>