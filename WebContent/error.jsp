<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="html" uri="http://struts.apache.org/tags-html" %>
<%@ taglib prefix="bean" uri="http://struts.apache.org/tags-bean" %>
<html:html>
	<head>
		<title><bean:message key="label_erreur_titre"/></title>
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script> 
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/js/bootstrap.min.js"></script>
  <link rel="stylesheet" href="css/style.css">
	</head>
	<nav class="navbar navbar-expand-lg navbar-dark bg-primary">
	<a class="navbar-brand" href="#"><bean:message key="label_erreur_titre"/></a>
	<div class="collapse navbar-collapse" id="navbarColor02"> 
	<ul class="navbar-nav mr-auto">
	  	<li class="nav-item">
	  	<a class="nav-link" href="menu.jsp"><strong><bean:message key="retour_menu"/></strong></a>
	  	</li>
	  	<li class="nav-item">
	  	<a class="nav-link" href="accueil.jsp"><strong><bean:message key="label_deco"/></strong></a>
	  	</li>
	</ul>
	</div>
	</nav>
	<br>
	<body>
		<h4><bean:message key="erreur_message"/><a href="accueil.jsp"><strong><bean:message key="erreur_message_accueil"/></strong></a></h4>
		<html:errors/><br/> 
	</body>
</html:html>
