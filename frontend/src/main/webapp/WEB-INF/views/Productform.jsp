<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib uri = "http://www.springframework.org/tags/form" prefix = "form"%>
  <%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<title>Spring MVC Form Handling</title>
<style>
table, th, td {
    border: 2px solid black;
    border-collapse: collapse;
    padding: 5px
}
</style>
</head>
 <body>
 
 <h2> Product</h2>
       <form:form method = "POST" action = "addProduct" enctype="multipart/form-data">
         <table>
         <tr>
         <td><form:label path = "name">Name</form:label></td>
               <td><form:input path = "name" /></td>
               
            </tr>
            <tr>
               
               <td><form:label path = "ID">id</form:label></td>
               <td><form:input path = "ID" /></td>
            </tr>
            <tr>
               
               <td><form:label path = "price">price</form:label></td>
               <td><form:input path = "price" /></td>
            </tr>
            
             <tr>
               
               <td><form:label path = "stock">stock</form:label></td>
               <td><form:input path = "stock" /></td>
            </tr>
              <tr>
               
               <td><form:label path = "discription">discription</form:label></td>
               <td><form:input path = "discription" /></td>
            </tr>
            <tr>
		<td>Select Category</td>
		<td><form:select path="category.category_ID"><!-- product.category.id=6 -->
		<c:forEach items="${categories}" var="c"><!-- c is an Object of Type Category -->
		<form:option value="${c.category_ID }">${c.name }</form:option>
		
		</c:forEach>
	
		</form:select>
		<form:errors path="category" cssStyle="color:red"></form:errors>
		</td>
		</tr>
		<tr>
		<td>Upload an image</td>
		<td><form:input type="file" path="image" ></form:input></td>
		</tr>
		
           
            <tr>
               <td colspan = "2">
                  <input type = "submit" value = "Submit"/>
               </td>
            </tr>
         </table>  
      </form:form>
      <br />
      <a href="getproduct">getallproducts</a>
      <br />
      <br />
       <table border="1">
         	<tr>
         		<th>productID</th>
         		<th>productName</th>
 				<th>productPrice</th>
 				<th>productDescription</th>
 				<th>image</th>
 			</tr>
 			 <c:forEach var="P" items="${prodlist}" >
 			  
 			<tr>
 				 
 				<td>${P.ID}</td> 
 				<td>${P.name}</td>
 				<td>${P.price}</td>
 				<td>${P.discription}</td>
 				<td><img src="<c:url value='/resources/images/${P.ID }.jpg'></c:url>" height="40px" width="50px"></td>
 				<td>

					<a href="<c:url value='/deleteproduct?id=${P.ID }'></c:url>"><span class="glyphicon glyphicon-trash"></span></a>
					<a href="<c:url value='/getupdateproduct?id=${P.ID }'></c:url>"><span class="glyphicon glyphicon-pencil"></span></a>
					</td>
 				</tr>	
 				  </c:forEach>
 				  </table>
 				  </body>
 				  </html>
