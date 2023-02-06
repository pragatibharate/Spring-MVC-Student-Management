<%@page import="com.jspiders.springmvc.pojo.StudentPojo"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<jsp:include page="NavBar.jsp" />
<%
StudentPojo student = (StudentPojo) request.getAttribute("student");
List<StudentPojo> students = (List<StudentPojo>) request.getAttribute("students");
String msg = (String) request.getAttribute("msg");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<%
	if (student != null) {
	%>
	<fieldset>
		<legend>Update Form</legend>
		<form action="./updateData" method="post">
			<table>
				<tr hidden="true">
					<td>Id :</td>
					<td><input type="text" name="id" value="<%=student.getId()%>">
					</td>
				</tr>

				<tr>
					<td>Name :</td>
					<td><input type="text" name="name"
						value="<%=student.getName()%>"></td>
				</tr>

				<tr>
					<td>Email :</td>
					<td><input type="text" name="email"
						value="<%=student.getEmail()%>"></td>
				</tr>

				<tr>
					<td>Contact :</td>
					<td><input type="text" name="contact"
						value="<%=student.getContact()%>"></td>
				</tr>

				<tr>
					<td>City :</td>
					<td><input type="text" name="city"
						value="<%=student.getCity()%>"></td>
				</tr>

				<tr>
					<td>Username :</td>
					<td><input type="text" name="username"
						value="<%=student.getUserName()%>"></td>
				</tr>

				<tr>
					<td>Password :</td>
					<td><input type="text" name="password"
						value="<%=student.getPassword()%>"></td>
				</tr>

				<tr>
					<td><input type="submit" value="Update"></td>
				</tr>
			</table>
		</form>
	</fieldset>


	<%
	} else {
	%>

	<fieldset style="width: 500px; margin: auto; margin-top: 50px">
		<legend
			style="margin: auto; heigth: 20px; width: 180px; background-color: black; color: white; text-align: center;">Update
			student Details</legend>
		<form action="./update" method="post">
			<table>
				<tr>
					<td><label> Id </label></td>
					<td><input type="text" name="id"></td>
				</tr>

				<tr>
					<td><input type="submit" value="Select"></td>
				</tr>
			</table>
		</form>
	</fieldset>

	<%
	if (msg != null) {
	%>
	<h3 align="center"><%=msg%></h3>
	<%
	}
	%>
	<%
	if (students != null) {
	%>
	<table border="1px solid"
		style="border-collapse: collapse; margin-left: 450px; margin-top: 70px">
		<tr>
			<td>id</td>
			<td>Name</td>
			<td>Email</td>
			<td>Contact</td>
			<td>City</td>
			<td>Username</td>
			<td>Password</td>
		</tr>

		<%
		for (StudentPojo studentData : students) {
		%>

		<tr>
			<td><%=studentData.getId()%></td>
			<td><%=studentData.getName()%></td>
			<td><%=studentData.getEmail()%></td>
			<td><%=studentData.getContact()%></td>
			<td><%=studentData.getCity()%></td>
			<td><%=studentData.getUserName()%></td>
			<td><%=studentData.getPassword()%></td>
		</tr>
		<%
		}
		%>
	</table>
	<%
	}
	}
	%>
</body>
</html>