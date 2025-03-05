<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page isErrorPage="true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Update</title>
</head>
<body>
<h1>Edit User</h1>
	<form:form action="/user/${id}" method="put" modelAttribute="user" class="form col-6 mx-auto">
<!-- 	<input type="hidden" name="_method" value="put"> -->
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