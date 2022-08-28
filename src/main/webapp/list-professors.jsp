<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Καθηγητές</title>
<link rel="stylesheet" href="./styles/list-professors.css">
<link rel="stylesheet" href="./styles/general.css">
<link rel="stylesheet" href="./styles/card.css">
</head>
<body>
<h1 class="applied-informatics-info__card">applied-informatics-info</h1>
<section class="applied-informatics-info__card">
<table>
<tr>
	<th>Name</th>
	<th>SurName</th>
	<th>Phone</th>
	<th>Email</th>
</tr>
<c:forEach var="tempProfessor" items="${professors }">
	<c:url var="tempUrl" value="ProfessorControllerServlet">
		<c:param name="email" value="${tempProfessor.email }"></c:param>
		<c:param name="command" value="remove"></c:param>	
	</c:url>
	<tr>
	<td>${tempProfessor.first_name }</td>
	<td>${tempProfessor.last_name }</td>
	<td>${tempProfessor.phone }</td>
	<td>${tempProfessor.email }</td>
	<td><a href="${tempUrl }">Remove</a></td>
	</tr>
</c:forEach>
</table>
</section>

<section class="applied-informatics-info__card">
<table>
<tr>
	<th>Add professor</th>
</tr>
<tr>
	<td><a href="add-professor.jsp">ADD</a></td>
</tr>
</table>
</section>
</body>
</html>