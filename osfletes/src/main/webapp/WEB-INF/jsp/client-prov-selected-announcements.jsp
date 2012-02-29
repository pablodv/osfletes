<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<jsp:include page="client-announcements-search.jsp"></jsp:include>
<head>
	<script type="text/javascript" src="<c:url value="/static/js/client-prov-selected-announcements.js"/>"></script>
</head>

<div id="resultado"></div>
