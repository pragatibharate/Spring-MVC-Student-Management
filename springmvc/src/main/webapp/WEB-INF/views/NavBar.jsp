<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Navbar</title>
<style>
		#parent{
		   background-image: linearGradient(45deg, white, hotpink, white)
		}
         nav{
            /* height: 30px; */
            width: 1000px;
            background-color: black;
            overflow: hidden;
            margin: auto;
        }
        #child{   
            padding: 20px;
            margin-left: 290px;
        }
        .button{
            display: inline;
            margin-top: 20px;   
        }
        .button a{
            color: white;
            padding: 10px;
            text-decoration: none;
            /* border: 1px solid white; */
            text-align: center;
            font-size: large;
        }
        .button a:hover{
            background-color: turquoise;
            color: black;
        }
 </style>
</head>
<body>
	<div id="parent">
        <nav>
        <div id="child">
            <div class="button"><a href="./home">Home</a></div>
            <div class="button"><a href="./add">Add Student</a></div>
            <div class="button"><a href="./remove">Remove Student</a></div>
            <div class="button"><a href="./update">Update Student</a></div>
            <div class="button"><a href="./search">Search Student</a></div>
            <div class="button"><a href="./logout">Logout</a></div>
        </div>
    </nav>
    </div>
</body>
</html>