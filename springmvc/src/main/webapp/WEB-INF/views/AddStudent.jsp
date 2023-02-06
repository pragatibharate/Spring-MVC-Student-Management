<%@page import="com.jspiders.springmvc.pojo.StudentPojo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<jsp:include page="NavBar.jsp" />
<%
StudentPojo student = (StudentPojo) request.getAttribute("student");
String msg = (String)request.getAttribute("msg");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add Student</title>
</head>
<body>
	<fieldset style="width: 500px; margin: auto; margin-top: 50px">
		<legend
			style="margin: auto; heigth: 20px; width: 180px; background-color: black; color: white; text-align: center;">
			Add Student Form </legend>
		<form action="./add" method="post">
			<table>
				<tr>
					<td><label> Name: </label></td>
					<td><input type="text " name="name"></td>
				</tr>

				<tr>
					<td><label> Email: </label></td>
					<td><input type="email" name="email"></td>
				</tr>

				<tr>
					<td><label> Contact: </label></td>
					<td><input type="tel" name="contact"></td>
				</tr>

				<tr>
					<td><label> City: </label></td>
					<td><input type="text" name="city"></td>
				</tr>

				<tr>
					<td><label> Username: </label></td>
					<td><input type="text" name="username"></td>
				</tr>

				<tr>
					<td><label> Password: </label></td>
					<td><input type="password" name="password"></td>
				</tr>

				<tr>
					<td><input type="submit" value="Add"></td>
				</tr>
			</table>
		</form>
	</fieldset>
	
	<% if(msg != null){ %>
		<h3 align="center"><%=msg %></h3>
	<%} %>
</body>
</html>