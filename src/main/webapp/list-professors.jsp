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
<link rel="stylesheet" href="./styles/parallax-template.css">
<%@ include file="styles/loadFonts.html" %>

</head>
<body>

<%@ include file="templates/header.html" %>
<nav>
	<h2>Τμήμα Εφαρμοσμένης Πληροφορικής</h2>
	<h3>Τμήμα Εφαρμοσμένης Πληροφορικής / Ακαδημαϊκό Προσωπικό</h3>
</nav>

<main>
<h1 class="applied-informatics-info__card">applied-informatics-info</h1>
<section class="applied-informatics-info__card">
<table>
<tr>
	<th>Name</th>
	<th>SurName</th>
	<th>Phone</th>
	<th>Email</th>
	<th></th>
</tr>
<c:forEach var="tempProfessor" items="${professors }">
	<c:url var="tempUrl" value="ProfessorControllerServlet">
		<c:param name="email" value="${tempProfessor.email }"></c:param>
		<c:param name="command" value="remove"></c:param>	
	</c:url>
	<c:url var="urlForUpdatingAProfessor" value="ProfessorControllerServlet">
		<c:param name="professorEmail" value="${tempProfessor.email }"></c:param>
		<c:param name="command" value="load"></c:param>
	</c:url>
	<tr>
	<td>${tempProfessor.first_name }</td>
	<td>${tempProfessor.last_name }</td>
	<td>${tempProfessor.phone }</td>
	<td>${tempProfessor.email }</td>
	<td>${tempProfessor.type }</td>
	<td><a href="${tempUrl }">Remove</a></td>
	<td><a href="${urlForUpdatingAProfessor }">Update</a></td>
	</tr>
</c:forEach>
<%System.out.println(request.getAttribute("professors"));%>
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
</main>

<%@ include file="templates/footer.html" %>

</body>
</html>

<!-- 
to do: images in the list and
categories of teacher
 -->