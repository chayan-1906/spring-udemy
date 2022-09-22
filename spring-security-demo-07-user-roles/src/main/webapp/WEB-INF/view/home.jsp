<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Luv2Code Company Home Page</title>
	</head>
	<body>
		<h2>Luv2Code Company Home Page</h2>
		<hr>
		<p>
			Welcome to Luv2Code Company Home Page!
		</p>
		
		<!-- Add a logout button -->
		<form:form action="${ pageContext.request.contextPath }/logout" method="POST">
			<input type="submit" value="Logout" />
		</form:form>
		
	</body>
</html>