<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Funtions using JSTL</title>
</head>
<body>
<c:set var="str" value="Balaji vemula is learnig JSTL"></c:set>


Length: ${fn:length(str)}<br>


<c:forEach items="${fn:split(str,' ')}" var="s">
	<br>
	${s}
</c:forEach>



<br><br>
Index of "is" in the string is: ${fn:indexOf(str,"is")}


<br><br>
Is there a "JSTL" in the string: ${fn:contains(str,"JSTL")}


<br><br>
<c:if test="${fn:contains(str,'JSTL')}">
	yes
</c:if> 

<br><br>
<c:if test="${fn:endsWith(str,'JSTL')}">
	yes
</c:if> 

</body>
</html>