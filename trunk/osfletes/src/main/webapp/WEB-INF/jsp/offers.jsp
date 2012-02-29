<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "spring" uri = "http://www.springframework.org/tags" %>
<head>
	<script type="text/javascript" src="<c:url value="/static/js/tabs.js"/>"></script>
	<link rel="stylesheet" type="text/css" href="<c:url value="/static/css/tabs.css"/>"></link>
	<script type="text/javascript" src="<c:url value="/static/js/offers.js"/>"></script>
</head>

<div id="offers_tabs_container">
<ul class="tabs">
    <li class="rounded"><a href="provider-created-offers"><spring:message code="provider.inbox.offers.tab.created"/></a></li>
    <li class="rounded"><a href="provider-canceled-offers"><spring:message code="provider.inbox.offers.tab.canceled"/></a></li>
    <li class="rounded"><a href="provider-awarded-offers"><spring:message code="provider.inbox.offers.tab.awarded"/></a></li>
    <li class="rounded"><a href="provider-non-awarded-offers"><spring:message code="provider.inbox.offers.tab.non-awarded"/></a></li>
    <li class="rounded"><a href="provider-canceled-by-client-offers"><spring:message code="provider.inbox.offers.tab.canceled-by-client"/></a></li>
</ul>

<div class="tab_container">
</div>
</div>