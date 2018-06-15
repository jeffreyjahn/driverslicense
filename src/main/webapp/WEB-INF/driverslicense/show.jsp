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
	<c:set var="license" value="${ person.getLicense() }"/>
	<h1><c:out value="${ person.getFirstName() }"/> <c:out value="${ person.getLastName() }"/></h1>
	<table>
		<tr>
			<td>License Number:</td>
			<td><c:out value="${ license.getNumber() }"/></td>
		</tr>
		<tr>
			<td>State:</td>
			<td><c:out value="${ license.getState() }"/></td>
		</tr>
		<tr>
			<td>Expiration Date:</td>
			<td><c:out value="${ license.getExpiration_date() }"/></td>
		</tr>
	</table>
</body>
</html>