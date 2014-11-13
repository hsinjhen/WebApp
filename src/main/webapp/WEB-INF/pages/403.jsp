<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<body>
	<h2>HTTP Status 403 - Access is denied</h2>
	<c:choose>
		<c:when test="${empty username}">
			<h2>You do not have permission to access this page!</h2>
		</c:when>
		<c:otherwise>
			<h4>
				Username : ${username} <br /> You do not have permission to access
				this page!
			</h4>
		</c:otherwise>
	</c:choose>
</body>
</html>