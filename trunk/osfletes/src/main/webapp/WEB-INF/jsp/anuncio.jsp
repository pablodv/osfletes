<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "spring" uri = "http://www.springframework.org/tags" %>
<head>
	<script type="text/javascript" src="<c:url value="/static/js/anuncio.js"/>"></script>
	<script type="text/javascript" src="http://maps.google.com/maps/api/js?sensor=false"></script>
</head>

<div id="anuncio">
	<label><spring:message code="anuncio.fechadesde"/></label><span><spring:bind path="anuncio.fechaDesde"/> </span>
	<label><spring:message code="anuncio.fechahasta"/></label><span><spring:bind path="anuncio.fechaHasta"/> </span>
	<label><spring:message code="anuncio.horadesde"/></label><span><spring:bind path="anuncio.horaDesde"/> </span>
	<label><spring:message code="anuncio.horahasta"/></label><span><spring:bind path="anuncio.horaHasta"/> </span>
	<label><spring:message code="anuncio.fechacierre"/></label><span><spring:bind path="anuncio.fechaCierre"/> </span>
</div>
<div id="google_map_container"></div>




