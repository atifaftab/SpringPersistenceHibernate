<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
 
<title>Customers Search Page </title>
</head>
	<body>
	<h1>Welcome, Enter the Customer Id</h1>
		<form:form method="GET" action="first/cust" modelAttribute="customers">
			<table>
				<tr>
					<td><form:label path="id">Id</form:label></td>
					<td><form:input path="id"/></td>
					 
				</tr>
				<tr>
					<td><input type="submit" value="submit"/></td>
				</tr>
			
			</table>
		</form:form>
	</body>
</html>