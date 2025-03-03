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
<title>Create Books</title>
</head>
<body>
	<h1>Create Book</h1>
	<form:form action="/book" method="post" modelAttribute="book"
		class="form col-6 mx-auto">
		<div class="form-control">
			<form:label path="title">Title</form:label>
			<form:errors path="title" />
			<form:input path="title" />
		</div>
		<div class="form-control">
			<form:label path="description">Description</form:label>
			<form:errors path="description" />
			<form:textarea path="description" />
		</div>
		<div class="form-control">
			<form:label path="language">Language</form:label>
			<form:errors path="language" />
			<form:input path="language" />
		</div>
		<div class="form-control">
			<form:label path="numberOfPages">Number Of Pages</form:label>
			<form:errors path="numberOfPages" />
			<form:input path="numberOfPages" />
		</div>
		<input type="submit" value="Submit" />
	</form:form>
</body>
</html>