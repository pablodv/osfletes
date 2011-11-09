<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:url value="/crearOferta" var="action"/>
<form:form action="${action}" commandName="oferta">
<div>cuanto pay:</div>
<div><form:input path="valorOferta"/></div>
<input type="submit" value="Save Changes" />
</form:form>