<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>User Management Application</title>
</head>
<body>
<%
	// To Prevent Back Button after Logout
	response.setHeader("Cache-Control","no-cache,no-store,must-revalidate");//Http 1.1
	
	response.setHeader("pragma", "no-cache");// Http version 1.0
	
	response.setHeader("Expires", "0");// for proxies

	if(session.getAttribute("uname")==null)
	{
		response.sendRedirect("Admin.jsp");
	}
	else
	{
		if(session.getAttribute("flag")=="ls")
			out.println("Login Succusfull");
		else if(session.getAttribute("flag")=="ds")
			out.println("User Deleted Succusfully");
		else if(session.getAttribute("flag")=="us")
			out.println("User Updated Succusfully");
		session.setAttribute("flag",null);
	}
%>
    <center>
        <h1>User Management</h1>
    </center>
    <div align="center">
        <table border="1" cellpadding="5" style="border-collapse: collapse;">
            <caption><h2>List of users</h2></caption>
            <tr>
                <th>User Name</th>
                <th>First Name</th>
                <th>Last Name</th>
                <th>Contact Number</th>
                <th>E-mail</th>
                <th>Gender</th>
                <th>Actions</th>
            </tr>
            <c:forEach var="user" items="${listUser}">
                <tr>
                    <td><c:out value="${user.username}" /></td>
                    <td><c:out value="${user.first_name}" /></td>
                    <td><c:out value="${user.last_name}" /></td>
                    <td><c:out value="${user.pn}" /></td>
                    <td><c:out value="${user.email}" /></td>
                    <td><c:out value="${user.gender}" /></td>
                    <td>
                        <a href="/UserAdmin/edit?id=<c:out value='${user.id}' />">Edit</a>
                        &nbsp;&nbsp;&nbsp;&nbsp;
                        <a href="/UserAdmin/deleteconfirm?id=<c:out value='${user.id}' />">Delete</a>                     
                    </td>
                </tr>
            </c:forEach>
        </table>
    </div>
    <div align="center"><form action="Logout">
	<input type="submit" value="Logout">
	</div>
</form>
</body>
</html>