<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h2>Product Information</h2>
	<table>
		<tr>
			<td>Name</td>
			<td>${name}</td>
		</tr>

		<tr>
			<td>ID</td>
			<td>${ID}</td>
		</tr>
		
		<tr>
			<td>price</td>
			<td>${price}</td>
		</tr>
		<tr>
			<td>stock</td>
			<td>${stock}</td>
		</tr>
		<tr>
			<td>discription</td>
			<td>${discription}</td>
		</tr>
	</table>
<a href="getproduct">getallproducts</a>

</body>
</html>