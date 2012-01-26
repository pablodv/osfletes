<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<head>
	<jsp:include page="busqueda.jsp"></jsp:include>
	<jsp:include page="modal-pop.jsp"></jsp:include>
	<script type="text/javascript" src="<c:url value="/static/js/abm-role.js"/>"></script>
	
</head>

<div class="form">
	<div class="form_row">
		<div class="name"><label>Rol</label></div>
		<div><input type="text" id="role"/></div>
	</div>
	<div class="button_container"><span id="search" class="button-class">Buscar</span></div>
</div>
<div id="resultado"></div>
<div id="edition-div" class="form">
	<div class="form_row">
		<div class="name"><label>Role Name</label></div>
		<div><input type="text" id="role_name" name="role"/></div>
	</div>
</div>
