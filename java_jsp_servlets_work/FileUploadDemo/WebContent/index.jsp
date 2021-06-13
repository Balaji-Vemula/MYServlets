<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>File Upload</title>
</head>
<body>
<h2>Hello World!</h2>

<form action="Upload" method ="post" enctype="multipart/form-data">
	<input type="file" name="file" multiple>
	<input type="submit" value="Upload">
</form>
</body>
</html>