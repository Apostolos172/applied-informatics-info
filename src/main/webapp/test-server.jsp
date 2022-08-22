<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Server info</title>
</head>
<body>
 Tomcat Version : <%= application.getServerInfo() %><br>    
    Servlet Specification Version : 
<%= application.getMajorVersion() %>.<%= application.getMinorVersion() %> <br>    
    JSP version :
<%=JspFactory.getDefaultFactory().getEngineInfo().getSpecificationVersion() %><br>
</body>
</html>