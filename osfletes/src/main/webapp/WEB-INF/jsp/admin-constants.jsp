<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/javascript" %>

var AdminUrls = {
SEARCH_USERS 		: "<c:url value="/get-users"/>",
REMOVE_USER 		: "<c:url value="/rm-user"/>",
CREATE_ADMIN_USER	: "<c:url value="/create-admin-user"/>",
CHANGE_USER_STATUS	: "<c:url value="/chng-user-status"/>"
};
