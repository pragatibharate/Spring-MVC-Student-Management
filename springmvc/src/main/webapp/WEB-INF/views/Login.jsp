<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%String msg= (String)request.getAttribute("msg");%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Student Management</title>
</head>
<body>
<fieldset style="width: 500px; margin:auto; margin-top:300px">
<legend style="margin: auto; heigth:20px; width:180px; background-color: black; color:white;  text-align: center;"  >Proceed to login</legend>
<form action="./login" method="post">
 	<table >
 	    <tr>
 	    	<td> Username: </td>
 	    	<td> <input type="text" name="username"> </td>
 	    </tr>
 	    
 	    <tr>
 	    	<td> Password: </td>
 	    	<td> <input type="password" name="password"> </td>
 	    </tr>
 	    
 	     <tr>
 	    	<td> <input  type="submit" value="Login"> </td>
 	    </tr>
 	</table>
</form>
</fieldset>

<% if(msg != null ) {%>
	<h3 align="center"><%=msg %></h3>
	<%} %>

</body>
</html>