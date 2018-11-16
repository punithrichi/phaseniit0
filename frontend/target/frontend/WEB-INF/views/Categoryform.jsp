<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
  <%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<html>
<head>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Spring MVC Form Handling</title>
<style>
table, th, td {
    border: 1px solid black;
    border-collapse: collapse;
    padding: 5px
}
</style>
</head>
<body>
	<h2>Category</h2>
	<form:form method="POST" action="addcategory">
		<table>
		<tr>

				<td><form:label path="category_ID">id</form:label></td>
				<td><form:input path="category_ID" /></td>
			</tr>
		
			<tr>
				<td><form:label path="name">Name</form:label></td>
				<td><form:input path="name" /></td>

			</tr>
			
			<tr>
				<td colspan="2"><input type="submit" value="Submit" /></td>
			</tr>
		</table>
	</form:form>
	
	 <br />
      <a href="getcategory">getallcategory</a>
      <br />
      <br />
       <table border="1">
         	<tr>
         		<th>category_ID</th>
         		<th>name</th>
 			</tr>
 			 <c:forEach var="P" items="${catlist}">
 			<tr>
 				 
 				<td>${P.category_ID}</td> 
 				<td>${P.name}</td>
 				<td>

					<a href="<c:url value='/deletecategory?id=${P.category_ID}'></c:url>"><span class="glyphicon glyphicon-trash"></span></a>
					<a href="<c:url value='/getupdatecategory?id=${P.category_ID}'></c:url>"><span class="glyphicon glyphicon-pencil"></span></a>
					</td>
 				
 				</tr>	
 				  </c:forEach>
 				  
 				  </table>
</body>

</html>
