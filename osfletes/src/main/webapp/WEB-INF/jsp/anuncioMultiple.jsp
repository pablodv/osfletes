<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
 
<html>
<body>
	<h1>New Car</h1>
	
	<c:url value="/guardarAnuncio" var="action"/>
 	<form:form method="post" action="${action}" commandName="anuncio">
 
		fecha desde<br />
		<form:input path="fechaDesde"/><br /><br />
 
		fecha hasta<br />
		<form:input path="fechaHasta"/><br /><br />
 
		<input type="submit" value="Submit">
 
	</form:form>
</body>
</html>