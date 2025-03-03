<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<title>Books</title>
</head>
<body>
	<h1>All Books</h1>
	<a href="/book/new">Create Book</a>
	<table class="table">
		<thead>
			<tr>
				<th scope="col">ID</th>
				<th scope="col">Title</th>
				<th scope="col">Language</th>
				<th scope="col">Pages</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="oneBook" items="${allBooks}">
				<tr>
					<th scope="row">${oneBook.id}</th>
					<td><a href="/books/show/${oneBook.id}">${oneBook.title}</a></td>
					<td>${oneBook.language }</td>
					<td>${oneBook.numberOfPages}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>