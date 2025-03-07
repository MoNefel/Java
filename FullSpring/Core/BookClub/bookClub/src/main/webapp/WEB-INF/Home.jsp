<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ page isErrorPage="true"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Book Club</title>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
<link rel="stylesheet" href="/css/main.css">
<!-- change to match your file/naming structure -->
<script src="/webjars/jquery/jquery.min.js"></script>
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</head>
<body>

	<div class="container">
		<h1>
			Welcome,
			<c:out value="${user.userName}" />
		</h1>

		<h3>Books from everyone shelves:</h3>
		<a href="/logout">logout</a> <a href="/book/new">+ Add to my shelf</a>

		<table class="table">

			<tr>
				<th>ID</th>
				<th>Title</th>
				<th>Author Name</th>
				<th>Owner</th>
				<th>Actions</th>
			</tr>
			<c:forEach var="book" items="${books}">

				<c:if test="${user.id != book.borrower.id}">
					<tr>
						<td><c:out value="${book.id}" /></td>
						<td><a href="books/${book.id}"><c:out
									value="${book.title}" /></a></td>
						<td><c:out value="${book.authorName}" /></td>
						<td><c:out value="${book.user.userName}" /></td>
						<c:if test="${user == book.user }">
							<td><a href="book/${book.id}/edit">Edit ||</a><a
								href="book/${book.id}/delete"> Delete</a></td>
						</c:if>
						<c:if test="${user != book.user }">
							<td><a href="book/${book.id}/borrow">Borrow</a></td>
						</c:if>
					</tr>
				</c:if>
			</c:forEach>
			
		</table>

		<hr>
		<hr>

		<h3>Books I'm Borrowing</h3>

		<table class="table">

			<tr>
				<th>ID</th>
				<th>Title</th>
				<th>Author Name</th>
				<th>Owner</th>
				<th>Actions</th>
			</tr>
			<c:forEach var="book" items="${books}">

				<c:if test="${user.id == book.borrower.id}">
					<tr>
						<td><c:out value="${book.id}" /></td>
						<td><a href="books/${book.id}"><c:out
									value="${book.title}" /></a></td>
						<td><c:out value="${book.authorName}" /></td>
						<td><c:out value="${book.user.userName}" /></td>
						<c:if test="${user!=book.user}">
							<td><a href="book/${book.id}/return">return</a></td>
						</c:if>
					</tr>
				</c:if>

			</c:forEach>

		</table>
	</div>

</body>
</html>