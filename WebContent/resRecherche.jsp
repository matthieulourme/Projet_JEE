<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="html" uri="http://struts.apache.org/tags-html" %>
<%@ taglib prefix="bean" uri="http://struts.apache.org/tags-bean" %>
<%@ taglib prefix="nested" uri="http://struts.apache.org/tags-nested" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>

<html:html>
	<head>
		<title><bean:message key="label_resultat_recherche_titre"/></title>
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script> 
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/js/bootstrap.min.js"></script>
    <link rel="stylesheet" href="/css/back.css"  type="text/css">
	</head>
	<body>
	<nav class="navbar navbar-expand-lg navbar-dark bg-primary">
	<a class="navbar-brand" href="#"><bean:message key="label_resultat_recherche_titre"/></a>
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
	<logic:notPresent name="infoContact">
	</logic:notPresent>
	
	<logic:present name="infoContact">
		<logic:empty name ="infoContact">
			<bean:message key="no_res"/>
		</logic:empty>
	</logic:present>
	
	<logic:present name="infoContact">
		<table class="table table-hover">
		<thead>
			<tr>
				<th scope="col"><bean:message key="tab_numero"/></th>
				<th scope="col"><bean:message key="tab_nom"/></th>
				<th scope="col"><bean:message key="tab_prenom"/></th>
				<th scope="col"><bean:message key="tab_email"/></th>
				<th scope="col"><bean:message key="tab_tel"/></th>
				<th scope="col"><bean:message key="tab_adr"/></th>
			</tr>
		</thead>
		<tbody>
			<logic:iterate id="contact" name="infoContact">
			<tr class="table-primary">
				<td scope="row"> <bean:write name="contact" property="id"/></td>
				<td scope="row"> <html:form action="/Contact">
							<html:errors/>
							<input type="hidden" name="id" value="<bean:write name="contact" property="id"/>" />
							<a href="Contact.jsp" onclick="parentNode.submit();"><bean:write name="contact" property="nom"/></a>
						</html:form></td>
				<td scope="row"> <bean:write name="contact" property="prenom"/></td>
				<td scope="row"> <bean:write name="contact" property="email"/></td>
				<td scope="row"> <bean:write name="contact" property="telephone"/></td>
				<td scope="row"> <bean:write name="contact" property="adresse"/></td>
			</tr>
			</logic:iterate>
			
		</tbody>
		</table>
	</logic:present>
	</body>
</html:html>