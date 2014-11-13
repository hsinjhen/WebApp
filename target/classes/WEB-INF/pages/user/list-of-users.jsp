<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page session="true"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<?xml version="1.0" encoding="ISO-8859-1" ?>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>List of users</title>
</head>
<body>
	<p>${message}</p>
	<h1>List of users</h1>
	<p>Here you can see the list of the users, invalidate or
		update users.</p>

	<c:url
		value="/user/search"
		var="searchUrl" />
	<form action="${searchUrl}" method="get">
		Search Team: <select name="criteria">
			<option value="id">By Id</option>
			<option value="username">By Username</option>
			<option value="userRole">By Role</option>
		</select><input type="text" name="parameter" /> <input type="submit"
			value="Search" />
	</form>
	<p align="right">
		<a href="${pageContext.request.contextPath}/user/add">Add User</a>
	</p>
	<table border="1px" cellpadding="0" cellspacing="0" width="100%">
		<thead>
			<tr>
				<th width="10%">Id</th>
				<th width="25%">Username</th>
				<th width="25%">userRole</th>
				<th width="15%">Actions</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="user" items="${users}">
				<tr>
					<td>${user.id}</td>
					<td>${user.login}</td>
					<td>${user.userRole.roleId.role}</td>
					<td><a
						href="${pageContext.request.contextPath}/user/edit/${user.id}">Edit</a><br />
						<a
						href="${pageContext.request.contextPath}/user/invalidate/${user.id}">Invalidate</a><br />
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<p>
		<a href="${pageContext.request.contextPath}/team">Home page</a>
	</p>
</body>
</html>