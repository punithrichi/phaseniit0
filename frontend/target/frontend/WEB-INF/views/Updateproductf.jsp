<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri = "http://www.springframework.org/tags/form" prefix = "form"%>
    <%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

<style>
table, th, td {
    border: 1px solid black;
    border-collapse: collapse;
    padding: 5px
}
</style>
</head>
<body>
<div class="container">
<h1> Add New Product</h1>
<form:form method="POST" Action="updateproduct" enctype="multipart/form-data">
<table>
			<tr>
               <td>ID:</td>
               <td><form:input type="hidden" path = "ID" /></td>
           </tr>
           <tr>
               <td>P_Name:</td>
               <td><form:input path = "name" /></td>
           </tr>
           <tr>
               <td>P_Price:</td>
               <td><form:input path = "price" /></td>
           </tr>
           <tr>
               <td>P_Des:</td>
               <td><form:input path = "discription" /></td>
           </tr>
          
            <tr>
            	<td> upload a image </td>
            	<td><form:input type="file" path="image"/></td>
            </tr>
            <tr>
            	<td>Select Category</td>
		<td><form:select path="category.category_ID">
		<c:forEach items="${categories}" var="c">
		<form:option value="${c.category_ID }">${c.name }</form:option>
		</c:forEach>
	
		</form:select>
            </td>
            </tr>
            <tr>
               <td colspan = "2">
                  <input type = "submit" value = "Edit"/>
               </td>
            </tr>
</table> 
</form:form> 
         </br></br>
<table border="1">
         	<tr>
         		<th>productID</th>
         		<th>productName</th>
 				<th>productPrice</th>
 				<th>productDescription</th>
 				<th>image</th>
 			</tr>
 			 <c:forEach var="P" items="${prodlist}">
 			<tr>
 				 
 				<td>${P.ID}</td> 
 				<td>${P.name}</td>
 				<td>${P.price}</td>
 				<td>${P.discription}</td>
 				
 
<td><img src="<c:url value='/resources/images/${P.ID}.jpg'></c:url>" height="30px" width="40px"></td>
<td>

					<a href="<c:url value='/deleteproduct?id=${P.ID }'></c:url>"><span class="glyphicon glyphicon-trash"></span></a>
					<a href="<c:url value='/getupdateproduct?id=${P.ID }'></c:url>"><span class="glyphicon glyphicon-pencil"></span></a>
					</td>
 		   	</tr>
         </c:forEach>
</table>
</div>
</body>
</html>