<%@ taglib prefix = "spring" uri = "http://www.springframework.org/tags" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<head>
	<sec:authorize access="isAnonymous()">
		<script type="text/javascript" src="<c:url value="/static/js/header.js"/>"></script>	
	</sec:authorize>
</head>
<div class="header border-round">
	<span class="titulo"><spring:message code="header.titulo"></spring:message> </span>
	<span class="subtitulo"><spring:message code="header.subtitulo"></spring:message></span>
	<sec:authorize access="isAnonymous()">
		<div class="header-buttons-container"><span id="signup" class="tiny-button-class"><spring:message code="signup"></spring:message></span><span id="signin" class="tiny-button-class"><spring:message code="signin"></spring:message></span></div>
	</sec:authorize>
</div>