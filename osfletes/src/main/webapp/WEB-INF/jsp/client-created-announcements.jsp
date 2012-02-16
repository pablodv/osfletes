<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "spring" uri = "http://www.springframework.org/tags" %>
<jsp:include page="client-announcements-search.jsp"></jsp:include>
<head>
	<script type="text/javascript" src="<c:url value='/static/js/client-created-announcements.js'/>"></script>
</head>

<div id="resultado"></div>
<div class="form">
	<div class="button_container">
		<span id="delete" class="button-class"><spring:message code="client.button.delete"/></span>
		<span id="publish" class="button-class"><spring:message code="client.button.publish"/></span>
	</div>
</div>