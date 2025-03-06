<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home</title>
</head>
<body>
<h1>Home Page</h1>
<p><a href="/product/new">New Product</a></p>
<p><a href="/category/new">New Category</a></p>
<hr>
<table>
    <thead>
        <tr>
            <th>Products</th>
            <th>Categories</th>
        </tr>
    </thead>
    <tbody>
       	<tr>
       		<td>
       			<ul>
		       		<c:forEach var="product" items="${products}">
		       			<li><a href="product/<c:out value="${product.id}"/>"><c:out value="${product.name}"/></a></li>
		       		</c:forEach>
		       	</ul>
       		</td>
       		<td>
       			<ul>
		       		<c:forEach var="category" items="${categories}">
		       			<li><a href="category/<c:out value="${category.id}"/>"><c:out value="${category.name}"/></a></li>
		       		</c:forEach>
		       	</ul>
       		</td>
       	</tr>
    </tbody>
</table>

</body>
</html>