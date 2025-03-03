<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page isErrorPage="true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Update Book</title>
</head>
<body>
	<h1>Edit Book</h1>
	<form:form action="/book/${id}" method="put" modelAttribute="book"
		class="form col-6 mx-auto">
		<!-- 	<input type="hidden" name="_method" value="put"> -->
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