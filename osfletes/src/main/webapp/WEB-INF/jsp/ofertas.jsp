<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "spring" uri = "http://www.springframework.org/tags" %>

<c:url value="/crearOferta" var="action"/>
<form:form action="${action}" commandName="oferta">
<div><spring:message code="ofertar.oferta"/> </div>
<div><form:input path="valorOferta"/></div>
<input type="submit" value="Save Changes" />
</form:form>