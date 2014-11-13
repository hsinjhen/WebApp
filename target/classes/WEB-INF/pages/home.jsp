<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page session="true"%>
<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>Home page</title>
</head>
<body>
	<h1>Welcome!</h1>
	<p>${title}</p>
	<p>${message}<br />
	</p>
	<%-- <a
			href="${pageContext.request.contextPath}/team/add.html">Add new
			team</a><br /> <a
			href="${pageContext.request.contextPath}/team/list.html">Team
			list</a><br /> --%>

	<%-- <c:url value="/logout" var="logoutUrl" /> --%>

	<c:url value="/j_spring_security_logout" var="logoutUrl" />

	<form action="${logoutUrl}" method="post" id="logoutForm">
		<%-- <c:if test="${pageContext.request.userPrincipal.name != null}">
			<h3>
				Hi : ${pageContext.request.userPrincipal.name} | <input
					name="submit" type="submit" value="Logout" />
			</h3>
		</c:if> --%>

		<c:choose>
			<c:when test="${pageContext.request.userPrincipal.name != null}">
				<h3>
					Hi : ${pageContext.request.userPrincipal.name} | <input
						name="submit" type="submit" value="Logout" />
				</h3>
			</c:when>
			<c:otherwise>
				<p>
					<a href="${pageContext.request.contextPath}/login">Proceed to
						Login Page</a>
				</p>
			</c:otherwise>
		</c:choose>

		<input type="hidden" name="${_csrf.parameterName}"
			value="${_csrf.token}" />
	</form>
</body>
</html>