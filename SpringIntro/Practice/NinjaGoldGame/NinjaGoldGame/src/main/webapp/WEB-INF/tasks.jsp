<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">

</head>
<body>
<c:forEach var="task" items="${tasks}">
	<c:if test="${task.contains('earned')}">
		<p style="color: green;"><c:out value="${task}"/></p>
	</c:if>
	<c:if test="${task.contains('lost')}">
		<p style="color: red;"><c:out value="${task}"/></p>
	</c:if>
</c:forEach>
</body>
</html>