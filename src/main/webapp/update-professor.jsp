<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Update professor</title>
<link rel="stylesheet" href="./styles/general.css">
</head>
<body>
<form action="ProfessorControllerServlet" method="post">
	<input type="hidden" name="command" value="update">
	<input type="hidden" name="previousEmail" value="${professor.email }">
  	<label for="fname">First name: </label><br>
  	<input type="text" id="fname" name="fname" value="${professor.first_name }"><br>
  	<label for="lname">Last name: </label><br>
  	<input type="text" id="lname" name="lname" value="${professor.last_name }"><br>
  	<label for="email">Email: </label><br>
  	<input type="email" id="email" name="email" value="${professor.email }"><br>
  	<label for="phone">Phone: </label><br>
  	<input type="text" id="phone" name="phone" value="${professor.phone }"><br><br>
  	<input type="submit" value="Ενημέρωσε">
</form>
</body>
</html>