<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page isErrorPage="true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH"
	crossorigin="anonymous">
<title>User</title>
</head>
<body>
	<h1>Create User</h1>
	<form:form action="/user" method="post" modelAttribute="user" class="form col-6 mx-auto">
		<div class="form-control">
			<form:label path="userName">User Name</form:label>
			<form:errors path="userName" />
			<form:input path="userName" />
		</div>
		<div class="form-control">
			<form:label path="email">Email</form:label>
			<form:errors path="email" />
			<form:textarea path="email" />
		</div>
		<div class="form-control">
			<form:label path="password">Password</form:label>
			<form:errors path="password" />
			<form:input path="password" />
		</div>
		<input type="submit" value="Submit" />
	</form:form>
</body>
</html>