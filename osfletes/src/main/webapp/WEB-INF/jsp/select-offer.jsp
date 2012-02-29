<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "spring" uri = "http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
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
<div id="confirm-selection" class="form">
	<div class="form-rom">
		<div><spring:message code="client.offer.user"/></div>
		<div id="offer-user"></div>
	</div>
	<div class="form-rom">
		<div><spring:message code="client.offer.price"/></div>
		<div id="offer-price"></div>
	</div>
	<div class="form-rom">
		<div><spring:message code="client.offer.date"/></div>
		<div id="offer-date"></div>
	</div>
</div>
<c:url value="/select-offer" var="action"/>
<form:form commandName="contractDTO" id="form" action="${action}" method="POST">
	<form:hidden path="announcementDTO.id" id="announcementId"/>
	<input type="hidden" name="offerDTO.id" id="selected_offer">
</form:form>