<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<head>
	<script type="text/javascript" src="<c:url value="/static/js/client-closed-announcements.js"/>"></script>
</head>

<jsp:include page="client-announcements-search.jsp"></jsp:include>
<div id="resultado"></div>
