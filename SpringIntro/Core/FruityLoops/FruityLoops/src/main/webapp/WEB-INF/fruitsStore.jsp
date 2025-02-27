<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Fruity Loops</title>
<link rel="stylesheet" type="text/css" href="/css/style.css">
</head>
<body>
<h1>Fruit Store</h1>
<table class="center">
  <tr>
    <th class="header">Name</th>
    <th class="header">Price</th>
  </tr>
	<c:forEach var="fruit" items="${fruits}">
	<tr>
		<c:choose>
			<c:when test="${fruit.name.startsWith('G')}">
				<td style="color:orange;"><c:out value="${fruit.name}"></c:out></td>
			</c:when>
			<c:otherwise>
				<td><c:out value="${fruit.name}"></c:out></td>
			</c:otherwise>
		</c:choose>
		<td><c:out value="$ ${fruit.price}"></c:out></td>
	</tr>
	</c:forEach>
</table>
</body>
</html>