<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "spring" uri = "http://www.springframework.org/tags" %>
<head>

	<jsp:include page="Header.jsp"></jsp:include>
	<script type="text/javascript" src="<c:url value="/js/provider.js"/>"></script>

</head>

<c:url value="/ofertar" var="action"/>
<form:form action="${action}" commandName="oferta" method="POST">
<div>
	<spring:message code="ofertar.oferta"/> 
</div>
<div>
	<form:input path="valorOferta" />
	<form:errors path="valorOferta" element="div" cssClass="error" ></form:errors>
</div>
<div>
	<spring:message code="ofertar.oferta"/>
</div>
<div>
	<form:input path="fechaServicio"/>
	<form:errors path="fechaServicio" element="div" cssClass="error" ></form:errors>
</div>


<input type="submit" value="Save Changes" />
</form:form>
<div id="search">Get all offers</div>
<div id="results"></div>