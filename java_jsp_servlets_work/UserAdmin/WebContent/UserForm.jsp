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
    <center>
        <h1>User Management</h1><br><br>
        <c:if test="${user == null}">
        <button onclick="window.location.href='/UserAdmin/login'" class="block">Login</button>    
        </c:if>
        
    </center>
    <div align="center">
        <c:if test="${user != null}">
            <form action="update" method="post">
        </c:if>
        <c:if test="${user == null}">
            <form action="insert" method="post">
        </c:if>
        <table border="1" cellpadding="5" style="border-collapse: collapse;">
            <caption>
                <h2>
                    <c:if test="${user != null}">
                        Edit User
                    </c:if>
                    <c:if test="${user == null}">
                        Register
                    </c:if>
                </h2>
            </caption>
                <c:if test="${user != null}">
                    <input type="hidden" name="id" value="<c:out value='${user.id}' />" />
                </c:if>   
                
            <tr>
                <th>User Name: </th>
                <td>
                    <input type="text" name="username" size="45"
                            value="<c:out value='${user.username}' />" required
                        />
                </td>
            </tr>        
            <tr>
                <th>First Name: </th>
                <td>
                    <input type="text" name="first_name" size="45"
                            value="<c:out value='${user.first_name}' />" required
                        />
                </td>
            </tr>
            <tr>
                <th>Last Name: </th>
                <td>
                    <input type="text" name="last_name" size="45"
                            value="<c:out value='${user.last_name}' />" required
                    />
                </td>
            </tr>
            <tr>
                <th>Contact Number: </th>
                <td>
                    <input type="text" name="pn" size="45"
                            value="<c:out value='${user.pn}'  />"  required
                    />
                </td>
            </tr>
            <tr>
                <th>E-mail: </th>
                <td>
                    <input type="email" name="email" size="45"
                            value="<c:out value='${user.email}' />" required
                    />
                </td>
            </tr>
            <tr>
                <th>Gender: </th>
                <td>
                    <Select id="Gender" name="gender" width="45" value="${user.gender}">
                    <option value="Male">Male</option>
					<option value="Female">Female</option>
					<option value="Other">Other</option>
                    </Select>
                </td>
            </tr>
            <tr>
                <th>Password: </th>
                <td>
                    <input type="password" name="pwd" size="45"
                            value="<c:out value='${user.pwd}' />" required
                        />
                </td>
            </tr>
            <tr>
                <td colspan="2" align="center">
                    <input type="submit" value="Submit" />
                </td>
            </tr>
        </table>
        </form>
    </div>   
</body>
</html>