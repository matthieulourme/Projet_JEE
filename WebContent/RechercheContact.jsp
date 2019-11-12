<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="html" uri="http://struts.apache.org/tags-html" %>
<%@ taglib prefix="bean" uri="http://struts.apache.org/tags-bean" %>
<%@ taglib prefix="nested" uri="http://struts.apache.org/tags-nested" %>


<html:html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>

</head>
<body>
	<html:form action="/RechercheContact">
	<html:errors/>
		<label>Email</label> <input type="text" name="mail"><br>
		<html:submit>Envoyer</html:submit>
	</html:form>
</body>
</html:html>