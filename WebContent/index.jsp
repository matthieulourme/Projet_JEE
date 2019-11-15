<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="html" uri="http://struts.apache.org/tags-html" %>
<%@ taglib prefix="bean" uri="http://struts.apache.org/tags-bean" %>
<%@ taglib prefix="nested" uri="http://struts.apache.org/tags-nested" %>
<html:html>
<head>
<meta charset="ISO-8859-1">
<title>Login Page</title>
</head>
<body>

	<html:form action="/Login">
	<html:errors/>
	<label>Nom</label><input type="text" name="name"><br>
	<label>Password</label><input type="password" name="password"><br>
	<html:submit>Envoyer</html:submit>
	
	</html:form>
</body>
</html:html>