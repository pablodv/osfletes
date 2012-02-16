<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix = "spring" uri = "http://www.springframework.org/tags" %>
 
<head>
	<script type="text/javascript" src="<c:url value="/static/js/create-announcement.js"/>"></script>
</head>
<body>
	<c:url value="/create-announcement" var="action"/>
 	<form:form method="post" id="form" action="${action}" commandName="anuncioDTO">
		<div class="form">
 		<div class="form_row">
	 		<div><label><spring:message code="client.announcement.hour.from"/></label></div>
			<div><form:input path="horaDesde"/><form:errors path="horaDesde" element="span" cssClass="error" ></form:errors></div>
		</div>
 
 		<div class="form_row">
	 		<div><label><spring:message code="client.announcement.hour.to"/></label></div>
			<div><form:input path="horaHasta"/><form:errors path="horaHasta" element="span" cssClass="error" ></form:errors></div>
		</div>
		
		<div class="form_row">
	 		<div><label><spring:message code="client.announcement.address"/></label></div>
			<div><form:input path="direccion1"/><form:errors path="direccion1" element="span" cssClass="error" ></form:errors></div>
		</div>
		
		<div class="form_row">
	 		<div><label><spring:message code="client.announcement.date.from"/></label></div>
			<div><form:input path="fechaDesde" id="from" name="from"/><form:errors path="fechaDesde" element="div" cssClass="error" ></form:errors></div>
		</div>
		
		<div class="form_row">
	 		<div><label><spring:message code="client.announcement.date.to"/></label></div>
			<div><form:input path="fechaHasta" id="to" name="to"/><form:errors path="fechaHasta" element="div" cssClass="error" ></form:errors></div>
		</div>
		
		<div class="form_row">
	 		<div><label><spring:message code="client.announcement.description"/></label></div>
			<div><form:textarea path="descripcion"/><form:errors path="descripcion" element="div" cssClass="error" ></form:errors></div>
		</div>
		<div class="button_container"><span id="create_btn" class="button-class"><spring:message code="client.announcement.description"/></span></div>
 		</div>
	</form:form>
</body>
