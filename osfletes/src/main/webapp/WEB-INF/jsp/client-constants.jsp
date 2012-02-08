<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/javascript" %>

var ClientUrls = {
GET_ALL_OFFERS 		: "<c:url value="/getOfertas"/>",
GET_CREATED_ANNOUNCEMENTS 		: "<c:url value="/client-created-announcements"/>",
GET_PUBLISHED_ANNOUNCEMENTS 	: "<c:url value="/client-published-announcements"/>",
GET_DELETED_ANNOUNCEMENTS 		: "<c:url value="/client-deleted-announcements"/>",
GET_CLOSED_ANNOUNCEMENTS 		: "<c:url value="/client-closed-announcements"/>",
GET_CANCELED_ANNOUNCEMENTS 		: "<c:url value="/client-canceled-announcements"/>"
};
