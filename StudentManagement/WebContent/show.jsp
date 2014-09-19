<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="test.mybean.*" %>
<%@ page import="test.servelet.*" %>
<%@ page import="java.util.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table align="center" border="1" width="400">
		<tr align="center"><td>名字</td></tr>
		<%
			List<Student> list = (List<Student>)EditStudent.getInstance().selectStudent();
			if(EditStudent.getInstance().selectStudent().iterator().hasNext() == true)
			{
				out.println("list not null: " + list.iterator().next().getName());
				
				for(Student s:list)
				{
					out.println(s.getName() + "name");
		%>
		<tr align="center">
			<td><%= s.getName() %></td>
		</tr>
		<% 
				}
			} 
			%>
			<tr>
				<td><a href="index.jsp">继续添加</a></td>
			</tr>
	</table>
</body>
</html>