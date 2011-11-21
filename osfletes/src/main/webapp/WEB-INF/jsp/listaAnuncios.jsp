<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "spring" uri = "http://www.springframework.org/tags" %>

<c:forEach items="${lista}" var="anuncio">
<div>${anuncio.fechaDesde}</div>
<div>${anuncio.fechaHasta}</div>
<div>${anuncio.horaDesde}</div>
<div>${anuncio.horaHasta}</div>
<div>${anuncio.direccion1}</div>
<div>${anuncio.direccion2}</div>
</c:forEach>