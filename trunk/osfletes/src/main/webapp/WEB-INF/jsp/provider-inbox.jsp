<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "spring" uri = "http://www.springframework.org/tags" %>
<head>

	<script type="text/javascript" src="<c:url value="/static/js/tabs.js"/>"></script>
	<link rel="stylesheet" type="text/css" href="<c:url value="/static/css/tabs.css"/>"></link>
	<script type="text/javascript" src="<c:url value="/static/js/provider-inbox.js"/>"></script>

</head>

<div id="tabs_container">
<ul class="tabs">
    <li class="rounded"><a href="in-progress"><spring:message code="proveedor.be.tab.perfil"/></a></li>
    <li class="rounded"><a href="ver-anuncios"><spring:message code="proveedor.be.tab.anuncios"/></a></li>
    <li class="rounded"><a href="in-progress"><spring:message code="proveedor.be.tab.ofertas"/></a></li>
</ul>

<div class="tab_container">
</div>
</div>
