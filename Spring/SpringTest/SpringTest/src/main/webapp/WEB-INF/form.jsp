<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<title>From</title>
</head>
<body>
<h1>Dash</h1>
<form class="p-4" action="/register" method="POST">
<div>
<c:if test="${error != null }"></c:if>
<p class="p-2 gb-danger"><c:out value="${error}" /></p>
<label for="formControlInput" class="form-label">First Name</label>
<input type="text" class="form-control" id="formControlInput" placeholder="First Name" name="firstName">
</div>
<div>
<label for="formControlInput" class="form-label">Email address</label>
<input type="email" class="form-control" id="formControlInput" placeholder="name@example.com" name="email">
</div>
<div>
<label for="formControlInput" class="form-label">Password</label>
<input type="password" class="form-control" id="formControlInput" placeholder="Password" name="password">
</div>
<button class="btn btn-outline-primary">Submit</button>
</form>
</body>
</html>