<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="html" uri="http://struts.apache.org/tags-html" %>
<%@ taglib prefix="bean" uri="http://struts.apache.org/tags-bean" %>
<%@ taglib prefix="nested" uri="http://struts.apache.org/tags-nested" %>


<html:html>
<head>
<meta charset="ISO-8859-1">
<title><bean:message key="label_creer_contact_titre"/></title>

<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootswatch/4.3.1/cosmo/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script> 
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/js/bootstrap.min.js"></script>

    <link rel="stylesheet" href="css/style.css">
</head>
<nav class="navbar navbar-expand-lg navbar-dark bg-primary">
<a class="navbar-brand" href="#"><bean:message key="label_creer_contact_titre"/></a>
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
<div class="formulaire">
	<html:form action="/CreerContact_">
		<label><bean:message key="tab_nom"/></label> <input type="text" name="nom"> <html:errors property="nom" /><br>
		<label><bean:message key="tab_prenom"/></label> <input type="text" name="prenom"> <html:errors property="prenom" /><br>
		<label><bean:message key="tab_email"/></label> <input type="email" name="email"> <html:errors property="email" /><br>
		<label><bean:message key="tab_tel"/></label><input type="text" name="telephone"> <html:errors property="telephone" /><br>
		<label><bean:message key="tab_adr"/></label><input type="text" name="adresse"> <html:errors property="adresse" /><br>
		<html:submit><bean:message key="form_envoyer"/></html:submit>
	</html:form>
	</div>
</body>
</html:html>