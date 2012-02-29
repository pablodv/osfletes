<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "spring" uri = "http://www.springframework.org/tags" %>
<head>
	<jsp:include page="commons.jsp"></jsp:include>
	<script type="text/javascript" src="<c:url value='/static/js/provider-announcements.js'/>"></script>
</head>
<jsp:include page="provider-announcements-search.jsp"></jsp:include>

<div id="resultado"></div>
<div class="form">
	<div class="button_container">
		<span id="offer" class="button-class"><spring:message code="provider.button.offer"/></span>
	</div>
</div>
<div class="form" id="offer-form">
	<div class="form_row">
		<div><spring:message code="provider.label.value"/></div>
		<div><input type="text" id="value" name="value"/></div>
	</div>
	<div class="form_row">
		<div><spring:message code="provider.label.service.date"/></div>
		<div><input type="text" readonly="readonly" id="serviceDate" name="serviceDate"/></div>
	</div>
</div>