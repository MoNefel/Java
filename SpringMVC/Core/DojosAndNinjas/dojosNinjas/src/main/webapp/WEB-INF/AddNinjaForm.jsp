<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page isErrorPage="true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add Ninja</title>
</head>
<body >
	<h1>Add Ninja</h1>
	<form:form action="/ninja" method="post" modelAttribute="ninja"
		class="form col-6 mx-auto">
		<!-- 	<input type="hidden" name="_method" value="put"> -->
		<div class="form-control">
			<form:label path="first_name">First Name</form:label>
			<form:errors path="first_name" />
			<form:input path="first_name" />
		</div>
		<div class="form-control">
			<form:label path="last_name">Last Name</form:label>
			<form:errors path="last_name" />
			<form:textarea path="last_name" />
		</div>
		<div class="form-control">
			<form:label path="age">Age</form:label>
			<form:errors path="age" />
			<form:textarea path="age" />
		</div>
		<div>
			<form:select path="dojo">
				<c:forEach var="dojo" items="${dojos}">
					<option value="${dojo.id}">${dojo.name}</option>
				</c:forEach>
			</form:select>
		</div>
		<input type="submit" value="Create Ninja" />
	</form:form>
</body>
</html>