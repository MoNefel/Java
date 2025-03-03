<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<title>Show Book</title>
</head>
<body>
<div class="card" >
  <div class="card-header bg-transparent"><c:out value="${oneBook.title}"/></div>
  <div class="card-body">
    <h5 class="card-title">Description: <c:out value="${oneBook.description}"/></h5>
    <p class="card-text">Language: <c:out value="${oneBook.language}"/></p>
  </div>
  <div class="card-footer bg-transparent">Number of Pages: <c:out value="${oneBook.numberOfPages}"/></div>
</div>
</body>
</html>