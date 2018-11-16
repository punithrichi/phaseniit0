<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<body>
	<form:form method="post" action="save">
		<table>
			<tr>
				<td>Name :</td>
				<td><form:input path="category_ID" /></td>
			</tr>
			<tr>
				<td>Salary :</td>
				<td><form:input path="name" /></td>
			</tr>
			<td colspan="2"><input type="submit" value="Save" /></td>
			</tr>
		</table>

	</form:form>
</body>
</html>
