<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<c:url value="/j_spring_security_check" var="action"/>

<body>
 <div class="form">
	<form name="f" action="${action}" method="POST">
	 	<div class="form_row">
		 	<div>User:</div>
			<div><input type="text" name="j_username"/></div>
		</div>
	 	<div class="form_row">
	 		<div>Password:</div>
	 		<div><input type="password" name="j_password"/></div>
	 	</div>
	 	<div class="button_container">
	 		<input id="create_btn" class="button-class" type="submit" value="login"/>
	 		<input name="reset" type="reset" value="reset" class="button-class" />
	 	</div>
	 	
	</form>
	<c:if test="${not empty param.login_error}">
		<div class="error">Invalid user/password</div>
	</c:if>
 </div>
</body>

