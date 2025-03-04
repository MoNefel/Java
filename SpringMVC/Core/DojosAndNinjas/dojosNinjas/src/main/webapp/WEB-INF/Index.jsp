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
	<h1>All Dojos</h1>
	<a href="/dojo/new">Add Dojo</a>
	<a href="/ninja/new">Add Ninja</a>
	<table class="table table-striped table-bordered">
		<thead>
			<tr>
				<th class="text-center">Name</th>
				<th class="text-center">City</th>
				<th class="text-center">Actions</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="dojo" items="${dojos}">
				<tr>
					<td class="text-center"><c:out value="${dojo.name}"></c:out></td>
					<td class="text-center"><c:out value="${dojo.city}"></c:out></td>
					<td class="text-center"><a href="/dojo/${dojo.id}">visit</a></td>
						
				</tr>
			</c:forEach>
		</tbody>
	</table>
	
</body>
</html>