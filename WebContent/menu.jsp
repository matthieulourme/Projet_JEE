<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="html" uri="http://struts.apache.org/tags-html" %>
<%@ taglib prefix="bean" uri="http://struts.apache.org/tags-bean" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<html:html>
<head>
<meta charset="ISO-8859-1">
<title><bean:message key="label_menu_titre"/></title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootswatch/4.3.1/cosmo/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script> 
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/js/bootstrap.min.js"></script>
</head>
<body>

<nav class="navbar navbar-expand-lg navbar-dark bg-primary">
<div class="collapse navbar-collapse" id="navbarColor02"> 
<ul class="navbar-nav mr-auto">
 
  <li class="nav-item dropdown">
    <a class="nav-link dropdown-toggle" data-toggle="dropdown" href="#" role="button" aria-haspopup="true" aria-expanded="false"><strong><bean:message key="afficher_groupe"/></strong></a>
    <div class="dropdown-menu" x-placement="bottom-start" style="position: absolute; will-change: transform; top: 0px; left: 0px; transform: translate3d(0px, 39px, 0px);">
     	<logic:iterate id="groupe" name="allGroupe">
						<html:form styleClass="form-inline my-2 my-lg-0" action="/Groupe">
							<html:errors/>
							<input class="form-control mr-sm-2" type="hidden" name="id" value="<bean:write name="groupe" property="id"/>" />
							<a class="dropdown-item" href="Groupe.jsp" onclick="parentNode.submit();"><strong><bean:write name="groupe" property="nom"/></strong></a>
						</html:form>
		</logic:iterate>
	
    </div>
    </li>
    <li class="nav-item">
    <a  class="nav-link" href="CreerContact.do"><strong><bean:message key="creer_contact"/></strong></a>
  	</li>
 	 <li class="nav-item">
    <a class="nav-link" href="RechercheContact.do"><strong><bean:message key="recherche_contact"/></strong></a>
  	</li>
  	<li class="nav-item">
  	<a class="nav-link" href="CreerGroupe.do"><strong><bean:message key="creer_groupe"/></strong></a>
  	</li>
  	<li class="nav-item">
  	<a class="nav-link" href="SupprimerGroupe.do"><strong><bean:message key="supp_groupe"/></strong></a>
  	</li>
</ul>
</div>
</nav>

	<br>
	<br>
	
	
	
	
	

	
	<logic:present name="allContact">
		<logic:empty name="allContact">
			<bean:message key="no_conatct"/>
		</logic:empty>
	</logic:present>
	
	<logic:present name="allContact">
		<h4><bean:message key="titre_contact"/></h4>
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
				<logic:iterate id="contact" name="allContact">
					<tr class="table-primary">
						<td> <bean:write name="contact" property="id"/></td>
						<td>
						<html:form action="/Contact">
							<html:errors/>
							<input type="hidden" name="id" value="<bean:write name="contact" property="id"/>" />
							<a href="Contact.jsp" onclick="parentNode.submit();"><bean:write name="contact" property="nom"/></a>
						</html:form>
						</td>
						<td> <bean:write name="contact" property="prenom"/></td>
						<td> <bean:write name="contact" property="email"/></td>
						<td> <bean:write name="contact" property="telephone"/></td>
						<td> <bean:write name="contact" property="adresse"/></td>
					</tr>
				</logic:iterate>
			</tbody>
		</table>
	</logic:present>
<br>

	
</body>
</html:html>