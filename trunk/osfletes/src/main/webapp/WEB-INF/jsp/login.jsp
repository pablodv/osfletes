<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<c:url value="/j_spring_security_check" var="action"/>
<style>
<!--
div,span{
	margin: 10px;
	padding: 3px;
	}
body{
	background-color: gray;
	}
.error{
	font-family: monospace;
	font-weight: bold;
	color: red;
	}
.login-box{
	display: table;
	vertical-align: middle;
	width:200px;
	height:200px;
	background-color: gray;
	border-collapse: collapse;
	top:50%;
	left:50%;
	margin-top:-100px;
	margin-left:-100px;
	position: absolute;
	}
.login-box > div,span{
	position: static;
	}
.login-param{
	display: table-row;
	font-family: monospace;
	font-weight: bold;
	color: white;
	margin:auto;
	}
.login-cell{
	display:table-cell;
	background-color:oliveaqua;
	font-family: sans-serif;
	font-size: small;
	margin:auto;
	}
.login-foot{
	display:table-cell;
	background-color:oliveaqua;
	font-family: sans-serif;
	font-size: small;
	padding: 10px;
	margin:auto;
	}
-->
</style>
<body>
 <div class="login-box">
	<form name="f" action="${action}" method="POST">
	 	<span class="login-param">
	 		<span class="login-cell">User:</span>
	 		<span class="login-cell"><input type="text" name="j_username"/></span>
	 	</span>
	 	<span class="login-param">
	 		<span class="login-cell">Password:</span>
	 		<span class="login-cell"><input type="password" name="j_password"/></span>
	 	</span>
	 	<span class="login-param">
	 		<span class="login-foot"><input name="submit" type="submit" value="login"/></span>
	 		<span class="login-foot"><input name="reset" type="reset" value="reset"/></span>
	 	</span>
	</form>
	<c:if test="${not empty param.login_error}">
		<div class="error">Invalid user/password</div>
	</c:if>
 </div>
</body>

