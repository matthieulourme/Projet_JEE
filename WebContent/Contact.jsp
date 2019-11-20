<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="html" uri="http://struts.apache.org/tags-html" %>
<%@ taglib prefix="bean" uri="http://struts.apache.org/tags-bean" %>
<%@ taglib prefix="nested" uri="http://struts.apache.org/tags-nested" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<html:html>
<head>
<meta charset="ISO-8859-1">
<title><bean:message key="label_contact_titre"/></title>
<link rel="stylesheet" href="css/style.css">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootswatch/4.3.1/cosmo/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script> 
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/js/bootstrap.min.js"></script>
    <link rel="stylesheet" href="/css/back.css"  type="text/css">
</head>
<nav class="navbar navbar-expand-lg navbar-dark bg-primary">
<a class="navbar-brand" href="#"><bean:message key="label_contact_titre"/></a>
<div class="collapse navbar-collapse" id="navbarColor02"> 
<ul class="navbar-nav mr-auto">
  	<logic:iterate id="contact" name="infoContact">
  	<li class="nav-item">
  	<a class="nav-link" href="UpdateContact.do?userId=<bean:write name="contact" property="id"/>"><strong><bean:message key="update_contact"/></strong></a>
  	</li>
  	<li class="nav-item">
  	<a class="nav-link" href="CreerContactGroupe.do?userId=<bean:write name="contact" property="id"/>"><strong><bean:message key="contact_groupe"/></strong></a>
  	</li>
  	<li class="nav-item">
  	<a class="nav-link" href="menu.jsp"><strong><bean:message key="retour_menu"/></strong></a>
  	</li>
  	<li class="nav-item">
  	<a class="nav-link" href="accueil.jsp"><strong><bean:message key="label_deco"/></strong></a>
  	</li>
	</logic:iterate>
</ul>
</div>
</nav>
<br>
<body>
	<logic:iterate id="contact" name="infoContact">
		<h2><strong><bean:write name="contact" property="nom"/> <bean:write name="contact" property="prenom"/></strong></h2>
		<br><em><bean:message key="tab_email"/></em>: <bean:write name="contact" property="email"/><br>
		<br><em><bean:message key="tab_tel"/></em>: <bean:write name="contact" property="telephone"/><br>
		<br><em><bean:message key="tab_adr"/></em>: <bean:write name="contact" property="adresse"/><br>
		<html:form action="/SupprimerContact">
		<html:errors/>
			<input type="hidden" name="id" value="<bean:write name="contact" property="id"/>" />
			<input type="hidden" name="email" value="<bean:write name="contact" property="email"/>" />
			<a href="menu.jsp" onclick="parentNode.submit();"><strong><bean:message key="supp_contact"/></strong></a>
		</html:form>
	</logic:iterate>
</body>
</html:html>