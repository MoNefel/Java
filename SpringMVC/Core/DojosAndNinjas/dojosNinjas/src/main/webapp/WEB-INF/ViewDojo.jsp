<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page isErrorPage="true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title><c:out value="${dojo.name}"></c:out></title>
</head>
<body>
	<h1>
		<c:out value="${dojo.name }"></c:out>
		Location in
		<c:out value="${dojo.city}"></c:out>
	</h1>
	<div>
		<c:forEach var="ninja" items="${dojo.ninjas}">
			<h3>First name : 
				<c:out value="${ninja.first_name}"></c:out>
			</h3>
			<h3> Last Name : 
				<c:out value="${ninja.last_name}"></c:out>
			</h3>
			<h3>Age :
				<c:out value="${ninja.age}"></c:out>
			</h3>
			<hr>
		</c:forEach>
	</div>
	<hr>
	<div>
		<h3>
			<a href="/ninja/new">Add a new Ninja</a>
		</h3>
	</div>
</body>
</html>