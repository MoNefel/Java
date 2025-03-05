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
<title>Insert title here</title>
</head>
<body style="margin: 2vw;">
	<h1>Welcome!</h1>
	<p>Join our growing community</p>

	<form:form action="/register" method="post" modelAttribute="user">

		<table>
			<thead>
				<tr>
					<td colspan="2">Register</td>
				</tr>
			</thead>
			<thead>
				<tr>
					<td class="float-left">User Name:</td>
					<td class="float-left"><form:errors path="userName"
							class="text-danger" /> <form:input class="input" path="userName" />
					</td>
				</tr>
				<tr>
					<td class="float-left">Email:</td>
					<td class="float-left"><form:errors path="email"
							class="text-danger" /> <form:input class="input" path="email" />
					</td>
				</tr>
				<tr>
					<td class="float-left">Password:</td>
					<td class="float-left"><form:errors path="password"
							class="text-danger" /> <form:input class="input" path="password" />
					</td>
				</tr>
				<tr>
					<td class="float-left">Confirm PW:</td>
					<td class="float-left"><form:errors path="confirm"
							class="text-danger" /> <form:input class="input" path="confirm" />
					</td>
				</tr>
				<tr>
					<td colspan=2><input class="input" type="submit"
						value="Submit" /></td>
				</tr>
			</thead>
		</table>
	</form:form>
	<hr>
	<form:form action="/login" method="post" modelAttribute="loginUser">

		<table>
			<thead>
				<tr>
					<td colspan="2">Log In</td>
				</tr>
			</thead>
			<thead>
				<tr>
					<td class="float-left">Email:</td>
					<td class="float-left"><form:errors path="email"
							class="text-danger" /> <form:input class="input" path="email" />
					</td>
				</tr>
				<tr>
					<td class="float-left">Password:</td>
					<td class="float-left"><form:errors path="password"
							class="text-danger" /> <form:input class="input" path="password" />
					</td>
				</tr>
				<tr>
					<td colspan=2><input class="input" type="submit"
						value="Submit" /></td>
				</tr>
			</thead>
		</table>
	</form:form>
</body>
</html>