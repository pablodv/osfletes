<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<jsp:include page="commons.jsp"></jsp:include>
</head>
<body>
	<div class="main_container border-round">
		<div><tiles:insertAttribute name="header" /></div>
		<div class="body">
			<tiles:insertAttribute name="body" />
		</div>
		<div><tiles:insertAttribute name="footer" /></div>
	</div>
</body>