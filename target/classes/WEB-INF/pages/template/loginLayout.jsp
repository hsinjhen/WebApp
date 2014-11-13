<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ include file="commontags.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@include file="/WEB-INF/resources/css/login.css"%>
<title><tiles:insertAttribute name="title" ignore="true" /></title>
</head>
<body>
	<div id="mainDiv" class="main">
		<div id="header" class="mainheader">
			<tiles:insertAttribute name="header" />
		</div>

		<div id="main">
			<div class="menu">
				<tiles:insertAttribute name="leftPane" />
			</div>
			<div id="content" class="content">
				<tiles:insertAttribute name="content" />
			</div>
		</div>

		<div class="footer">
			<tiles:insertAttribute name="footer" />
		</div>
	</div>
</body>
</html>