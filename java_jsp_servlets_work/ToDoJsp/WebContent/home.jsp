<%@page import="java.util.Scanner"%>
<%@ include file= "Header.jsp" %>
<br>Directive tag for importing the packages<br>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home</title>
</head>
<body>
<br>Declaration tag to write the java code <br>
<%!
	int coef=3;//Declaration tag to write the java code 
%>
<br>Scriptlet tag to write the java code in the service method<br>
<h1>Hello World!</h1>
<%
	out.println(7+5);//Scriptlet tag to write the java code in the service method
%>
<br>Expression tag to print the contents of the variables<br>
<%=coef %>
<%@ include file= "Footer.jsp" %>
</body>
</html>