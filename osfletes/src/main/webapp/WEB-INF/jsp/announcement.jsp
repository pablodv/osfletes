<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "spring" uri = "http://www.springframework.org/tags" %>
<head>

	<script type="text/javascript" src="<c:url value="/static/js/tabs.js"/>"></script>
	<link rel="stylesheet" type="text/css" href="<c:url value="/static/css/tabs.css"/>"></link>
	<script type="text/javascript" src="<c:url value="/static/js/announcements.js"/>"></script>

</head>

<div id="announcements_tabs_container">
<ul class="tabs">
    <li class="rounded"><a href="client-created-announcements"><spring:message code="announce.tab.created"/></a></li>
    <li class="rounded"><a href="client-published-announcements"><spring:message code="announce.tab.published"/></a></li>
    <li class="rounded"><a href="client-closed-announcements"><spring:message code="announce.tab.published-close"/></a></li>
</ul>

<div class="tab_container">
</div>
</div>