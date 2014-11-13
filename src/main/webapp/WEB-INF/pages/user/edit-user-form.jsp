<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page session="true"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<?xml version="1.0" encoding="ISO-8859-1" ?>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>Edit user page</title>
</head>
<body>
	<h1>Edit user page</h1>
	<p>Here you can edit the existing user.</p>
	<p>${message}</p>
	<form:form method="POST" commandName="user"
		action="${pageContext.request.contextPath}/user/edit/${user.id}">
		<table>
			<tbody>
				<tr>
					<td>Username:</td>
					<td><form:input path="login" /></td>
				</tr>
				<tr>
					<td>Password:</td>
					<td><form:password path="password" /></td>
				</tr>
				<tr>
					<td>User Role:</td>
					<td><form:select path="role">
							<form:options items="${userRoles}"></form:options>
						</form:select></td>
				</tr>
				<tr>
					<td><input type="submit" value="Edit User" /></td>
					<td></td>
				</tr>
			</tbody>
		</table>
		<input type="hidden" name="${_csrf.parameterName}"
			value="${_csrf.token}" />
	</form:form>

	<p>
		<a href="${pageContext.request.contextPath}/team">Home page</a>
	</p>
</body>
</html>