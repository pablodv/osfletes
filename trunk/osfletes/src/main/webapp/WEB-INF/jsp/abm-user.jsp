<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<head>
	<jsp:include page="busqueda.jsp"></jsp:include>
	<script type="text/javascript" src="<c:url value="/static/js/abm-user.js"/>"></script>
</head>

<div class="form">
	<div class="form_row">
		<div class="name"><label>Nombre</label></div>
		<div><input type="text" id="username"/></div>
	</div>
	<div class="form_row">
		<div class="name"><label>Habilitado</label></div>
		<div>
			<select id="enable">
				<option value="" selected="selected">---</option>
				<option value="0">No</option>
				<option value="1">Si</option>
			</select>
		</div>
	</div>
	<div class="button_container"><span id="search" class="button-class">Buscar</span></div>
</div>
<div id="resultado"></div>
