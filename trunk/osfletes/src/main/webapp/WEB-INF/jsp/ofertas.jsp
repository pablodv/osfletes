<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "spring" uri = "http://www.springframework.org/tags" %>
<head>

	<jsp:include page="Header.jsp"></jsp:include>
	<script type="text/javascript" src="<c:url value="/js/provider.js"/>"></script>
	<script type="text/javascript" src="<c:url value="/js/tabs.js"/>"></script>
	<link rel="stylesheet" type="text/css" href="<c:url value="/css/tabs.css"/>"></link>

</head>

<ul class="tabs">
    <li class="rounded"><a href="#tab1">Ofertar</a></li>
    <li class="rounded"><a href="#tab2">listado</a></li>
</ul>

<div class="tab_container">
    <div id="tab1" class="tab_content">
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
    </div>
    <div id="tab2" class="tab_content">
       	<div id="search">Get all offers</div>
		<div id="results"></div>
	</div>
</div>



