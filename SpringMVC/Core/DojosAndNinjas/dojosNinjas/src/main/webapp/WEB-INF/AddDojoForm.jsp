<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page isErrorPage="true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH"
	crossorigin="anonymous">
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<title>Home</title>
</head>
<body>
	<h1>Add Dojo</h1>
	<form:form action="/dojo" method="post" modelAttribute="dojo"
		class="form col-6 mx-auto">
		<!-- 	<input type="hidden" name="_method" value="put"> -->
		<div class="form-control">
			<form:label path="name">Name</form:label>
			<form:errors path="name" />
			<form:input path="name" />
		</div>
		<div class="form-control">
			<form:label path="city">City</form:label>
			<form:errors path="city" />
			<form:textarea path="city" />
		</div>
		<input type="submit" value="Create" />
	</form:form>
</body>
</html>