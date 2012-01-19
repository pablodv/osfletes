<%@ taglib prefix = "spring" uri = "http://www.springframework.org/tags" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<head>
	<link rel="stylesheet" type="text/css" href="<c:url value="/static/css/logbar.css"/>"></link>
	<script type="text/javascript" src="<c:url value="/static/js/logbar.js"/>"></script>
</head>
<c:url value="/j_spring_security_logout" var="action"/>
<div class="logbar">
  <div class="buttons-container">
	  <span class="tiny-button-class"><sec:authentication property="principal.username"></sec:authentication></span>
	  <span id="logout" class="tiny-button-class"><spring:message code="logout"></spring:message></span>
	  <form action="${action}" method="get" id="logout-form">
	  	<input type="hidden" name="logout-success-url" value="/index" />
	  </form>
  </div>
</div>