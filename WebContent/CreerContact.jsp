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
	<html:form action="/CreerContact">
	<html:errors/>
		<label>Noms</label> <input type="text" name="nom"><br>
		<label>Prénom</label> <input type="text" name="prenom"><br>
		<label>Email</label> <input type="email" name="email"><br>
		<label>Téléphone</label><input type="text" name="telephone"><br>
		<label>Adresse</label><input type="text" name="adresse"><br>
		<html:submit>Envoyer</html:submit>
	</html:form>
</body>
</html:html>