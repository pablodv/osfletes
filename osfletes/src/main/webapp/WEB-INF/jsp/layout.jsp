<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<body>
	<div class="main_container">
		<div class="header"><tiles:insertAttribute name="header" /></div>
		<div class="body">
			<tiles:insertAttribute name="body" />
		</div>
		<div class="footer"><tiles:insertAttribute name="footer" /></div>
	</div>
</body>