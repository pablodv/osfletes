<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "spring" uri = "http://www.springframework.org/tags" %>
<jsp:include page="provider-offer-search.jsp"></jsp:include>
<head>
	<script type="text/javascript" src="<c:url value='/static/js/provider-created-offers.js'/>"></script>
</head>

<div id="resultado"></div>
<div class="form">
	<div class="button_container">
		<span id="cancel" class="button-class"><spring:message code="provider.button.cancel-offer"/></span>
	</div>
</div>