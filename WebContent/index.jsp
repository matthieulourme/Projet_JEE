<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="html" uri="http://struts.apache.org/tags-html" %>
<%@ taglib prefix="bean" uri="http://struts.apache.org/tags-bean" %>
<%@ taglib prefix="nested" uri="http://struts.apache.org/tags-nested" %>
<html:html>
<head>
<meta charset="ISO-8859-1">
<title><bean:message key="label_login_titre"/></title>

<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script> 
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/js/bootstrap.min.js"></script>
<link rel="stylesheet" href="css/style.css">

</head>
<body>
<div class="formulaire" style="center">
	<html:form action="/Login_">
	<html:errors property="login" />
	<html:errors property="name" />
	<html:errors property="password" />
	<label><bean:message key="tab_nom"/></label><input type="text" name="name"><br>
	<label><bean:message key="tab_mdp"/></label><input type="password" name="password"><br>
	<html:submit><bean:message key="form_envoyer"/></html:submit>
	
	</html:form>
</div>	
</body>
</html:html>