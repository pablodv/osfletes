<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<head>
	<jsp:include page="busqueda.jsp"></jsp:include>
	<script type="text/javascript" src="<c:url value="/static/js/provider-offer-search.js"/>"></script>
</head>
<div class="form">
	<div class="form_row">
		<div class="name"><label>Input 1</label></div>
		<div><input type="text" id="input1"/></div>
		<div class="name"><label>Input 2</label></div>
		<div><input type="text" id="input1"/></div>
	</div>
	<div class="button_container"><span id="search" class="button-class">Buscar</span></div>
</div>