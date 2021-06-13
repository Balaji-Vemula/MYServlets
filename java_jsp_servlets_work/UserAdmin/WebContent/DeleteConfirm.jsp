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
%>
    <center>
        <h1>User Management</h1>
    </center>
    <div align="center">
        <table border="3" cellpadding="15">
            <caption>
                <h2>
                    Delete Confirmation
                </h2>
            </caption>
                <c:if test="${user != null}">
                    <input type="hidden" name="id" value="<c:out value='${user.id}' />" />
                </c:if> 
            <tr>
                <th>User ID: </th>
                <td>
                    <c:out value='${user.id}' />
                </td>
            </tr>
            <tr>
                <th>User Name: </th>
                <td>
                    <c:out value='${user.username}' />
                </td>
            </tr>        
            <tr>
                <th>First Name: </th>
                <td>
                    <c:out value='${user.first_name}' />
                </td>
            </tr>
            <tr>
                <th>Last Name: </th>
                <td>
                    <c:out value='${user.last_name}' />
                </td>
            </tr>
            <tr>
                <th>Contact Number: </th>
                <td>
                    <c:out value='${user.pn}' />
                </td>
            </tr>
            <tr>
                <th>E-mail: </th>
                <td>
                    <c:out value='${user.email}' />
                </td>
            </tr>
            <tr>
                <th>Gender: </th>
                <td>
                    <c:out value='${user.gender}' />
                </td>
            </tr>
            <tr><th colspan="2">Do you want to delete this user?</tr>
            <tr>
            	<td align="center">
            	<a href="/UserAdmin/delete?id=<c:out value='${user.id}' />"><img alt="Qries" src="data:image/jpeg;base64,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
            	"></a></td>
                <td align="center">
                    <a href="/UserAdmin/list"><img alt="Qries" src="http://clipart-library.com/images/8iz8A7gxT.png" style="height: 79px;"></a>
    </center>
                </td>
            </tr>
        </table>
    </div>   
</body>
</html>