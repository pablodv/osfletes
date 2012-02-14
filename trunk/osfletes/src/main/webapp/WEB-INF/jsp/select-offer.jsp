<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "spring" uri = "http://www.springframework.org/tags" %>
<head>
	<script type="text/javascript" src="<c:url value="/static/js/select-offer.js"/>"></script>
</head>

<jsp:include page="client-offer-search.jsp"></jsp:include>
<div id="resultado"></div>
<div class="form">
	<div class="button_container">
		<span id="select" class="button-class"><spring:message code="client.button.select"/></span>
	</div>
</div>