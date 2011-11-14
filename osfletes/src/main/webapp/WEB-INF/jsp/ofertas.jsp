<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "spring" uri = "http://www.springframework.org/tags" %>
<head>
	<script type="text/javascript" src="<c:url value="/Constants"/>"></script>
	<script type="text/javascript" src="<c:url value="/js/jquery-1.7.min.js"/>"></script>
	<script type="text/javascript" src="<c:url value="/js/provider.js"/>"></script>
</head>

<c:url value="/crearOferta" var="action"/>
<form:form action="${action}" commandName="oferta">
<div><spring:message code="ofertar.oferta"/> </div>
<div><form:input path="valorOferta"/></div>
<input type="submit" value="Save Changes" />
</form:form>
<div id="search">Get all offers</div>
<div id="results"></div>