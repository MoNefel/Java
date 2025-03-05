<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>User</title>
</head>
<body>
	<%-- 	<h1>
		Welcome,
		<c:out value="${user.userName}" />
		!
	</h1> --%>
	<h1>All Users</h1>
	<a href="/user/new">Create User</a>

	<c:forEach var="oneUser" items="${allUsers}">
		<div>
			<hr>
			<h2>UserName : ${oneUser.userName}</h2>
			<h2>UserEmail : ${oneUser.getEmail()}</h2>
			<h2>${sessionScope.userId }</h2>
			<h2>${oneUser.id }</h2>
			<a href="/user/${oneUser.id}/edit">Edit</a> <a
				href="user/${oneUser.id}">Delete</a>
			<hr>
		</div>
	</c:forEach>
</body>
</html>