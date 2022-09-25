<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add professor</title>
<link rel="stylesheet" href="./styles/general.css">
<link rel="stylesheet" href="./styles/card.css">
<link rel="stylesheet" href="./styles/parallax-template.css">
<%@ include file="styles/loadFonts.html" %>

</head>
<body>
<%@ include file="templates/header.html" %>
<nav>
	<h2>Τμήμα Εφαρμοσμένης Πληροφορικής</h2>
	<h3>Τμήμα Εφαρμοσμένης Πληροφορικής / Ακαδημαϊκό Προσωπικό / Προσθήκη καθηγητή</h3>
</nav>
<main>
<form class="applied-informatics-info__card" action="ProfessorControllerServlet" method="post">
	<input type="hidden" name="command" value="add">
  	<label for="fname">First name: </label><br>
  	<input type="text" id="fname" name="fname" value="John"><br>
  	<label for="lname">Last name: </label><br>
  	<input type="text" id="lname" name="lname" value="Doe"><br>
  	<label for="email">Email: </label><br>
  	<input type="email" id="email" name="email" value="John@gmail.com"><br>
  	<label for="phone">Phone: </label><br>
  	<input type="text" id="phone" name="phone" value="12345678"><br><br>
  	<input type="submit" value="Πρόσθεσε">
</form>
</main>
<%@ include file="templates/footer.html" %>
</body>
</html>