<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "spring" uri = "http://www.springframework.org/tags" %>
<head>
	<script type="text/javascript" src="<c:url value="/static/js/filtro.js"/>"></script>
	<script type="text/javascript" src="<c:url value="/static/js/busqueda-anuncios.js"/>"></script>
</head>

<div id="anuncio">
	<label><spring:message code="anuncio.fechadesde"/></label><form:input id="fechaDesde" path="anuncio.fechaDesde"/>
	<label><spring:message code="anuncio.fechahasta"/></label><form:input id="fechaHasta" path="anuncio.fechaHasta"/>
	<label><spring:message code="anuncio.horadesde"/></label><form:input id="horaDesde" path="anuncio.horaDesde"/>
	<label><spring:message code="anuncio.horahasta"/></label><form:input id="horaHasta" path="anuncio.horaHasta"/>
	<label><spring:message code="anuncio.fechacierre"/></label><form:input id="fechaCierre" path="anuncio.fechaCierre"/>
</div>
<div id="btn_busqueda" class="btn"></div>


