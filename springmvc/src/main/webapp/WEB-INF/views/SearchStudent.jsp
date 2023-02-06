<%@page import="com.jspiders.springmvc.pojo.StudentPojo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<jsp:include page="NavBar.jsp" />

<%
StudentPojo student = (StudentPojo) request.getAttribute("student");
String msg = (String) request.getAttribute("msg");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Search form</title>
</head>
<body>
	<fieldset style="width: 500px; margin: auto; margin-top: 50px">
		<legend
			style="margin: auto; heigth: 20px; width: 180px; background-color: black; color: white; text-align: center;">Search
			Student Details</legend>
		<form action="./search" method="post">
			<table>
				<tr>
					<td><label> Id </label></td>
					<td><input type="text" name="id"></td>
				</tr>

				<tr>
					<td><input type="submit" value="Search"></td>
				</tr>
			</table>
		</form>
	</fieldset>
	
	<%if(student != null){ %>
	
		<table border="1px solid" style="border-collapse: collapse; margin-left:450px; margin-top: 70px">
			<tr>
				<td>id</td>
				<td>Name </td>
				<td>Email </td>
				<td>Contact </td>
				<td>City </td>
				<td>Username </td>
				<td>Password </td>
			</tr>
			
			<tr>
				<td><%=student.getId() %></td>
				<td><%=student.getName() %></td>
				<td><%=student.getEmail() %></td>
				<td><%=student.getContact() %></td>
				<td><%=student.getCity() %></td>
				<td><%=student.getUserName() %></td>
				<td><%=student.getPassword() %></td>
			</tr>
		</table>
	<%} %>

<% if(msg != null){ %>
<h3 align="center"><%=msg %></h3>
<%} %>
</body>
</html>