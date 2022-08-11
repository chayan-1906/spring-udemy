<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Student Registration Form</title>
	</head>

	<body>
		<form:form action="processForm" modelAttribute = "student">
			First name: <form:input path="firstName" />
			<br><br>
			Last name: <form:input path="lastName" />
			<br><br>
			Country
			<form:select path="country">
				<%-- <form:option value="Brazil" label="Brazil" />
				<form:option value="France" label="France" />
				<form:option value="Germany" label="Germany" />
				<form:option value="India" label="India" /> --%>
				<form:options items="${student.countryOptions}"/>
			</form:select>
			<br><br>
			Favorite Language:
			<form:radiobutton path="favoriteLanguage" value="Java" /> Java
			<form:radiobutton path="favoriteLanguage" value="C#" /> C#
			<form:radiobutton path="favoriteLanguage" value="PHP" /> PHP
			<form:radiobutton path="favoriteLanguage" value="Ruby" /> Ruby
			<br><br>
			Operating Systems:
			<form:checkbox path="operatingSystems" value="MacOS"/> Mac
			<form:checkbox path="operatingSystems" value="Windows"/> Windows
			<form:checkbox path="operatingSystems" value="Linux"/> Linux
			<br><br>
			<input type="submit" value="Submit" />
		</form:form>
	</body>
</html>