<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*, java.lang.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Jeff's new JSP File</title>
    <link rel="stylesheet" type="text/css" href="/css/styles.css" />
    <script type="text/javascript" src="/js/app.js"></script>
</head>
<body>
	<form:form action="/persons/new" method="post" modelAttribute="person">
		<p>
			<form:label path="firstName">First Name</form:label>
			<form:input path="firstName"/>
			<form:errors path="firstName"/>
		</p>
		<p>
			<form:label path="lastName">Last Name</form:label>
			<form:input path="lastName"/>
			<form:errors path="lastName"/>
		</p>
		<p>
			<input type="submit" value="Create"/>
		</p>
	</form:form>
</body>
</html>