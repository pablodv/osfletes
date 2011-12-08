<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "spring" uri = "http://www.springframework.org/tags" %>

<c:forEach items="${ofertas}" var="oferta">
<div>${oferta.valorOferta}</div>
</c:forEach>
