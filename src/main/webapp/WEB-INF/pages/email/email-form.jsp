<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
     "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Email with Spring MVC</title>
</head>
<body>
	<p>${message}</p>
	<center>
		<form method="post" action="${pageContext.request.contextPath}/email/sendEmail" enctype="multipart/form-data">
			<table border="0" width="80%">
				<tr>
					<td>To:</td>
					<td><input type="text" name="recipient" size="65" /></td>
				</tr>
				<tr>
					<td>Subject:</td>
					<td><input type="text" name="subject" size="65" /></td>
				</tr>
				<tr>
					<td>Message:</td>
					<td><textarea cols="50" rows="10" name="body"></textarea></td>
				</tr>
				<tr>
                    <td>Attach file:</td>
                    <td><input type="file" name="attachedFile" size="60" /></td>
                </tr> 
				<tr>
					<td colspan="2" align="center"><input type="submit"
						value="Send E-mail" /></td>
				</tr>
			</table>
		</form>
	</center>
</body>
</html>