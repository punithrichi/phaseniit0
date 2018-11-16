<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri = "http://www.springframework.org/tags/form" prefix = "form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Update</title>
</head>
<body>
<body>
<div class="container">
 <h1>Update Supplier</h1>
      <form:form  action = "Updatesupplier" method = "POST" >
      <table>
    
      		<tr>
               <td>id:</td>
               <td><form:input type="hidden"  path ="ID"/></td>
            </tr>
      		  <tr>
              <td>name:</td>
               <td><form:input path = "name"/></td>
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
      </form:form>
      </table>
</div>
</body>
</html>
</body>
</html>