<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="architecture.*"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>test JSP page</title>
<style>
table, td, th {
	border: 1px solid brown;
	text-align: center;
	padding: 5px;
	margin: 5px;
}
</style>
</head>
<body>
<%
Professor p2 = new Professor("Γεώργιος", "Ευαγγελίδης", "69");
Associate p3 = new Associate("Κωνσταντίνος", "Βεργίδης", "98");
Assistant p4 = new Assistant("Γεωργία", "Κολωνιάρη", "67");
Dean p5 = new Dean("Αλέξανδρος", "Χατζηγεωργίου", "98");

out.println(p2.toString() + " " + p2.getInfo());
out.println("<br>");
out.println(p3.toString() + " " + p3.getInfo());
out.println("<br>");
out.println(p4.toString() + " " + p4.getInfo());
out.println("<br>");
out.println(p5.toString() + " " + p5.getInfo());
out.println("<br>");

%>
<a href="https://www.uom.gr/dai/akadhmaiko-prosopiko">See here for info about the professors</a>
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
</body>
</html>