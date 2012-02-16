<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@page contentType="text/html" %>
<script type="text/javascript" src="<c:url value="/static/js/jquery.js"/>"></script>
<script type="text/javascript" src="<c:url value="/static/js/jquery-ui.js"/>"></script>
<script type="text/javascript" src="<c:url value="/static/js/ajax.js"/>"></script>
<script type="text/javascript" src="<c:url value="/static/js/modal-pop.js"/>"></script>
<script type="text/javascript" src="<c:url value="/public-common-constants"/>"></script>
<link rel="stylesheet" type="text/css" href="<c:url value="/static/css/loading.css"/>"></link>
<link rel="stylesheet" type="text/css" href="<c:url value="/static/css/error.css"/>"></link>
<link rel="stylesheet" type="text/css" href="<c:url value="/static/css/layout.css"/>"></link>
<link rel="stylesheet" type="text/css" href="<c:url value="/static/css/modal-pop.css"/>"></link>
<link rel="stylesheet" type="text/css" href="<c:url value="/static/css/jquery-ui.css"/>"></link>



<sec:authorize access="isAuthenticated()">
	<script type="text/javascript" src="<c:url value="/private-common-constants"/>"></script>
</sec:authorize>

<sec:authorize access="isAuthenticated() and hasRole('ROLE_ADMIN')">
	<script type="text/javascript" src="<c:url value="/admin-constants"/>"></script>
</sec:authorize>

<sec:authorize access="isAuthenticated() and (hasRole('ROLE_ADMIN') or hasRole('ROLE_CLIENT'))">
	<script type="text/javascript" src="<c:url value="/client-constants"/>"></script>
</sec:authorize>

<sec:authorize access="isAuthenticated() and (hasRole('ROLE_ADMIN') or hasRole('ROLE_PROV'))">
	<script type="text/javascript" src="<c:url value="/provider-constants"/>"></script>
</sec:authorize>


