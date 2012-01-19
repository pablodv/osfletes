<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "spring" uri = "http://www.springframework.org/tags" %>
<head>
	<script type="text/javascript" src="<c:url value="/static/js/signup-provider.js"/>"></script>
</head>

<c:url value="/signup-provider" var="action"/>
	<form:form action="${action}" commandName="signup-form" method="POST" id="form">
		<div class="form">
			<div class="form_row" >
				<div class="name"><label><spring:message code="registro.mail"/></label></div>
				<div><form:input path="mail"/></div> 
				<form:errors path="mail" element="div" cssClass="error" ></form:errors>
			</div>
			<div class="form_row" >
				<div class="name"><label><spring:message code="registro.password"/></label></div>
				<div><form:input path="password"/></div> 
				<form:errors path="password" element="div" cssClass="error" ></form:errors>
			</div>
			<div class="button_container"><span id="signup-button" class="button-class"><spring:message code="registro.boton.registrarse"/></span></div>
		</div>
	</form:form>
