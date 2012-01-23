<%@ taglib prefix = "spring" uri = "http://www.springframework.org/tags" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<head>
	<link rel="stylesheet" type="text/css" href="<c:url value="/static/css/logbar.css"/>"></link>
	<script type="text/javascript" src="<c:url value="/static/js/logbar.js"/>"></script>
	<link rel="stylesheet" type="text/css" href="<c:url value="/static/css/menu.css"/>"></link>
	<script type="text/javascript" src="<c:url value="/static/js/menu.js"/>"></script>
</head>
<div class="logbar">
  <div class="buttons-container">
	  <ul>
		  <li id="user-menu" >
			  <span class="tiny-button-class"><sec:authentication property="principal.username"></sec:authentication></span>
		  </li>
	  	  <li id="inicio" >
			  <a class="tiny-button-class" href="<c:url value="index"/>">Inicio</a>
		  </li>
	  </ul>
  </div>
</div>

<c:url value="/j_spring_security_logout" var="action"/>
<form action="${action}" method="get" id="logout-form">
	<input type="hidden" name="logout-success-url" value="/index" />
</form>