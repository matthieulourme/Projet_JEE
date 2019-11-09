<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form method="post" action="UpdateContact">
		<label>Id</label> <input type="text" name="id"><br>
		<label>Nom</label> <input type="text" name="nom"><br>
		<label>Prénom</label> <input type="text" name="prenom"><br>
		<label>Email</label> <input type="email" name="email"><br>
		<input type="submit" value="Envoyer">
	</form>
</body>
</html>