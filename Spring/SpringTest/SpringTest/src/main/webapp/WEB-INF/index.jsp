<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="java.util.Date"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="/css/style.css">
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<script type="text/javascript" src="/js/app.js"></script>
<title><c:out value="${title}"/></title>
</head>
<body>
	<h1 class="text-primary">JSP</h1>
	<!-- Inserting a for loop into your jsp -->
	<%
	for (int i = 0; i < 5; i++) {
	%>
	<h1><%=i%></h1>
	<%
	}
	%>
	<p>The time is:<%=new Date()%></p>

	<h1>Two plus two is:</h1>
	<h2>
		<c:out value="${2+2}" />
	</h2>
	<h2><c:out value="${firstName}"/></h2><span>with ID</span><h2><c:out value="${id }"/></h2>
	<table class="table">
  <thead>
    <tr>
      <th scope="col">#</th>
      <th scope="col">First</th>
      <th scope="col">Last</th>
      <th scope="col">Handle</th>
    </tr>
  </thead>
  <tbody>
    <tr>
      <th scope="row">1</th>
      <td>Mark</td>
      <td>Otto</td>
      <td>@mdo</td>
    </tr>
    <tr>
      <th scope="row">2</th>
      <td>Jacob</td>
      <td>Thornton</td>
      <td>@fat</td>
    </tr>
    <tr>
      <th scope="row">3</th>
      <td colspan="2">Larry the Bird</td>
      <td>@twitter</td>
    </tr>
  </tbody>
</table>
</body>
</html>