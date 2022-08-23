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
</head>
<body>
<table>
<tr>
	<th>Name</th>
	<th>SurName</th>
	<th>Phone</th>
	<th>Email</th>
</tr>
<c:forEach var="tempProfessor" items="${professors }">
	<tr>
	<td>${tempProfessor.first_name }</td>
	<td>${tempProfessor.last_name }</td>
	<td>${tempProfessor.phone }</td>
	<td>${tempProfessor.email }</td>
	</tr>
</c:forEach>
</table>
<hr>
<table>
<tr>
	<th>Add professor</th>
</tr>
<tr>
	<td><a href="add-professor.jsp">ADD</a></td>
</tr>
</table>
</body>
</html>