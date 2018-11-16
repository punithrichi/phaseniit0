<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib uri = "http://www.springframework.org/tags/form" prefix = "form"%>
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
 <h2> Supplier</h2>
       <form:form method = "POST" action = "addSupplier">
         <table>
         <tr>
         <td><form:label path = "name">Name</form:label></td>
               <td><form:input path = "name" /></td>
               
            </tr>
            <tr>
               
               <td><form:label path = "ID">ID</form:label></td>
               <td><form:input path = "ID" /></td>
            </tr>
            <tr>
               
               <td><form:label path = "details">details</form:label></td>
               <td><form:input path = "details" /></td>
            </tr>
            <tr>
               
               <td><form:label path = "contact">contact</form:label></td>
               <td><form:input path = "contact"   /></td>
            </tr>
            
            <tr>
               <td colspan = "2">
                  <input type = "submit" value = "Submit"/>
               </td>
            </tr>
         </table>  
      </form:form>
       <br />
      <a href="getsupplier">getallsuppliers</a>
      <br />
      <br />
       <table border="1">
         	<tr>
         		<th>ID</th>
         		<th>Name</th>
 				<th>details</th>
 				<th>contact</th>
 				
 		
 			</tr>
 			 <c:forEach var="P" items="${suplist}">
 			<tr>
 				 
 				<td>${P.ID}</td> 
 				<td>${P.name}</td>
 				<td>${P.details}</td>
 				<td>${P.contact}</td>
 				<td>

					<a href="<c:url value='/deletesupplier?id=${P.ID}'></c:url>"><span class="glyphicon glyphicon-trash"></span></a>
					<a href="<c:url value='/getupdatesupplier?id=${P.ID}'></c:url>"><span class="glyphicon glyphicon-pencil"></span></a>
					</td>
 				
 				
 				</tr>	
 				  </c:forEach>
 				  
 				  </table>
   </body>
   
</html>
