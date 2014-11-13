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
<title>List of teams</title>
</head>
<body>
	<p>${message}</p>
	<h1>List of teams</h1>
	<p>Here you can see the list of the teams, edit them, remove or
		update.</p>

	<c:url
		value="/team/search"
		var="searchUrl" />
	<form action="${searchUrl}" method="get">
		Search Team: <select name="criteria">
			<option value="id">By Id</option>
			<option value="name">By Name</option>
		</select><input type="text" name="parameter" /> <input type="submit"
			value="Search" />
	</form>
	<p align="right">
		<a href="${pageContext.request.contextPath}/team/add">Add Team</a>
	</p>
	<table border="1px" cellpadding="0" cellspacing="0" width="100%">
		<thead>
			<tr>
				<th width="10%">id</th>
				<th width="15%">name</th>
				<th width="10%">rating</th>
				<th width="10%">actions</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="team" items="${teams}">
				<tr>
					<td>${team.id}</td>
					<td>${team.name}</td>
					<td>${team.rating}</td>
					<td><a
						href="${pageContext.request.contextPath}/team/edit/${team.id}">Edit</a><br />
						<a
						href="${pageContext.request.contextPath}/team/delete/${team.id}">Delete</a><br />
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