<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>User Management Application</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
<style>
.block {
  display: block;
  width: 25%;
  height:50px;
  border-radius: 10px;
  border: none;
  background-color: #4CAF50;
  color: white;
  padding: 14px 28px;
  font-size: 20px;
  font-weight: bold;
  cursor: pointer;
  text-align: center;
}

.block:hover {
  background-color: #ddd;
  color: black;
}
</style>
</head>
<body>
	<%
			if(session.getAttribute("flag")=="rs")
				out.println("User Registered Succusfully");
			session.setAttribute("flag",null);
		%>
    <center>
    	<h1>User Management</h1><br>
        <h2>
        <button onclick="window.location.href='/UserAdmin/new'" class="block">Register</button>
        </h2>
    </center>
    <div align="center">
    <form action="login" method="post">
        <table border="0" cellpadding="5">
            <caption><h2>Login</h2></caption>
            <tr>
                <th>User Name</th>
                <td><input type="text" name="uname"></td></tr>
                <tr><th>Password</th>
                <td><input type="password" name="pass"></td></tr>
                <tr><td colspan="2" align="center">
                    <input type="submit" value="Submit" />
                </td>
                </tr>
        </table>
        </form>
    </div>   
</body>
</html>