<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Welcome</title>
</head>
<body>
<%
	// To Prevent Back Button after Logout
	response.setHeader("Cache-Control","no-cache,no-store,must-revalidate");//Http 1.1
	
	response.setHeader("pragma", "no-cache");// Http version 1.0
	
	response.setHeader("Expires", "0");// for proxies

	if(session.getAttribute("username")==null)
	{
		response.sendRedirect("login.jsp");
	}
%>
Welcome ${username}
<br>
<a href="videos.jsp">videos here</a>
<br>
<a href="aboutus.jsp">About us</a>
<br>
<form action="Logout">
	<input type="submit" value="Logout">
</form>
</body>
</html>