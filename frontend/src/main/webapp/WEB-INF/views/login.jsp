<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
        <head>
            <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
            <title>Login</title>
            <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
            
        </head>
        <body align="center">
<h1 align="center" class="a-spacing-small"> Login </h1>
<c:url value="/j_spring_security_check" var="url"></c:url>
<form action="${url}" method="post">
<p>${loginError}</p>
<br/>
<b>User Name or Email:</b>
<br>
<input type="text" name="j_username" value="">
<br>
<b>Password:</b>
<br>
<input type="password" name="j_password" value="">
<br>
<br>

<button type="submit" >sign in</button></br> </br>

</form>

</body>
        </html>