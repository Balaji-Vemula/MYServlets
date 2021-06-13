<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Sql using JSTL</title>
</head>
<body>
	<sql:setDataSource var="db" driver="com.mysql.cj.jdbc.Driver" url="jdbc:mysql://localhost:3306/balaji" user="root" password="Balaji@123"/>
	<sql:query var="rs" dataSource="${db}">select * from gadgets</sql:query>
	
	<c:forEach items="${rs.rows }" var="gadget">
		<br><c:out value="${gadget.gid }"></c:out> : <c:out value="${gadget.gname}"></c:out> : <c:out value="${gadget.gprice }"></c:out> 
	</c:forEach>

</body>
</html>