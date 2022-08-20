<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="architecture.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>test JSP page</title>
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

</body>
</html>