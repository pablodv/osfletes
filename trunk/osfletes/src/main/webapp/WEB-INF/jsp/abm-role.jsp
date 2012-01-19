<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<head>
	<script type="text/javascript" src="<c:url value="/static/js/abm-rol.js"/>"></script>
</head>

<div class="form">
	<div class="form_row">
		<div class="name"><label>Rol</label></div>
		<div><input type="text" id="role"/></div>
	</div>
	<div class="button_container"><span id="search" class="button-class">Buscar</span></div>
</div>
<div id="resultado"></div>
