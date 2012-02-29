<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/javascript" %>

var ProviderUrls = {
GET_PROVIDER_OFFERS 		: "<c:url value="/provider-offers"/>",
GET_PROVIDER_ANNOUNCEMENTS	: "<c:url value="/provider-announcements"/>",
GET_CREATED_PROVIDER_OFFERS	: "<c:url value="/provider-created-offers"/>",
GET_CANCELED_PROVIDER_OFFERS	: "<c:url value="/provider-canceled-offers"/>",
GET_CANCELED_BY_CLIENT_PROVIDER_OFFERS	: "<c:url value="/provider-canceled-by-client-offers"/>",
GET_AWARDED_PROVIDER_OFFERS	: "<c:url value="/provider-awarded-offers"/>",
GET_NON_AWARDED_PROVIDER_OFFERS	: "<c:url value="/provider-non-awarded-offers"/>",
CREATE_OFFER				: "<c:url value="/create-offer"/>",
CANCEL_OFFER				: "<c:url value="/cancel-offer"/>"
};
