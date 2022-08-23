<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add professor</title>
<link rel="stylesheet" href="./styles/general.css">
</head>
<body>
<form action="ProfessorControllerServlet" method="post">
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
</body>
</html>