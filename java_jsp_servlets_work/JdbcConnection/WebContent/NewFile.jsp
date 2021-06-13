<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.sql.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<% 
		final String url="jdbc:mysql://localhost:3306/balaji";
		final String user="root";
		final String password = "Balaji@123";
		String sql="Select * from user where id=1";
		Class.forName("com.mysql.jdbc.Driver");
		Connection con=DriverManager.getConnection(url, user, password);
		Statement st=con.createStatement();
		ResultSet rs=st.executeQuery(sql);
		rs.next();
	%>
	<%= rs.getString(1)%>
	<%= rs.getString(2)%>
	<%= rs.getString(3)%>
</body>
</html>