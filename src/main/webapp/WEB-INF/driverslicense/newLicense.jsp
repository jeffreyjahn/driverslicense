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
	<form:form action="/licenses/new" method="post" modelAttribute="license">
		<p>
			Person:
			<select name="connectPerson">
				<c:forEach var="person" items="${ people }">
					<c:set var ="fname" value="${ person.getFirstName() }"/>
					<c:set var ="lname" value="${ person.getLastName() }"/>
					<option value="${ fname } ${ lname }"><c:out value="${ fname }"/> <c:out value="${ lname }"/></option>
				</c:forEach>
			</select>
		</p>
		<p>
			<form:label path="state">State</form:label>
			<form:input path="state"/>
			<form:errors path="state"/>
		</p>
		<p>
			Expiration Date:
			<input type="date" name="checkDate" />
		</p>
		<p>
			<input type="submit" value="Create"/>
		</p>
	</form:form>
	
</body>
</html>